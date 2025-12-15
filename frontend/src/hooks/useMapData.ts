import { useState, useEffect } from "react";
import { getUserLocation } from "../api/geolocationApi";
import { getNearbyStations } from "../api/stationApi";
import { Station } from "../types/station";

interface UserLocation {
  lat: number;
  lng: number;
}

export const useMapData = () => {
    const [userLocation, setUserLocation] = useState<UserLocation | null>(null);
    const [mapCenter, setMapCenter] = useState<UserLocation | null>(null);
    const [isLoading, setIsLoading] = useState<boolean>(true);
    const [nearbyStations, setNearbyStations] = useState<Station[]>([]);

    useEffect(() => {
        const fetchUserLocation = async () => {
            try {
                const locationData = await getUserLocation();
                setUserLocation(locationData);
                setMapCenter(locationData);
            } catch (error) {
                console.error("위치 정보를 불러오는 중에 오류가 발생했습니다.", error);
                const defaultLocation = { lat: 37.5139, lng: 127.1022 };
                setUserLocation(defaultLocation);
                setMapCenter(defaultLocation);
            }
        };
        fetchUserLocation();
    }, []);

    useEffect(() => {
        if (!userLocation) {
            return;
        }
        fetchNearbyStations(userLocation.lat, userLocation.lng);
    }, [userLocation]);

    const fetchNearbyStations = async (lat: number, lng: number) => {
        setIsLoading(true);
        try {
            const data = await getNearbyStations(lat, lng);
            setNearbyStations(data);
        } catch (error) {
            console.error("근처 대여소 정보를 불러오는 중에 오류가 발생했습니다.", error);
        } finally {
            setIsLoading(false);
        }
    };

    const searchAtLocation = (lat: number, lng: number) => {
        fetchNearbyStations(lat, lng);
    };

    return { 
        userLocation, 
        nearbyStations, 
        isLoading,
        mapCenter,
        setMapCenter,
        searchAtLocation
    };
}