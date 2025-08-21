using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class CitizenComplaint
{
    public int ComplaintId { get; set; }

    public int? Cid { get; set; }

    public int? IssueId { get; set; }

    public int? AreaId { get; set; }

    public string? Description { get; set; }

    public DateTime? SubmittedAt { get; set; }

    public int? ActionStatus { get; set; }

    public virtual Area? Area { get; set; }

    public virtual Citizen? CidNavigation { get; set; }

    public virtual ComplaintStatus? ComplaintStatus { get; set; }

    public virtual IssueCategory? Issue { get; set; }
}
