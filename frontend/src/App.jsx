import './App.css';
import {Route, Routes} from "react-router-dom";
import MapPage from "./pages/MapPage.jsx";

function App() {

    return (
        <Routes>
            <Route path="/" element={<MapPage /> } />
        </Routes>
    );
}

export default App;
