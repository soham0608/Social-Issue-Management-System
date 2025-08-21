using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class Citizen
{
    public int Cid { get; set; }

    public int? Uid { get; set; }

    public string? Fname { get; set; }

    public string? Lname { get; set; }

    public string? Address { get; set; }

    public int? AreaId { get; set; }

    public string? Gender { get; set; }

    public DateOnly? Dob { get; set; }

    public string? AadharNo { get; set; }

    public virtual Area? Area { get; set; }

    public virtual ICollection<CitizenComplaint> CitizenComplaints { get; set; } = new List<CitizenComplaint>();

    public virtual ICollection<Citizencomplaint1> Citizencomplaint1s { get; set; } = new List<Citizencomplaint1>();

    public virtual User? UidNavigation { get; set; }
}
