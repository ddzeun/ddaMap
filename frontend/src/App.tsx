import MapContainer from './components/MapContainer';
import { NavermapsProvider } from 'react-naver-maps';
import SearchBar from './components/SearchBar';
import BottomNav from './components/BottomNav';
import './App.css';

function App() {
    const naverMapsClientId = import.meta.env.VITE_NAVER_MAP_CLIENT_ID;

    return (
        <NavermapsProvider ncpKeyId={naverMapsClientId}>
            <div className="App">
                <div className="App-container">
                    <SearchBar />
                    <MapContainer />
                    <BottomNav />
                </div>
            </div>
        </NavermapsProvider>
    );
}

export default App;