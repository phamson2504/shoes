import Products from '../Products/Products';
import Brands from '../Brand/Brands';


function Home(props) {
  return (
    <>
      <Brands handleClick={props.clickProduct}/>
      <Products result={props.result}/>
    </>
  );
}

export default Home;
