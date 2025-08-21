import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { validateLogin } from "../features/loginSuccessful/loginSlice";
import axios from "axios";
import { Button, Modal } from "react-bootstrap";

function AdminManageCategories() {
  const dispatch = useDispatch();
  const [show, setShow] = useState(false);

  const [category, setCategory] = useState("1");
  const [issues, setIssues] = useState([]);
  const [areas, setAreas] = useState([]);
  const [issueName, setIssueName] = useState([]);

  // New state for inline editing
  const [editingIssueId, setEditingIssueId] = useState(null);
  const [editIssueValue, setEditIssueValue] = useState("");

  const [areaName, setAreaName] = useState("");
  const [pincode, setPinCode] = useState("");

  useEffect(() => {
    dispatch(validateLogin(3));
  }, []);

  function handleSubmitArea() {
    // console.log(data);
    axios.post("http://localhost:8080/api/area", {
      pincode: pincode,
      areaName: areaName,
    });
    // console.log(areaName);
    // console.log(pincode);
    console.log(areas);
    setAreas((areas) => [
      ...areas,
      {
        areaId: areas[areas.length - 1].areaId + 1,
        areaName: areaName,
        pincode: pincode,
      },
    ]);
    setShow(false);
    console.log(areas);
  }

  function handleSubmitIssue() {
    axios.post("http://localhost:8080/api/issues", {
      description: issueName,
    });

    setIssues((issues) => [
      ...issues,
      {
        description: issueName,
        issueId: issues[issues.length - 1].issueId + 1,
      },
    ]);
    setShow(false);
  }

  // Handle edit button click for issues
  function handleEditIssue(issueId, currentDescription) {
    setEditingIssueId(issueId);
    setEditIssueValue(currentDescription);
  }

  // Handle submit for edited issue
  function handleSubmitEditIssue(issueId) {
    // Make API call to update the issue

    // setIssues((prevIssues) =>
    //   prevIssues.map((issue) =>
    //     issue.issueId === issueId
    //       ? { ...issue, description: editIssueValue }
    //       : issue
    //   )
    // );
//http://localhost:8080/api/issues/${issueId} - citizen service
//http://localhost:8080/api/IssueCategory/${issueId} - dotnet service
    axios.put(`http://localhost:8080/api/issues/${issueId}`, {
      description: editIssueValue,
        "citizenComplaints": [],
    "citizencomplaint1s": []
    });

    // Update the local state
    setIssues((prevIssues) =>
      prevIssues.map((issue) =>
        issue.issueId === issueId
          ? { ...issue, description: editIssueValue }
          : issue
      )
    );

    // Reset editing state
    setEditingIssueId(null);
    setEditIssueValue("");
  }

  // Handle cancel edit
  function handleCancelEdit() {
    setEditingIssueId(null);
    setEditIssueValue("");
  }

  // Handle delete issue
  function handleDeleteIssue(issueId) {
    // Show confirmation dialog
    if (
      window.confirm("Are you sure you want to delete this issue category?")
    ) {
      setIssues((prevIssues) =>
        prevIssues.filter((issue) => issue.issueId !== issueId)
      );
      // axios
      //   .delete(`http://localhost:8080/api/issues/${issueId}`)
      //   .then(() => {
      //     // Remove from local state
      //     setIssues((prevIssues) =>
      //       prevIssues.filter((issue) => issue.issueId !== issueId)
      //     );
      //     console.log(`Issue with ID ${issueId} deleted successfully`);
      //   })
      //   .catch((error) => {
      //     console.error("Error deleting issue:", error);
      //     alert("Error deleting issue. Please try again.");
      //   });
    }
  }

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/issues")
      .then((res) => setIssues(res.data));

    axios
      .get("http://localhost:8080/api/areas")
      .then((res) => setAreas(res.data));
  }, []);

  function handleChangeCategory(e) {
    // console.log(e.target.value);
    setCategory(e.target.value);
    console.log("issues are...", issues);
  }

  function handlePinCode(e) {
    setPinCode(e.target.value);
  }

  function handleAreaName(e) {
    setAreaName(e.target.value);
  }

  function handleIssueName(e) {
    setIssueName(e.target.value);
  }

  const handleClose = () => setShow(false);

  function handleArea() {
    setShow(true);
  }

  function handleIssue() {
    setShow(true);
  }

  return (
    <div>
      <div className="container mt-4">
        <label htmlFor="dropdown" className="form-label">
          Choose category:
        </label>
        <select
          id="dropdown"
          className="form-select border-2 border-primary bg-light text-dark w-25"
          value={category}
          onChange={handleChangeCategory}
        >
          <option value="1">Issue Category</option>
          <option value="2">Area Category</option>
        </select>
        <br></br>
        <div className="container mt-4">
          {category == 1 && (
            <button
              onClick={handleIssue}
              className="btn btn-secondary px-4 py-2 rounded-pill shadow"
            >
              Add New Issue
            </button>
          )}
          {category == 2 && (
            <button
              onClick={handleArea}
              className="btn btn-secondary px-4 py-2 rounded-pill shadow"
            >
              Add New Area
            </button>
          )}
        </div>
      </div>
      {category == 1 && (
        <table
          style={{ width: "70%" }}
          className="container table table-bordered mt-5"
        >
          <thead className="table-success">
            <tr>
              <th style={{ width: "20%" }}>ID</th>
              <th style={{ width: "50%" }}>Issue Category</th>
              <th style={{ width: "15%" }}></th>
              <th style={{ width: "15%" }}></th>
            </tr>
          </thead>
          <tbody>
            {issues.map((item, key) => {
              return (
                <tr key={item.issueId}>
                  <td>{key + 1}</td>
                  <td>
                    {editingIssueId === item.issueId ? (
                      <input
                        type="text"
                        value={editIssueValue}
                        onChange={(e) => setEditIssueValue(e.target.value)}
                        className="form-control"
                        autoFocus
                      />
                    ) : (
                      item.description
                    )}
                  </td>
                  <td>
                    {editingIssueId === item.issueId ? (
                      <button
                        className="btn btn-success shadow"
                        onClick={() => handleSubmitEditIssue(item.issueId)}
                      >
                        Submit
                      </button>
                    ) : (
                      <button
                        className="btn text-primary shadow border-primary"
                        onClick={() =>
                          handleEditIssue(item.issueId, item.description)
                        }
                      >
                        Edit
                      </button>
                    )}
                  </td>
                  <td>
                    {editingIssueId === item.issueId ? (
                      <button
                        className="btn text-secondary border-secondary shadow"
                        onClick={handleCancelEdit}
                      >
                        Cancel
                      </button>
                    ) : (
                      <button
                        className="btn text-danger border-danger shadow"
                        onClick={() => handleDeleteIssue(item.issueId)}
                      >
                        Delete
                      </button>
                    )}
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      )}

      {category == 2 && (
        <table
          style={{ width: "70%" }}
          className="container table table-bordered mt-5"
        >
          <thead className="table-success">
            <tr>
              <th style={{ width: "10%" }}>ID</th>
              <th style={{ width: "50%" }}>Area Name</th>
              <th style={{ width: "20%" }}>Pincode</th>
              <th style={{ width: "15%" }}></th>
              <th style={{ width: "15%" }}></th>
            </tr>
          </thead>
          <tbody>
            {areas.map((item, key) => {
              return (
                <tr key={item.areaId}>
                  <td>{key + 1}</td>
                  <td>{item.areaName}</td>
                  <td>{item.pincode}</td>
                  <td>
                    <button className="btn btn-primary">Edit</button>
                  </td>
                  <td>
                    <button className="btn btn-danger">Delete</button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      )}
      <div className="text-center mt-5">
        <form>
          {category == 2 && (
            <Modal show={show} onHide={handleClose} centered>
              <Modal.Header closeButton>
                <Modal.Title>Add New Area</Modal.Title>
              </Modal.Header>
              <Modal.Body>
                <p>
                  <span className="badge text-secondary bg-light">
                    Area Name :
                  </span>
                  <br></br>
                  <span>
                    <input
                      onChange={handleAreaName}
                      className="ml-2"
                      type="text"
                    ></input>
                  </span>
                </p>
                <p>
                  <span className="badge text-secondary bg-light">
                    Pin Code :
                  </span>
                  <br></br>
                  <span>
                    <input
                      onChange={handlePinCode}
                      required
                      className="ml-2"
                      type="text"
                    ></input>
                  </span>
                </p>
              </Modal.Body>
              <Modal.Footer>
                <Button
                  variant="primary"
                  onClick={(data) => handleSubmitArea(data)}
                >
                  Submit
                </Button>
                <Button variant="danger" onClick={handleClose}>
                  Close
                </Button>
              </Modal.Footer>
            </Modal>
          )}
          {category == 1 && (
            <Modal show={show} onHide={handleClose} centered>
              <Modal.Header closeButton>
                <Modal.Title>Add New Issue</Modal.Title>
              </Modal.Header>
              <Modal.Body>
                <p>
                  <span className="badge text-secondary bg-light">
                    Issue Name :
                  </span>
                  <br></br>
                  <span>
                    <input
                      onChange={handleIssueName}
                      className="ml-2"
                      type="text"
                    ></input>
                  </span>
                </p>
              </Modal.Body>
              <Modal.Footer>
                <Button
                  variant="primary"
                  onClick={(data) => handleSubmitIssue(data)}
                >
                  Submit
                </Button>
                <Button variant="danger" onClick={handleClose}>
                  Close
                </Button>
              </Modal.Footer>
            </Modal>
          )}
        </form>
      </div>
    </div>
  );
}

export default AdminManageCategories;
