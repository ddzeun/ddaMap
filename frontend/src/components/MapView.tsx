import { Container as MapDiv, NaverMap, Marker, useNavermaps } from "react-naver-maps";
import { Station } from "../types/station";

interface MapViewProps {
    center: { lat: number; lng: number };
    userLocation: { lat: number; lng: number };
    stations: Station[];
    onMarkerClick: (station: Station) => void;
    onCenterChange: (center: { lat: number; lng: number }) => void;
}

export default function MapView({ 
    center,
    userLocation, 
    stations, 
    onMarkerClick,
    onCenterChange 
}: MapViewProps) {
    const navermaps = useNavermaps();

    return (
        <div style={{ position: 'relative', width: '100%', height: '100%' }}>
            <MapDiv style={{ width: '100%', height: '100%' }}>
                <NaverMap 
                    center={center} 
                    defaultZoom={15}
                    onCenterChanged={(newCenter) => {
                        onCenterChange({
                            lat: newCenter.y,
                            lng: newCenter.x
                        });
                    }}
                >
                    <Marker 
                        position={userLocation}
                        icon={{
                            content: '<div style="background-color: #FF0000; width: 10px; height: 10px; border-radius: 50%; border: 1px solid white; box-shadow: 0 1px 2px rgba(0,0,0,0.3);"></div>',
                            anchor: new navermaps.Point(11, 11)
                        }}
                    />

                    {stations.map(station => (
                        <Marker
                            icon={{
                                content: `
                                        <div style="
                                            position: relative;
                                            width: 24px;
                                            height: 24px;
                                            background: #fff;
                                            border: 2px solid #000;
                                            border-radius: 4px;
                                            box-sizing: border-box;
                                            display: flex;
                                            align-items: center;
                                            justify-content: center;
                                            font-size: 12px;
                                            font-weight: bold;
                                            color: #000;
                                        ">
                                            0 
                                        <div style="
                                            position: absolute;
                                            bottom: -5px;
                                            left: 50%;
                                            width: 8px;
                                            height: 8px;
                                            background: #fff;
                                            border-right: 2px solid #000;
                                            border-bottom: 2px solid #000;
                                            transform: translateX(-50%) rotate(45deg);
                                            box-sizing: border-box;
                                        "></div>
                                    </div>
                                `,
                                anchor: new navermaps.Point(12, 30)
                            }}
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