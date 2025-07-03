import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

export const getAllStations = async() => {
    try {
        const response = await axios.get(`${API_BASE_URL}/api/v1/stations`);
        return response.data;
    } catch (error) {
        console.error("Error fetching stations: ", error);
        throw error;
    }
}