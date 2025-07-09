import { Container as MapDiv, NaverMap, Marker, useNavermaps } from "react-naver-maps";
import { useState, useEffect } from "react";
import { getNearbyStations } from "../api/stationApi.js";
import { getUserLocation } from "../api/geolocationApi.js";

export default function MapContainer() {

    const navermaps = useNavermaps();
    const [userLocation, setUserLocation] = useState(null);
    const [nearbyStations, setNearbyStations] = useState([]);
    const [isLoading, setIsLoading] = useState(true);

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

    if (isLoading || !userLocation) {
        return <div>지도 로딩 중...</div>;
    }

    return (
        <MapDiv style={{ width: '80vw', height: '80vh' }}>
            <NaverMap center={userLocation} defaultZoom={15}>
                <Marker position={userLocation} />

                {nearbyStations.map(station => (
                    <Marker
                        key={station.stnId}
                        position={new navermaps.LatLng(station.latitude, station.longitude)}
                    />
                ))}
            </NaverMap>
        </MapDiv>
    );
}