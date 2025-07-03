import { Container as MapDiv, NaverMap, Marker } from "react-naver-maps"

export default function MapContainer() {

    return (
        <MapDiv 
            style={{ width: '100vw', height: '600vh' }}>
                <NaverMap
                    defaultCenter={{ lat: 37.5139, lng: 127.1022 }}
                    defaultZoom={ 15 }>
                    <Marker defaultPosition={{ lat: 37.5139, lng: 127.1022 }} />
                </NaverMap>
        </MapDiv>
    )
}
