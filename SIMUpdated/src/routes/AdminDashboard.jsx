import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { Outlet } from "react-router-dom";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
import axios from "axios";
import GenerateReport from "../Components/GenerateReport";

function DashboardAdmin() {
  const dispatch = useDispatch();
  const [counts, setCounts] = useState({
    noaction: 0,
    inprogress: 0,
    resolved: 0,
    rejected: 0,
  });
  const [complaints, setComplaints] = useState([
    { id: 1, category: "Total Complaints", count: 120 },
    { id: 2, category: "In-Progress", count: 45 },
    { id: 3, category: "Resolved", count: 65 },
    { id: 4, category: "Rejected", count: 10 },
  ]);

  const [filterComplaints, setFilterComplaints] = useState([]);

  useEffect(() => {
    dispatch(validateLogin(3));
    //  axios.get("")
  }, []);

  useEffect(() => {
    axios.get("http://localhost:8080/api/complaints").then((res) => {
      setComplaints(res.data);
      setFilterComplaints(res.data);
      console.log(res.data);
      let resolve = res.data.filter((data) => {
        return data.actionStatus === 2;
      }).length;
      console.log("resolved data is...", resolve);

      let inprogress = res.data.filter((data) => {
        return data.actionStatus === 1;
      }).length;

      let reject = res.data.filter((data) => {
        return data.actionStatus === 3;
      }).length;

      let noactionCount = res.data.filter((data) => {
        return data.actionStatus === 0;
      }).length;
      setCounts({
        noaction: noactionCount,
        inprogress: inprogress,
        resolved: resolve,
        rejected: reject,
      });
    });
  }, []);

  function handleTotalComplaints() {
    setFilterComplaints(complaints);
  }

  function handleProgressComplaints() {
    let progressComplains = complaints.filter((data) => {
      return data.actionStatus === 1;
    });
    setFilterComplaints(progressComplains);
  }

  function handleResolvedComplaints() {
    let resolveComplains = complaints.filter((data) => {
      return data.actionStatus === 2;
    });
    setFilterComplaints(resolveComplains);
  }

  function handleRejectedComplaints() {
    let rejectComplains = complaints.filter((data) => {
      return data.actionStatus === 3;
    });
    setFilterComplaints(rejectComplains);
  }
  return (
    <div>
      <div class="container mt-5">
        <div class="row g-4">
          {/* <!-- Total Complaints --> */}

          <div class="col-md-3 col-sm-6" onClick={handleTotalComplaints}>
            <div class="card border-primary shadow h-100 text-center">
              <div class="card-body">
                <h5 class="card-title text-primary">Total Complaints</h5>
                <h2 class="card-text">{complaints.length}</h2>
              </div>
            </div>
          </div>

          {/* <!-- In-Progress Complaints --> */}

          <div class="col-md-3 col-sm-6" onClick={handleProgressComplaints}>
            <div class="card border-warning shadow h-100 text-center">
              <div class="card-body">
                <h5 class="card-title text-warning">In-Progress</h5>
                <h2 class="card-text">{counts.inprogress}</h2>
              </div>
            </div>
          </div>

          {/* <!-- Resolved Complaints --> */}
          <div class="col-md-3 col-sm-6" onClick={handleResolvedComplaints}>
            <div class="card border-success shadow h-100 text-center">
              <div class="card-body">
                <h5 class="card-title text-success">Resolved</h5>
                <h2 class="card-text">{counts.resolved}</h2>
              </div>
            </div>
          </div>

          {/* <!-- Rejected Complaints --> */}
          <div class="col-md-3 col-sm-6" onClick={handleRejectedComplaints}>
            <div class="card border-danger shadow h-100 text-center">
              <div class="card-body">
                <h5 claatss="card-title text-danger">Rejected</h5>
                <h2 class="card-text">{counts.rejected}</h2>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br></br>
      <br></br>
      <div className="container">
        <GenerateReport data={filterComplaints}></GenerateReport>
      </div>
      <table className="container table table-bordered mt-5">
        <thead className="table-success">
          {/* <tr>
            <span class="badge bg-success">Approve Policy</span>
          </tr> */}
          <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Area Name</th>
            <th>Issue</th>
            <th>Status</th>
            <th>Submitted At</th>
          </tr>
        </thead>
        <tbody>
          {filterComplaints.map((item, key) => {
            return (
              <tr>
                <td>{item.complaintId}</td>
                <td>{item.citizen?.user?.uname}</td>
                <td>{item.citizen?.area?.areaName}</td>
                <td>{item.issueCategory?.description}</td>
                {item.actionStatus === 0 && (
                  <td class="badge bg-warning">{"No Action"}</td>
                )}
                {item.actionStatus === 1 && (
                  <td class="badge bg-secondary">{"In Progess"}</td>
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

export default DashboardAdmin;
