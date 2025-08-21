import React, { useEffect, useState } from "react";
import { Navigate, useLocation } from "react-router-dom";
import Cookies from "js-cookie";

// import { useContext } from "react";  
import { useDispatch } from "react-redux";
import { validateLogin, validateLogout } from "../features/loginSuccessful/loginSlice";
// import { configURL } from "../config";

const PrivateRoute = ({ children }) => {
  const location = useLocation();
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [isLoading, setIsLoading] = useState(true);
  const dispatch=useDispatch();

  useEffect(() => {
    const token = Cookies.get("auth_token");
    const id = Cookies.get("access_ID");
    console.log("token is....", token);
    console.log("access id is....", id);
    console.log("access id is....", document.cookie);

    const verifyToken = async () => {
      try {
        // const response = await fetch(
        //   `http://localhost:5203/verify-token_user?userID=${Number(id)}`,
        //      `${configURL("tokenVerification")}verify-token_user?userID=${Number(id)`
        //   {
        //     method: "POST",
        //     headers: {
        //       "Content-Type": "application/json",
        //     },
        //     body: JSON.stringify(token),
        //   }
        // );

        // if (response.ok) {
        // const comingData = await response.json();

        // console.log("coming verified data is...", data);
        setIsAuthenticated(true);
        // dispatch(validateLogin());
        // updateAuthorizedPages(comingData.pagerAccess.split(", "));
        // setUserId();
        // } else {
        //   setIsAuthenticated(false);
        // }
      } catch (error) {
        setIsAuthenticated(false);
      } finally {
        setIsLoading(false);
      }
    };

    if (token && token !== undefined) {
      console.log("token value is", token);
      verifyToken();
    } else {
      console.log("data come here");
      setIsAuthenticated(false);
      //  dispatch(validateLogin());
      //   setIsLoading(false);
    }
  }, []);

  if (isAuthenticated) {
    dispatch(validateLogout());
    return <Navigate to="/login" state={{ from: location }} replace />;
  }

  return children;
};

export default PrivateRoute;
