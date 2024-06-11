import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Register from "./components/Register";
import ResetPassword from "./components/ResetPassword";
import AddProduct from "./components/AddProduct";
import UpdateProductForm from "./components/UpdateProduct";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<AddProduct />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/resetPassword" element={<ResetPassword />} />
          <Route path="/addProduct" element={<AddProduct />} />
          <Route path="/updateProduct/:productId" element={<UpdateProductForm />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
