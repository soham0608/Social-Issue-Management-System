using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class ComplaintStatus
{
    public int ComplaintId { get; set; }

    public string? Status { get; set; }

    public DateTime? UpdatedAt { get; set; }

    public int? HandledBy { get; set; }

    public string? Note { get; set; }

    public virtual CitizenComplaint Complaint { get; set; } = null!;

    public virtual ZoneOperator? HandledByNavigation { get; set; }
}
