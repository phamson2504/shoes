import * as actionTypes from "./CartType";

const INITIAL_STATE = {
  allProducts: [], //products without qty
  cart: [], //product with added qty
  currentItem: null,
};
const cartReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case actionTypes.ADD_TO_CART:
      let item = state.allProducts.find(
        (prod) => prod.id === action.payload.id
      );

      if (!item) {
        state.allProducts.push(action.payload.item);
        item = action.payload.item;
      }

      const checkItemLimit = state.cart.find(
        (item) => item.qty === action.payload.item.maxQuantity && item.id === action.payload.item.id
      );

      if (checkItemLimit) {
        alert("Sorry, the quantity for this product is finished");
        let btn = action.payload.event.currentTarget;
        btn.setAttribute("disabled", "true");
        btn.classList.remove("btn-dark");
        btn.classList.toggle("btn-secondary");
        btn.innerHTML = "Sold Out";
        return state;
      }

      const inCart = state.cart.find((item) =>
        item.id === action.payload.id ? true : false
      );

      return {
        ...state,
        cart: inCart
          ? state.cart.map((item) =>
            item.id === action.payload.id
              ? { ...item, qty: item.qty + 1 }
              : item
          )
          : [...state.cart, { ...item, qty: 1 }],
      };
    case actionTypes.ADJUST_QUANTITY:
      return {
        ...state,
        cart: state.cart.map(item =>
          item.id === action.payload.id
            ? { ...item, qty: action.payload.qty }
            : item)
      }
    case actionTypes.DELETE_FROM_CART:
      return {
        ...state,
        cart: state.cart.filter((item) =>
          item.id !== action.payload.id),
      }
    case actionTypes.ADJUST_INIT_ITEMS:
      const itemAdjust = action.payload.items;
      let productBfAdjust = state.allProducts;
      let cartBfAdjust = state.cart;
      for(let i = 0 ; i < itemAdjust.length ; i++){
        productBfAdjust = productBfAdjust.map((item) => 
        item.id === itemAdjust[i].id ?  itemAdjust[i] : item)
        cartBfAdjust = cartBfAdjust.map(item =>
            item.id === itemAdjust[i].id
              ? { ...item, qty: itemAdjust[i].maxQuantity, maxQuantity: itemAdjust[i].maxQuantity }
              : item)    
      }

      return {...state,cart:cartBfAdjust,allProducts:productBfAdjust}
    default:
      return state;
  }
}

export default cartReducer;