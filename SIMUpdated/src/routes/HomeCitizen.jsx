import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { Outlet } from "react-router-dom";
import { validateLogin } from "../features/loginSuccessful/loginSlice";

function HomeCitizen() {
    const dispatch = useDispatch();
     useEffect(() => {
        dispatch(validateLogin(1));
      }, []);
  return (
    <div>
      {/* <p>This is Home Citizen page</p> */}
      <br></br>
      <br></br>
      <br></br>
      {/* <br></br> */}
      {/* <br></br> */}
      <Outlet></Outlet>
    </div>
  );
}

export default HomeCitizen;
