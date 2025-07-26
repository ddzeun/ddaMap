import {useMapData} from "../hooks/useMapData.js";
import {useState} from "react";
import StationDetail from "./StationDetail.jsx";
import MapView from "./MapView.jsx";

export default function MapContainer() {

    const { userLocation, nearbyStations, isLoading } = useMapData();
    const [selectedStation, setSelectedStation] = useState(null);

    const handleMarkerClick = (station) => {
        setSelectedStation(station);
    }

    const handlePanelClose = () => {
        setSelectedStation(null);
    }

    if (isLoading) {
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