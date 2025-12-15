import { useMapData } from "../hooks/useMapData";
import { useState } from "react";
import StationDetail from "./StationDetail";
import MapView from "./MapView";
import MyLocationButton from "./MyLocationButton";
import SearchHereButton from "./SearchHereButton";
import { Station } from "../types/station";

export default function MapContainer() {
    const { 
        userLocation, 
        nearbyStations, 
        isLoading, 
        searchAtLocation,
        mapCenter,
        setMapCenter
    } = useMapData();
    
    const [selectedStation, setSelectedStation] = useState<Station | null>(null);
    const [showSearchHere, setShowSearchHere] = useState<boolean>(false);

    const handleMarkerClick = (station: Station) => {
        setSelectedStation(station);
    }

    const handlePanelClose = () => {
        setSelectedStation(null);
    }

    const handleMapCenterChange = (newCenter: { lat: number; lng: number }) => {
        setMapCenter(newCenter);
        // 사용자 위치와 다른 위치로 이동했는지 확인
        if (userLocation) {
            const distance = Math.sqrt(
                Math.pow(newCenter.lat - userLocation.lat, 2) + 
                Math.pow(newCenter.lng - userLocation.lng, 2)
            );
            // 약 0.001도 이상 차이나면 (약 100m) 버튼 표시
            setShowSearchHere(distance > 0.001);
        }
    }

    const handleMyLocationClick = () => {
        if (userLocation) {
            setMapCenter(userLocation);
            setShowSearchHere(false);
        }
    }

    const handleSearchHere = () => {
        if (mapCenter) {
            searchAtLocation(mapCenter.lat, mapCenter.lng);
            setShowSearchHere(false);
        }
    }

    if (isLoading || !userLocation) {
        return (
            <div style={{
                width: '100%',
                height: '100%',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                fontSize: '16px',
                color: '#666'
            }}>
                지도 로딩중 ...
            </div>
        );
    }

    return (
        <div style={{ position: 'relative', width: '100%', height: '100%' }}>
            <MapView
                center={mapCenter || userLocation}
                userLocation={userLocation}
                stations={nearbyStations}
                onMarkerClick={handleMarkerClick}
                onCenterChange={handleMapCenterChange}
            />
            
            <MyLocationButton onClick={handleMyLocationClick} />
            
            {showSearchHere && (
                <SearchHereButton onClick={handleSearchHere} />
            )}
            
            {selectedStation && (
                <StationDetail
                    station={selectedStation}
                    onClose={handlePanelClose}
                />
            )}
        </div>
    );
}