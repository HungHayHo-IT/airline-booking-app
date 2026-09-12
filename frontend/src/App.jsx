import { BrowserRouter, Routes } from "react-router-dom";
import "./App.css";
import Navbar from "./components/common/Navbar";

function App() {
  return (
    <BrowserRouter>
      <Navbar>
        <div className="content">
          <Routes>{/* <Route path="/home" element={<Home />} /> */}</Routes>
        </div>
      </Navbar>
    </BrowserRouter>
  );
}

export default App;
