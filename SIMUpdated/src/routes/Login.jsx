import axios from "axios";
import { useForm } from "react-hook-form";
import { useDispatch } from "react-redux";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
import { useNavigate } from "react-router-dom";

function Login() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  async function navigateToDashboard(data) {
    console.log(data);
    const response = await axios.post("http://localhost:8080/api/user/login", {
      email: data.email,
      password: data.password,
    });
    console.log("Login Success:", response.status);
    if (response.status === 200) {
        if(response.data){
            localStorage.setItem("userId", response.data.uid);
        }
         console.log("code come here",response.data); 
        console.log("code come here",response.data.rid); 
      if (response.data?.rid == 1) {
        // navigate("/user/viewComplaints", {
        //   state: {
        //     roleId: response.data.role?.rid,
        //   },
        // });
        console.log("code come here");
         dispatch(validateLogin(response.data?.rid ));
          navigate("/user/viewComplaints");

        // localStorage.setItem("roleId", response.data.role?.rid.toString());
       
      } else if (response.data?.rid === 2) {
        dispatch(validateLogin(response.data?.rid));
        // localStorage.setItem("roleId", response.data.role?.rid.toString());
        navigate("/operator");
      }else if(response.data?.rid === 3){
        dispatch(validateLogin(response.data?.rid));
        navigate("/admin/dashboard");
      }
    }

    console.log("Login Success:", response.data);
    // return response.data;
  }

  return (
    <div className="d-flex justify-content-center align-items-start vh-100 bg-light pt-5">
      <div
        className="card shadow-lg p-4 min-vh-50  mt-5"
        style={{ width: "100%", maxWidth: "500px", borderRadius: "16px" }}
      >
        <h2 className="text-center mb-4" style={{ color: "#4d267aff" }}>
          {/* Changed from blue to violet-purple */}
          Login
        </h2>
        <form onSubmit={handleSubmit(navigateToDashboard)}>
          {/* Email Field */}
          <div className="mb-3">
            <label className="form-label fw-semibold">Email address</label>
            <input
              type="email"
              className={`form-control ${errors.email ? "is-invalid" : ""}`}
              {...register("email", {
                required: "*Email is required.",
                pattern: {
                  value: /^[^@ ]+@[^@ ]+\.[^@ .]{2,}$/,
                  message: "*Email is not valid.",
                },
              })}
              placeholder="Enter your email"
            />
            {errors.email && (
              <div className="invalid-feedback">{errors.email.message}</div>
            )}
          </div>

          {/* Password Field */}
          <div className="mb-4">
            <label className="form-label fw-semibold">Password</label>
            <input
              type="password"
              className={`form-control ${errors.password ? "is-invalid" : ""}`}
              {...register("password", {
                required: "*Password is required",
              })}
              placeholder="Enter your password"
            />
            {errors.password && (
              <div className="invalid-feedback">{errors.password.message}</div>
            )}
          </div>

          {/* Submit Button */}
          <div className="d-grid">
            <button
              type="submit"
              className="btn"
              style={{ backgroundColor: "#3a0185f1", color: "white" }}
            >
              {/* Changed to orange button */}
              Log In
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
