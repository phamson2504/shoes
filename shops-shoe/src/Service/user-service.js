import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/";

class UserService {
  getPublicContent() {
    return axios.get(API_URL + "all");
  }

  getHelloWorld() {
    return axios.get(API_URL + "hello", { headers: authHeader() });
  }
}

export default new UserService();