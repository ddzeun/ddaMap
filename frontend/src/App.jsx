import MapContainer from './components/MapContainer';
import { NavermapsProvider } from 'react-naver-maps';
import './App.css';

function App() {
    const naverMapsClientId = import.meta.env.VITE_NAVER_MAP_CLIENT_ID;


    return (
        <NavermapsProvider ncpKeyId={naverMapsClientId}>
            <div className="App">
                <div className="App-container">
                    <h1>따맵</h1>
                    <MapContainer/>
                </div>
            </div>
        </NavermapsProvider>
    );
}

export default App;
