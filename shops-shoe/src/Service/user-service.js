import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/checkBill/";

class UserService {
  getCheckBill(productCheck) {
    return axios.post(API_URL + "getDetail", productCheck, { headers: authHeader() });
  }
  getPayBill(userName,products) {
    return axios.post(API_URL +"payBill/" +userName, products, { headers: authHeader() })
  }
}

export default new UserService();