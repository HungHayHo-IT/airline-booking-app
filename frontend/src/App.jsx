import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Navbar from "./components/common/Navbar";
import Footer from "./components/common/Footer";
import RegisterPage from "./components/auth/RegisterPage";
import LoginPage from "./components/auth/LoginPage";
import HomePage from "./components/pages/HomePage";
import FindFlightsPage from "./components/pages/FindFlightsPage";
import ProfilePage from "./components/profile/ProfilePage";
import { RouteGuard } from "./services/RouteGuard";
import UpdateProfilePage from "./components/profile/UpdateProfilePage";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <div className="content">
        <Routes>
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/login" element={<LoginPage />} />

          <Route path="/home" element={<HomePage />} />
          <Route path="/flights" element={<FindFlightsPage />} />

          <Route
            path="/profile"
            element={
              <RouteGuard
                allowedRoles={["CUSTOMER"]}
                element={<ProfilePage />}
              />
            }
          />
          <Route
            path="/update-profile"
            element={
              <RouteGuard
                allowedRoles={["CUSTOMER"]}
                element={<UpdateProfilePage />}
              />
            }
          />
        </Routes>
      </div>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
