using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class User
{
    public int Uid { get; set; }

    public string Uname { get; set; } = null!;

    public string Password { get; set; } = null!;

    public int? Rid { get; set; }

    public string? PhoneNo { get; set; }

    public string? Email { get; set; }

    public string? Status { get; set; }

    public virtual ICollection<Citizen> Citizens { get; set; } = new List<Citizen>();

    public virtual Role? RidNavigation { get; set; }

    public virtual ICollection<ZoneOperator> ZoneOperators { get; set; } = new List<ZoneOperator>();
}
