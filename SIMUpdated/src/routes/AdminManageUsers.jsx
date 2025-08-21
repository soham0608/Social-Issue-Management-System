import { useDispatch } from "react-redux";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
import { useEffect } from "react";

function AdminManageUsers() {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(validateLogin(3));
  }, []);
  return <div>Users</div>;
}

export default AdminManageUsers;
