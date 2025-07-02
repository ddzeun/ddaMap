import React, { useEffect } from 'react';
import { getAllStations } from './api/stationApi';

function App() {

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

  return (
    <>
      <h1>따맵</h1>

    </>
  )
}

export default App;
