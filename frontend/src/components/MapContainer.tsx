import { useMapData } from "../hooks/useMapData.js";
import { useState } from "react";
import StationDetail from "./StationDetail";
import MapView from "./MapView";
import { Station } from "../types/station";

export default function MapContainer() {
    const { userLocation, nearbyStations, isLoading } = useMapData();
    const [selectedStation, setSelectedStation] = useState<Station | null>(null);

    const handleMarkerClick = (station: Station) => {
        setSelectedStation(station);
    }

    const handlePanelClose = () => {
        setSelectedStation(null);
    }

    if (isLoading || !userLocation) {
        return <div>지도 로딩중 ... </div>
    }

    return (
        <div style={{ position: 'relative', width: '100%', height: 'calc(100% - 50px)' }}>
            <MapView
                userLocation={userLocation}
                stations={nearbyStations}
                onMarkerClick={handleMarkerClick}
            />
            {selectedStation && (
                <StationDetail
                    station={selectedStation}
                    onClose={handlePanelClose}
                />
            )}
        </div>
    )
}