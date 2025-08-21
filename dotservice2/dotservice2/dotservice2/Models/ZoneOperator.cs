using System;
using System.Collections.Generic;

namespace dotservice2.Models;

public partial class ZoneOperator
{
    public int OperatorId { get; set; }

    public int? Uid { get; set; }

    public string? Designation { get; set; }

    public int? AreaId { get; set; }

    public DateOnly? JoinedDate { get; set; }

    public virtual Area? Area { get; set; }

    public virtual ICollection<ComplaintStatus> ComplaintStatuses { get; set; } = new List<ComplaintStatus>();

    public virtual User? UidNavigation { get; set; }
}
