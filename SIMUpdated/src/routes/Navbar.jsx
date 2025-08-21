import { useDispatch, useSelector } from "react-redux";
import { Link, Outlet } from "react-router-dom";
import { validateLogout } from "../features/loginSuccessful/loginSlice";

function Navbar() {
  const logOutNavBar = useSelector((store) => store).accountLogin.isValidLogin;
  const role = useSelector((store) => store).accountLogin.roleId;
  const dispatch = useDispatch();
  console.log(logOutNavBar);
  console.log("coming navbar role id is.." + role);
  function handleLogOut() {
    localStorage.removeItem("roleId");
    dispatch(validateLogout());
  }
  return (
    <div>
      <style>
        {`
          .nav-item.dropdown:hover .dropdown-menu {
            display: block;
          }
          .dropdown-menu {
            background-color: #343a40; /* Dark dropdown */
          }
          .dropdown-item {
            color: #fff; /* White text */
          }
          .dropdown-item:hover {
            background-color: #495057; /* Slightly lighter on hover */
            color: #fff;
          }
        `}
      </style>
      <nav
        className="navbar navbar-expand-lg navbar-dark bg-dark"
        //   style={{ backgroundColor: "#6f42c1" }}
      >
        <div className="container-fluid">
          <Link className="navbar-brand" to="user">
            Users
          </Link>
          {/* <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button> */}
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav ms-auto">
              {!logOutNavBar ? (
                <>
                  <li className="nav-item">
                    <Link className="nav-link" to="login">
                      <span className="text-white">Login</span>
                    </Link>
                  </li>
                  {/* <li className="nav-item">
                        <Link className="nav-link"to='claimPolicy'>Claim Policies</Link>
                    </li> */}
                  <li className="nav-item">
                    <Link className="nav-link" to="register">
                      <span className="text-white">Register</span>
                    </Link>
                  </li>
                </>
              ) : (
                <>
                  {role === 1 && (
                    <>
                      <li className="nav-item">
                        <Link className="nav-link" to="/user/viewComplaints">
                          <span className="text-white">View Complaints</span>
                        </Link>
                      </li>
                      <li className="nav-item">
                        <Link
                          className="nav-link"
                          to="/user/viewComplaintStatus"
                        >
                          <span className="text-white">View Status</span>
                        </Link>
                      </li>
                      <li className="nav-item">
                        <Link className="nav-link" to="/user/registerComplaint">
                          <span className="text-white">Register Complaint</span>
                        </Link>
                      </li>
                    </>
                  )}
                  {role === 3 && (
                    <li className="nav-item dropdown">
                      <a
                        className="nav-link dropdown-toggle text-white"
                        // href="#"
                        id="adminDropdown"
                        role="button"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                      >
                        Admin Menu
                      </a>
                      <ul
                        className="dropdown-menu dropdown-menu-end"
                        aria-labelledby="adminDropdown"
                      >
                        <li>
                          <Link className="dropdown-item" to="/admin/dashboard">
                            Dashboard
                          </Link>
                        </li>
                        <li>
                          <Link
                            className="dropdown-item"
                            to="/admin/manageUsers"
                          >
                            Manage Users
                          </Link>
                        </li>
                        <li>
                          <Link
                            className="dropdown-item"
                            to="/admin/manageCategories"
                          >
                            Manage Categories
                          </Link>
                        </li>
                        {/* <li>
                          <Link className="dropdown-item" to="/admin/reports">
                            Reports
                          </Link>
                        </li> */}
                      </ul>
                    </li>
                  )}

                  <li className="nav-item">
                    <Link
                      className="nav-link"
                      to="/login"
                      onClick={handleLogOut}
                    >
                      <span className="text-white">Logout</span>
                    </Link>
                  </li>
                </>
              )}
            </ul>
          </div>
        </div>
      </nav>
      <Outlet></Outlet>
    </div>
  );
}

export default Navbar;
