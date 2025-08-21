import axios from "axios";
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";

function UserRegisterComplaint() {
  const [complaints, setComplaints] = useState([]);
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm();

  useEffect(() => {
    axios.get("http://localhost:8080/api/issues").then((response) => {
      // setAreas(response.data);
      console.log(response.data);
      // setLoading(false);
      setComplaints(response.data);
    });

    axios.get("http://localhost:8080/api/citizens").then((response) => {
      // setAreas(response.data);
      console.log(response.data);
      // setLoading(false);
      let userId = localStorage.getItem("userId");
      let userData = response.data.filter((data) => {
        return data.user.uid == userId;
      });
      console.log("citizen data is...", userData);
    });
  }, []);

   function onSubmitHandler(data) {
    console.log(data);
    
      let userId=localStorage.getItem("userId");
      console.log(Number(userId),Number(data.issueCat),data.issueDescription);
 axios.post(
      "http://localhost:8080/api/complaints/register",
      {
    "userid":Number(userId),
    "catid":Number(data.issueCat),
    "issdesc":data.issueDescription
     }
    );

  }
  return (
    <>
      <h1 className="container">
        <span className="badge bg-success">Complaint Registration -</span>
      </h1>
      {/* <button className="btn btn-success">Complaint Registration -</button> */}
      <form
        className="form container border border-dark p-4 bg-light  mt-5"
        onSubmit={handleSubmit(onSubmitHandler)}
      >
        {/* <div className="form-control-sm">
         
          <label htmlFor="issueCategory">Issue Category</label>
          <select
            className="form-control"
            name="userId"
            {...register("issueCat")}
          >
             <option value="">-- Select an Area --</option>
            {complaints.map((data) => {
              return <option value={data.issueId}>{data.description}</option>;
            })}
          </select>
        </div> */}
        <div className="form-control-sm">
          <label className="form-label fw-semibold">
            Select Issue Category
          </label>
          <select
            className={`form-select ${errors.issueCat ? "is-invalid" : ""}`}
            {...register("issueCat", {
              required: "*Issue is required",
            })}
          >
            <option value="">-- Select an Issue --</option>
            {complaints.map((data) => {
              return <option value={data.issueId}>{data.description}</option>;
            })}

            {/* <option value="Mumbai">Mumbai</option>
                <option value="Nagpur">Nagpur</option>
                <option value="Nashik">Nashik</option>
                <option value="Aurangabad">Aurangabad</option> */}
          </select>
          {errors.issueCat && (
            <div className="invalid-feedback">{errors.issueCat.message}</div>
          )}
        </div>

        <div className="form-control-sm">
          <label htmlFor="policyName">Issue Description</label>
          <div>
            <input
              type="text"
              {...register("issueDescription", { required: true })}
              className="form-control"
            ></input>
            {errors.issueDescription?.type === "required" && (
              <p style={{ color: "red" }}>description is required*</p>
            )}
          </div>
          {/* <select
            className="form-control"
            id="policyName"
            {...register("policyName")}
          >
            <option value="Jeevan Chaya">Jeevan Chaya</option>
            <option value="Jeevan Jyoti">Jeevan Jyoti</option>
            <option value="Jeevan Gaurav">Jeevan Gaurav</option>
            <option value="Jeevan Vidya">Jeevan Vidya</option>
          </select> */}
        </div>

        {/* <div className="form-control-sm">
          <label htmlFor="amount">Amount</label>
          <input
            type="text"
            className="form-control"
            id="amount"
            placeholder="Enter the amount"
            {...register("amount", { required: true })}
          />
          {errors.amount?.type === "required" && (
            <p style={{ color: "red" }}>Amount is required.</p>
          )}
        </div> */}

        {/* <div className="form-control-sm">
          <label htmlFor="claimLimit">Max Limit of Claim</label>
          <input
            type="text"
            className="form-control"
            id="claimLimit"
            placeholder="Enter the maximum claim limit"
            {...register("maxLimit", { required: true })}
          />
          {errors.amount?.type === "required" && (
            <p style={{ color: "red" }}>Limit is required.</p>
          )}
        </div> */}

        <button type="submit" className="btn btn-primary mt-3">
          Submit
        </button>
      </form>
    </>
  );
}

export default UserRegisterComplaint;
