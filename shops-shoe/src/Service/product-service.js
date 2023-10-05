import axios from "axios";

const API_URL = "http://localhost:8080/api/shoes/";

class ProductService {
    getProduct() {
        return axios.get(API_URL + "allData");
    }
}

export default ProductService();