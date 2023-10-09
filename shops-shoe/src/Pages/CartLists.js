import './CartLists.css'
import React from 'react'
import { Container, Table, Row, Button } from "react-bootstrap";
import { useEffect, useState } from "react";
import Cart from '../Components/Cart/Cart';
import { connect } from "react-redux";
import userService from '../Service/user-service';
import authService from '../Service/auth-service';
import { useNavigate } from 'react-router-dom';
import { adjustInitDataProduct } from "../Redux/CartAction";
import Swal from "sweetalert2";

function CartLists(props) {

  let cart = props.cart;

  let adjustInitDataProduct = props.adjustInitDataProduct

  let navigate = useNavigate();

  const [totalPrice, setTotalPrice] = useState(0);

  useEffect(() => {
    let price = 0;
    cart.forEach((item) => {
      price += item.qty * item.newPrice;
    });
    setTotalPrice(price);
  }, [cart]);

  const checkOut = () => {
    if (!authService.checkTokenExpirationMiddleware()) {
      navigate("/login");
    } else {
      const listProducts = [];
      for (let i = 0; i < cart.length; i++) {
        listProducts.push({ id: cart[i].id, qty: cart[i].qty });
      }
      userService.getCheckBill(listProducts).then((response) => {
        if (response.data.length > 0) {
          adjustInitDataProduct(response.data);
        } else {
          const userName = authService.getCurrentUser().sub
          console.log(userName)
          userService.getPayBill(userName, listProducts).then(() => {
            // navigate("/");  
            // window.location.reload();
            Swal.fire({
              title: "Success",
              text: "Alert successful",
              icon: "success",
              confirmButtonText: "OK",
            }).then(function () {
              navigate("/");
              window.location.reload();
            });
          }, error => {
            alert(error.toString)
          })
        }
      },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          alert(resMessage);
        }
      );
    }
  }

  return (
    <div className="productSlider mb-5 mt-5">
      <Container>
        <h5 className="text-left mb-4 ps-2">Cart List</h5>
        <Row>
          <div className="col-9 cartShow">
            <Table className='table-price' bordered hover responsive="sm">
              <thead>
                <tr>
                  <th>Product Img</th>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Sub Total</th>
                  <th>Action</th>
                </tr>
                {cart.map((product) => (
                  <Cart product={product} />
                ))}

              </thead>
              <tbody>
              </tbody>
            </Table>
          </div>
          <div id='total-price' className="col-3 cartSum boxShadaw bg-light p-4">
            <h5 className="text-left mb-4 pb-2">Cart Price</h5>
            <div className="d-flex justify-content-between fw-bold">
              <h6>Total Price :</h6>
              <span>{totalPrice}$</span>
            </div>
            <Button variant="dark" size="md" className="mt-4 w-100" onClick={checkOut}>
              pay now
            </Button>
          </div>
        </Row>
      </Container>
    </div>
  );
}
const mapStateToProps = (state) => {
  return {
    cart: state.rCart.cart
  };
};
const mapDispatchToProps = (dispatch) => {
  return {
    adjustInitDataProduct: (theItems) => dispatch(adjustInitDataProduct(theItems)),
  };
};
export default connect(mapStateToProps, mapDispatchToProps)(CartLists);
