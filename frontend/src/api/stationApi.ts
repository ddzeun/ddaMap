import axios from "axios";

import { Station } from "../types/station";

const API_BASE_URL = "http://localhost:8080";

export const getAllStations = async(): Promise<Station[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/api/v1/stations`);
        return response.data;
    } catch (error) {
        console.error("Error fetching stations: ", error);
        throw error;
    }
}

export const getNearbyStations = async(lat: number, lng: number): Promise<Station[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/api/v1/stations/nearby?lat=${lat}&lng=${lng}`);
        return response.data;
    } catch (error) {
        console.error("Error fetching nearby stations: ", error);
        throw error;
    }
}