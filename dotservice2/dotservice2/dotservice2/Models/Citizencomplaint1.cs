using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class Citizencomplaint1
{
    public int ComplaintId { get; set; }

    public int? ActionStatus { get; set; }

    public string? Description { get; set; }

    public DateTime? SubmittedAt { get; set; }

    public int? AreaId { get; set; }

    public int? CitizenId { get; set; }

    public int? IssueCategoryId { get; set; }

    public virtual Area? Area { get; set; }

    public virtual Citizen? Citizen { get; set; }

    public virtual IssueCategory? IssueCategory { get; set; }
}
