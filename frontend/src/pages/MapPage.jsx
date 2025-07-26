import { NavermapsProvider } from 'react-naver-maps';
import MapContainer from "../components/MapContainer.jsx";

export default function MapPage() {
    const naverMapsClientId = import.meta.env.VITE_NAVER_MAP_CLIENT_ID;

    const pageStyle = {
        display: 'flex',
        flexDirection: 'column',
        width: '100%',
        height: '100vh',
    };

    const headerStyle = {
        padding: '10px',
        margin: 0
    };

    return (
        <NavermapsProvider ncpKeyId={naverMapsClientId}>
            <div style={pageStyle}>
                <h3 style={headerStyle}>따맵</h3>
                <MapContainer />
            </div>
        </NavermapsProvider>
    );
}