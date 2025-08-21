import React from "react";
import jsPDF from "jspdf";
import "jspdf-autotable";

const GenerateReport = ({ data }) => {
  const generatePDF = () => {
    const doc = new jsPDF();
    // const doc = new jsPDF();
    console.log(typeof doc.autoTable);

    // Title
    doc.setFontSize(18);
    doc.text("Complaint Report", 14, 22);

    // Convert JSON to table
    const tableColumn = [
      "ID",
      "User Name",
      "Area Name",
      "Issue",
      "Status",
      "Submitted At",
    ];
    const tableRows = [];

    data.forEach((item) => {
      const rowData = [
        item.complaintId,
        item.citizen.user.uname,
        item.area.areaName,
        item.issueCategory.description,
        item.actionStatus === 0
          ? "No action"
          : item.actionStatus === 1
          ? "InProgress"
          : item.actionStatus === 2
          ? "Resolved"
          : "Rejected",
        item.submittedAt,
      ];
      tableRows.push(rowData);
    });

    // AutoTable from JSON
    doc.autoTable({
      head: [tableColumn],
      body: tableRows,
      startY: 30,
    });

    // Save PDF
    doc.save("complaint_report.pdf");
  };

  return (
    <div>
      <button className="btn btn-secondary border-dark" onClick={generatePDF}>
        Generate Report
      </button>
    </div>
  );
};

export default GenerateReport;
