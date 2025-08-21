import { Outlet } from "react-router-dom";
import { Modal, Button } from "react-bootstrap";
import { useEffect, useState } from "react";
import axios from "axios";
import { useDispatch } from "react-redux";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
function HomeZoneOperator() {
  const [show, setShow] = useState(false);
  const [statusClaim, setStatusClaim] = useState([]);
  const [statusValue, setStatusValue] = useState(1);
  const [modalData, setModalData] = useState([]);
  const [statusFilterValue, setStatusFilterValue] = useState(5);

  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(validateLogin(2));
  }, []);

  const handleShow = (id) => {
    setShow(true);
    let userComplaintData = statusClaim.filter((data) => {
      return data.complaintId === id;
    });
    console.log("user selected is", id);
    console.log("user selected is", userComplaintData);
    setModalData(userComplaintData);
    setStatusValue(userComplaintData[0].actionStatus);
  }; // Open modal
  const handleClose = () => setShow(false);

  useEffect(() => {
    let complaintsData = [];

    axios.get("http://localhost:8080/api/complaints").then((res) => {
      console.log(res.data);

      complaintsData = res.data;
      axios.get("http://localhost:8080/api/operator").then((response) => {
        console.log(response.data);
        const userId = localStorage.getItem("userId");
        let operatorInfo = response.data.filter((datas) => {
          return datas.user.uid == userId;
        });
        console.log(operatorInfo[0].area.areaId);
        // let id=localStorage.getItem("userId");
        // let a=res.data.filter((data)=>data.citizen?.user.uid==id)
        // setStatusClaim(a);
        let areaIdOfOperator = operatorInfo[0]?.area.areaId;
        // console.log(a);

        let complaintsAccordingArea = complaintsData.filter((data) => {
          return data.area?.areaId == areaIdOfOperator;
        });
        setStatusClaim(complaintsAccordingArea);
        console.log(complaintsAccordingArea);
      });
    });
  }, []);

  function handleSubmit(complaintId) {
    setShow(false);
    console.log("com Id is", complaintId);

    console.log(statusClaim);
    //  let b= statusClaim.filter((data)=>data.complaintId===complaintId);

//http://localhost:8080/api/complaints/${complaintId}/status
    axios.patch(`http://localhost:8080/api/complaints/${complaintId}/status`, {
      actionStatus: statusValue,
    });
    console.log(statusValue);
  }

  function handleChangeStatusValue(e) {
    setStatusValue(Number(e.target.value));
    console.log(e.target.value);
  }

  function handleChangeFilterStatus(e) {
    setStatusFilterValue(Number(e.target.value));
    console.log(e.target.value);
  }
  return (
    <div>
      <div>
        <br></br>
        <br></br>
        <h1 className="container">Complaints Status</h1>
        <div className="container">
          <select
            onChange={handleChangeFilterStatus}
            className=" border border-dark  text-dark"
          >
            <option selected value="5">
              All Complaints
            </option>
            <option value="0">No Action</option>
            <option value="1">In Progress</option>
            <option value="2">Resolve</option>
            <option value="3">Reject</option>
          </select>
        </div>
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
              <th>Citizen Name</th>
              <th>Issue_Category</th>
              <th>Area</th>
              <th>Current Status</th>
              <th>Issue Submitted Date</th>
              <th></th>
              {/* <th>Req Ammount</th> */}
              {/* <th>Action</th> */}
            </tr>
          </thead>
          <tbody>
            {statusClaim
              .filter((data) =>
                statusFilterValue === 5
                  ? true
                  : data.actionStatus === statusFilterValue
              )
              .map((data, key) => {
                return (
                  <tr>
                    <td>{key + 1}</td>
                    <td>{data.citizen.user.uname}</td>
                    <td>{data.issueCategory.description}</td>
                    <td>{data.area.areaName}</td>
                    {data.actionStatus === 0 && (
                      <td className="badge  bg-warning">{"No Action"}</td>
                    )}
                    {data.actionStatus === 1 && (
                      <td className="badge text-white bg-secondary">
                        {"In Progress"}
                      </td>
                    )}
                    {data.actionStatus === 2 && (
                      <td className="badge text-white  bg-success">
                        {"Resolved"}
                      </td>
                    )}
                    {data.actionStatus === 3 && (
                      <td className="badge text-white  bg-danger">
                        {"Rejected"}
                      </td>
                    )}
                    <td>{new Date(data.submittedAt).toLocaleDateString()}</td>
                    <td>
                      <button
                        onClick={() => handleShow(data.complaintId)}
                        className="btn btn-sm text-light bg-primary"
                      >
                        {" "}
                        {"Change status"}
                      </button>
                    </td>

                    {/* <td>
                  <button
                    className="btn btn-outline-success ml-4 mr-2"
                    onClick={(e) => {
                      handleApprove(data.pId);
                    }}
                  >
                    Approve
                  </button>
                  <button
                    className="btn btn-outline-danger"
                    onClick={(e) => {
                      handleReject(data.pId);
                    }}
                  >
                    Reject
                  </button>
                </td> */}
                  </tr>
                );
              })}
          </tbody>
        </table>
      </div>
      <div className="text-center mt-5">
        <Modal show={show} onHide={handleClose} centered>
          <Modal.Header closeButton>
            <Modal.Title>Citizen Complaint</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <p>
              <span className="badge text-secondary bg-light">
                {" "}
                Citizen ID :
              </span>{" "}
              <span>{modalData[0]?.citizen.cid}</span>
            </p>
            <p>
              <span className="badge text-secondary bg-light">
                Citizen Name :
              </span>{" "}
              <span>{modalData[0]?.citizen.user.uname}</span>
            </p>
            <p>
              <span className="badge text-secondary bg-light"> Area :</span>{" "}
              <span>{modalData[0]?.area.areaName}</span>
            </p>
            <p>
              <span className="badge text-secondary bg-light">
                Issue Category :
              </span>

              <span>{modalData[0]?.issueCategory.description}</span>
            </p>
            <p>
              <span className="badge text-secondary bg-light">
                Description :
              </span>
              <br></br>
              <span>{modalData[0]?.description}</span>
            </p>
            <p>
              <span className="badge bg-dark text-white">Status :</span>

              <span className="container">
                <select
                  value={statusValue}
                  onChange={handleChangeStatusValue}
                  className="border border-dark  text-dark"
                >
                  <option value="0">No Action</option>
                  <option value="1">In Progress</option>
                  <option value="2">Resolve</option>
                  <option value="3">Reject</option>
                </select>
              </span>
            </p>
          </Modal.Body>
          <Modal.Footer>
            <Button
              variant="primary"
              onClick={() => handleSubmit(modalData[0]?.complaintId)}
            >
              Submit
            </Button>
            <Button variant="danger" onClick={handleClose}>
              Close
            </Button>
          </Modal.Footer>
        </Modal>
      </div>
    </div>
  );
}

export default HomeZoneOperator;
