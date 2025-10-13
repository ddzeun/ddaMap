import { Container as MapDiv, NaverMap, Marker, useNavermaps } from "react-naver-maps";
import { Station } from "../types/station";

interface MapViewProps {
    userLocation: { lat: number; lng: number };
    stations: Station[];
    onMarkerClick: (station: Station) => void;
}

export default function MapView({ userLocation, stations, onMarkerClick}: MapViewProps) {

    const navermaps = useNavermaps();

    return (
        <div style={{ position: 'relative', width: '100%', height: 'calc(100% - 50px)' }}> {/* h1 높이만큼 빼주기 */}
            <MapDiv style={{ width: '100%', height: '100%' }}>
                <NaverMap center={userLocation} defaultZoom={15}>
                    <Marker position={userLocation} />

                    {stations.map(station => (
                        <Marker
                            key={station.stnId}
                            position={new navermaps.LatLng(station.latitude, station.longitude)}
                            onClick={() => onMarkerClick(station)}
                        />
                    ))}
                </NaverMap>
            </MapDiv>
        </div>
    );
}