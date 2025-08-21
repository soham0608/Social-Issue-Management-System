using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class IssueCategory
{
    public int IssueId { get; set; }

    public string? Description { get; set; }

    public virtual ICollection<CitizenComplaint> CitizenComplaints { get; set; } = new List<CitizenComplaint>();

    public virtual ICollection<Citizencomplaint1> Citizencomplaint1s { get; set; } = new List<Citizencomplaint1>();
}
