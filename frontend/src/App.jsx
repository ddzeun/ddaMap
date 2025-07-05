import React, { useEffect } from 'react';
import { getAllStations } from './api/stationApi';
import MapContainer from './components/MapContainer';
import { NavermapsProvider } from 'react-naver-maps';

function App() {

  const naverMapsClientId = import.meta.env.VITE_NAVER_MAP_CLIENT_ID;

/*

  useEffect(() => {    
    const fetchStations = async () => {
      try {
        const stations = await getAllStations();
        console.log("백엔드에서 받아온 대여소 목록: ", stations);
      } catch (error) {
        console.error("API 호출 실패: ", error);
      }
    };
    fetchStations();
  }, []);
*/

  return (
    <NavermapsProvider ncpKeyId={ naverMapsClientId }>
      <div style={{ width: '100vw', height: '100vh' }} >
        <h1>따맵</h1>
        <MapContainer />
      </div>
    </NavermapsProvider>
  )
}

export default App;
