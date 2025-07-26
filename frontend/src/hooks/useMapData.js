import { useState, useEffect } from "react";
import {getUserLocation} from "../api/geolocationApi.js";
import {getNearbyStations} from "../api/stationApi.js";

export const useMapData = () => {

    const [userLocation, setUserLocation] = useState(null);
    const [isLoading, setIsLoading] = useState(true);
    const [nearbyStations, setNearbyStations] = useState([]);

    useEffect(() => {
        const fetchUserLocation = async () => {
            try {
                const locationData = await getUserLocation();
                setUserLocation(locationData);
            } catch (error) {
                console.error("위치 정보를 불러오는 중에 오류가 발생했습니다.", error);
                setUserLocation({ lat: 37.5139, lng: 127.1022 });
            }
        };
        fetchUserLocation();
    }, []);

    useEffect(() => {
        if (!userLocation) {
            return;
        }
        const fetchNearbyStations = async () => {
            setIsLoading(true);
            try {
                const data = await getNearbyStations(userLocation.lat, userLocation.lng);
                setNearbyStations(data);
                console.log(data);
                console.log(nearbyStations);
            } catch (error) {
                console.error("근처 대여소 정보를 불러오는 중에 오류가 발생했습니다.", error);
            } finally {
                setIsLoading(false);
            }
        };
        fetchNearbyStations();
    }, [userLocation]);

    return { userLocation, nearbyStations, isLoading}
}