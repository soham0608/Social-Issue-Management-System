import axios from "axios";
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";

function Register() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const [areas, setAreas] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/areas").then((response) => {
      setAreas(response.data);
      console.log(response.data);
      // setLoading(false);
    });
  }, []);

  async function navigateToDashboard(data) {
    const response = await axios.post(
      "http://localhost:8080/api/user/register",
      {
        uname: data.uname,
        phoneNo: data.phoneNo,
        email: data.email,
        password: data.password,
      }
    );

    if (response.status === 200 && response.data) {
      const res = await axios.post("http://localhost:8080/api/citizens", {
        user: { uid: response.data.uid },
        // "fname":"Kshitij",
        // "lname":"More",
        // "address":"sangavi,pune",
        area: { areaId: data.areasId },
        // "gender":"Male",
        // "dob":"2002-05-19",
        // "aadhar_no":"54654684868"
      });
    }
    console.log("response coming after register is 1", response.status);
    console.log("response coming after register is 2", response.data);
    console.log("response coming after register is 3", response);
    console.log(data);
  }
  return (
    <div>
      <div className="d-flex justify-content-center align-items-start vh-100 bg-light pt-5">
        <div
          className="card shadow-lg p-4 min-vh-50  mt-5"
          style={{ width: "100%", maxWidth: "500px", borderRadius: "16px" }}
        >
          <h2 className="text-center mb-4" style={{ color: "#4d267aff" }}>
            {/* Changed from blue to violet-purple */}
            Registration
          </h2>
          <form onSubmit={handleSubmit(navigateToDashboard)}>
            {/* Email Field */}
            <div clasName="mb-3">
              <label className="form-label fw-semibold">Enter UserName</label>
              <input
                type="text"
                className={`form-control ${errors.uname ? "is-invalid" : ""}`}
                {...register("uname", {
                  required: "*username is required",
                })}
                placeholder="Enter your username"
              />
              {errors.uname && (
                <div className="invalid-feedback">{errors.uname.message}</div>
              )}
            </div>
            <div clasName="mb-3">
              <label className="form-label fw-semibold">Enter PhoneNo</label>
              <input
                type="text"
                className={`form-control ${errors.phoneNo ? "is-invalid" : ""}`}
                {...register("phoneNo", {
                  required: "*phoneNo is required",
                })}
                placeholder="Enter your phoneNo"
              />
              {errors.phoneNo && (
                <div className="invalid-feedback">{errors.phoneNo.message}</div>
              )}
            </div>
            <div className="mb-3">
              <label className="form-label fw-semibold">Select Area</label>
              <select
                className={`form-select ${errors.area ? "is-invalid" : ""}`}
                {...register("areasId", {
                  required: "*Area selection is required",
                })}
              >
                <option value="">-- Select an Area --</option>
                {areas.map((data) => {
                  return <option value={data.areaId}>{data.areaName}</option>;
                })}

                {/* <option value="Mumbai">Mumbai</option>
                <option value="Nagpur">Nagpur</option>
                <option value="Nashik">Nashik</option>
                <option value="Aurangabad">Aurangabad</option> */}
              </select>
              {errors.area && (
                <div className="invalid-feedback">{errors.area.message}</div>
              )}
            </div>
            <div className="mb-3">
              <label className="form-label fw-semibold">
                Enter Email address
              </label>
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
              <label className="form-label fw-semibold">Enter Password</label>
              <input
                type="password"
                className={`form-control ${
                  errors.password ? "is-invalid" : ""
                }`}
                {...register("password", {
                  required: "*Password is required",
                })}
                placeholder="Enter your password"
              />
              {errors.password && (
                <div className="invalid-feedback">
                  {errors.password.message}
                </div>
              )}
            </div>

            {/* Submit Button */}
            <div className="d-grid">
              <button
                type="submit"
                className="btn"
                style={{ backgroundColor: "#3a0185f1  ", color: "white" }}
              >
                {/* Changed to orange button */}
                Register
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Register;
