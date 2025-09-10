import axios from "axios";

// Base URL of your Spring Boot backend
const API_BASE = "http://localhost:8080/api";

export const getShowrooms = () => axios.get(`${API_BASE}/showrooms`);
export const addShowroom = (data) => axios.post(`${API_BASE}/showrooms`, data);

export const getEmployees = () => axios.get(`${API_BASE}/employees`);
export const addEmployee = (data) => axios.post(`${API_BASE}/employees`, data);
export const getEmployeesByShowroom = (id) => axios.get(`${API_BASE}/employees/showroom/${id}`);

export const getCars = () => axios.get(`${API_BASE}/cars`);
export const addCar = (data) => axios.post(`${API_BASE}/cars`, data);
export const getCarsByShowroom = (id) => axios.get(`${API_BASE}/cars/showroom/${id}`);
