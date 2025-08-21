import logo from "./logo.svg";
import "./App.css";
import Login from "./routes/Login";
import { Route, Routes } from "react-router-dom";
import Home from "./routes/HomeCitizen";
import PrivateRoute from "./Components/PrivateRoute";
import Register from "./routes/Register";
import Navbar from "./routes/Navbar";
import { useSelector } from "react-redux";
import HomeCitizen from "./routes/HomeCitizen";
import HomeZoneOperator from "./routes/HomeZoneOperator";

import ViewComplaints from "./routes/UserViewComplaints";
import UserRegisterComplaint from "./routes/UserRegisterComplaint";
import UserComplaintStatus from "./routes/UserComplaintStatus";
import DashboardAdmin from "./routes/AdminDashboard";
import AdminManageUsers from "./routes/AdminManageUsers";
import AdminManageCategories from "./routes/AdminManageCategories";

function App() {
  const role = useSelector((store) => store).accountLogin.roleId;
  console.log("value of role is", role);

  return (
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>

    <div>
      <Routes>
        {/* <Route> */}
        <Route path="/" element={<Navbar />}>
          <Route path="register" element={<Register />}></Route>
          <Route path="login" element={<Login />}></Route>
          <Route
            path="/admin/dashboard"
            element={
              <PrivateRoute>
                <DashboardAdmin></DashboardAdmin>
              </PrivateRoute>
            }
          ></Route>
          <Route
            path="/admin/manageUsers"
            element={
              <PrivateRoute>
                <AdminManageUsers></AdminManageUsers>
              </PrivateRoute>
            }
          ></Route>
          <Route
            path="/admin/manageCategories"
            element={
              <PrivateRoute>
                <AdminManageCategories></AdminManageCategories>
              </PrivateRoute>
            }
          ></Route>
          <Route
            path="/operator"
            element={
              <PrivateRoute>
                <HomeZoneOperator></HomeZoneOperator>
              </PrivateRoute>
            }
          ></Route>
          <Route
            path="/user"
            element={
              <PrivateRoute>
                <HomeCitizen></HomeCitizen>
              </PrivateRoute>
            }
          >
            <Route
              path="/user/viewComplaints"
              element={
                <PrivateRoute>
                  <ViewComplaints></ViewComplaints>
                </PrivateRoute>
              }
            ></Route>
            <Route
              path="/user/viewComplaintStatus"
              element={
                <PrivateRoute>
                  <UserComplaintStatus></UserComplaintStatus>
                </PrivateRoute>
              }
            ></Route>
            <Route
              path="/user/registerComplaint"
              element={
                <PrivateRoute>
                  <UserRegisterComplaint></UserRegisterComplaint>
                </PrivateRoute>
              }
            ></Route>
          </Route>
        </Route>
        {/* </Route> */}
      </Routes>
    </div>
  );
}

export default App;
