import axios from "axios";
import jwtDecode from "jwt-decode";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(username, password) {
    return axios
    .post(API_URL + "signin",{username,password})
      .then((response) => {
        if (response.data.token) {
        localStorage.setItem("user", JSON.stringify(response.data));
      }
        return response.data;
      });
  }
  register(username, email , address , password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      address,
      password,
    });
  }
  checkTokenExpirationMiddleware () {
    const token =
      JSON.parse(localStorage.getItem("user")) &&
      JSON.parse(localStorage.getItem("user"))["token"];
    if ( !token || jwtDecode(token).exp < Date.now() / 1000) {
      localStorage.clear();
      return false;
    }
    return true;
  };
  
  logout = () => {
    localStorage.removeItem("user");
  };

  getCurrentUser = () => {
    const token =
      JSON.parse(localStorage.getItem("user"))&&
      JSON.parse(localStorage.getItem("user"))["token"];
    return jwtDecode(token);
  };
}

export default new AuthService();