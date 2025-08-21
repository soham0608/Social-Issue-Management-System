import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
import axios from "axios";

function UserComplaintStatus() {
  const [statusClaim, setStatusClaim] = useState([]);
  //     const dispatch = useDispatch();

  //  useEffect(() => {
  //     dispatch(validateLogin(1));
  //   }, []);

  useEffect(() => {
    axios.get("http://localhost:8080/api/complaints").then((res) => {
      console.log(res.data);
      let id = localStorage.getItem("userId");
      let a = res.data.filter((data) => data.citizen?.user.uid == id);
      setStatusClaim(a);

      console.log(a);
    });
  }, []);

  return (
    <div>
      <h1 className="container">
        <span className="badge bg-secondary">My Complaints</span>{" "}
      </h1>
      <table className="container table table-bordered mt-5">
        <thead className="table-success">
          {/* <tr>
            <span class="badge bg-success">Approve Policy</span>
          </tr> */}
          <tr>
            <th>ID</th>
            <th>Issue Category</th>
            <th>Current Status</th>
            <th>Issue Submitted At</th>
          </tr>
        </thead>
        <tbody>
          {statusClaim.map((item, key) => {
            return (
              <tr>
                <td>{key + 1}</td>
                <td>{item.issueCategory.description}</td>
                {item.actionStatus === 0 && (
                  <td class="badge bg-warning">{"No Action"}</td>
                )}
                {item.actionStatus === 1 && (
                  <td class="badge bg-secondary">{"In Progress"}</td>
                )}
                {item.actionStatus === 2 && (
                  <td class="badge bg-success">{"Resolved"}</td>
                )}
                {item.actionStatus === 3 && (
                  <td class="badge bg-danger">{"Rejected"}</td>
                )}
                <td>{item.submittedAt}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default UserComplaintStatus;
