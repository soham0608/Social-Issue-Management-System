import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
import { useLocation } from "react-router-dom";
import axios from "axios";

function ViewComplaints() {
  const [statusClaim, setStatusClaim] = useState([]);
  // const dispatch = useDispatch();
  //  const location = useLocation();
  // useEffect(()=>{

  //     // const storedRole = localStorage.getItem('roleId');

  //     //   dispatch(validateLogin(parseInt(storedRole)));
  //     if (location.state?.roleId) {
  //       console.log("location using...",location.state?.roleId);
  //     dispatch(validateLogin(location.state.roleId));
  //   }

  // },[location.state])
  // useEffect(() => {
  //   dispatch(validateLogin(1));
  // }, []);

  useEffect(() => {
    axios.get("http://localhost:8080/api/complaints").then((res) => {
      setStatusClaim(res.data);
      console.log(res.data);
    });
  }, []);

  return (
    <div>
      <h1 className="container">All Complaints</h1>
      <br></br>
      <br></br>
      <table className="container table table-striped  table-bordered">
        <thead className="table-dark ">
          {/* <tr>
            <span class="badge bg-secondary">Claim Requests</span>
          </tr> */}
          <tr>
            <th>ID</th>
            {/* <th>Citizen Name</th> */}
            <th>Issue_Category</th>
            <th>Area</th>
            <th>Current Status</th>
            <th>Issue Submitted Date</th>
            {/* <th>Req Ammount</th> */}
            {/* <th>Action</th> */}
          </tr>
        </thead>
        <tbody>
          {statusClaim.map((data, key) => {
            return (
              <tr>
                <td>{key + 1}</td>
                <td>{data.issueCategory.description}</td>
                <td>{data.area.areaName}</td>

                {/* <td className="badge bg-info">{data.actionStatus===0?"No Action":"pending"}</td> */}
                {data.actionStatus === 0 && (
                  <td class="badge bg-warning">{"No Action"}</td>
                )}
                {data.actionStatus === 1 && (
                  <td class="badge bg-secondary">{"In Progress"}</td>
                )}
                {data.actionStatus === 2 && (
                  <td class="badge bg-success">{"Resolved"}</td>
                )}
                {data.actionStatus === 3 && (
                  <td class="badge bg-danger">{"Rejected"}</td>
                )}
                <td>{new Date(data.submittedAt).toLocaleDateString()}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default ViewComplaints;
