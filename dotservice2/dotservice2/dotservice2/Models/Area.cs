using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class Area
{
    public int AreaId { get; set; }

    public string AreaName { get; set; } = null!;

    public string? Pincode { get; set; }

    public virtual ICollection<CitizenComplaint> CitizenComplaints { get; set; } = new List<CitizenComplaint>();

    public virtual ICollection<Citizencomplaint1> Citizencomplaint1s { get; set; } = new List<Citizencomplaint1>();

    public virtual ICollection<Citizen> Citizens { get; set; } = new List<Citizen>();

    public virtual ICollection<ZoneOperator> ZoneOperators { get; set; } = new List<ZoneOperator>();
}
