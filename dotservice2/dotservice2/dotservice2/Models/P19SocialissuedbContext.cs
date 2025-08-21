using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;

namespace dotservice2.Models;

public partial class P19SocialissuedbContext : DbContext
{
    public P19SocialissuedbContext()
    {
    }

    public P19SocialissuedbContext(DbContextOptions<P19SocialissuedbContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Area> Areas { get; set; }

    public virtual DbSet<Citizen> Citizens { get; set; }

    public virtual DbSet<CitizenComplaint> CitizenComplaints { get; set; }

    public virtual DbSet<Citizencomplaint1> Citizencomplaints1 { get; set; }

    public virtual DbSet<ComplaintStatus> ComplaintStatuses { get; set; }

    public virtual DbSet<IssueCategory> IssueCategories { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<User> Users { get; set; }

    public virtual DbSet<ZoneOperator> ZoneOperators { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;port=3306;user=root;password=harsh123;database=p19_socialissuedb", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.39-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Area>(entity =>
        {
            entity.HasKey(e => e.AreaId).HasName("PRIMARY");

            entity.ToTable("area");

            entity.Property(e => e.AreaId).HasColumnName("area_id");
            entity.Property(e => e.AreaName)
                .HasMaxLength(255)
                .HasColumnName("area_name");
            entity.Property(e => e.Pincode)
                .HasMaxLength(10)
                .HasColumnName("pincode");
        });

        modelBuilder.Entity<Citizen>(entity =>
        {
            entity.HasKey(e => e.Cid).HasName("PRIMARY");

            entity.ToTable("citizen");

            entity.HasIndex(e => e.AreaId, "area_id");

            entity.HasIndex(e => e.Uid, "uid");

            entity.Property(e => e.Cid).HasColumnName("cid");
            entity.Property(e => e.AadharNo)
                .HasMaxLength(12)
                .HasColumnName("aadhar_no");
            entity.Property(e => e.Address)
                .HasMaxLength(255)
                .HasColumnName("address");
            entity.Property(e => e.AreaId).HasColumnName("area_id");
            entity.Property(e => e.Dob).HasColumnName("dob");
            entity.Property(e => e.Fname)
                .HasMaxLength(255)
                .HasColumnName("fname");
            entity.Property(e => e.Gender)
                .HasColumnType("enum('Male','Female','Other')")
                .HasColumnName("gender");
            entity.Property(e => e.Lname)
                .HasMaxLength(255)
                .HasColumnName("lname");
            entity.Property(e => e.Uid).HasColumnName("uid");

            entity.HasOne(d => d.Area).WithMany(p => p.Citizens)
                .HasForeignKey(d => d.AreaId)
                .HasConstraintName("citizen_ibfk_2");

            entity.HasOne(d => d.UidNavigation).WithMany(p => p.Citizens)
                .HasForeignKey(d => d.Uid)
                .HasConstraintName("citizen_ibfk_1");
        });

        modelBuilder.Entity<CitizenComplaint>(entity =>
        {
            entity.HasKey(e => e.ComplaintId).HasName("PRIMARY");

            entity.ToTable("citizen_complaint");

            entity.HasIndex(e => e.AreaId, "area_id");

            entity.HasIndex(e => e.Cid, "cid");

            entity.HasIndex(e => e.IssueId, "issue_id");

            entity.Property(e => e.ComplaintId).HasColumnName("complaint_id");
            entity.Property(e => e.ActionStatus)
                .HasDefaultValueSql("'0'")
                .HasColumnName("action_status");
            entity.Property(e => e.AreaId).HasColumnName("area_id");
            entity.Property(e => e.Cid).HasColumnName("cid");
            entity.Property(e => e.Description)
                .HasMaxLength(255)
                .HasColumnName("description");
            entity.Property(e => e.IssueId).HasColumnName("issue_id");
            entity.Property(e => e.SubmittedAt)
                .HasColumnType("datetime")
                .HasColumnName("submitted_at");

            entity.HasOne(d => d.Area).WithMany(p => p.CitizenComplaints)
                .HasForeignKey(d => d.AreaId)
                .HasConstraintName("citizen_complaint_ibfk_3");

            entity.HasOne(d => d.CidNavigation).WithMany(p => p.CitizenComplaints)
                .HasForeignKey(d => d.Cid)
                .HasConstraintName("citizen_complaint_ibfk_1");

            entity.HasOne(d => d.Issue).WithMany(p => p.CitizenComplaints)
                .HasForeignKey(d => d.IssueId)
                .HasConstraintName("citizen_complaint_ibfk_2");
        });

        modelBuilder.Entity<Citizencomplaint1>(entity =>
        {
            entity.HasKey(e => e.ComplaintId).HasName("PRIMARY");

            entity.ToTable("citizencomplaint");

            entity.HasIndex(e => e.CitizenId, "FK7h27o81re4f4l49vr8590nn5h");

            entity.HasIndex(e => e.AreaId, "FKowp9t5k4errxcrbmdhjcdp6it");

            entity.HasIndex(e => e.IssueCategoryId, "FKp7vaw0dtnxor2diltpljk36fq");

            entity.Property(e => e.ComplaintId).HasColumnName("complaintId");
            entity.Property(e => e.ActionStatus).HasColumnName("actionStatus");
            entity.Property(e => e.AreaId).HasColumnName("area_id");
            entity.Property(e => e.CitizenId).HasColumnName("citizen_id");
            entity.Property(e => e.Description)
                .HasMaxLength(255)
                .HasColumnName("description");
            entity.Property(e => e.IssueCategoryId).HasColumnName("issue_category_id");
            entity.Property(e => e.SubmittedAt)
                .HasMaxLength(6)
                .HasColumnName("submittedAt");

            entity.HasOne(d => d.Area).WithMany(p => p.Citizencomplaint1s)
                .HasForeignKey(d => d.AreaId)
                .HasConstraintName("FKowp9t5k4errxcrbmdhjcdp6it");

            entity.HasOne(d => d.Citizen).WithMany(p => p.Citizencomplaint1s)
                .HasForeignKey(d => d.CitizenId)
                .HasConstraintName("FK7h27o81re4f4l49vr8590nn5h");

            entity.HasOne(d => d.IssueCategory).WithMany(p => p.Citizencomplaint1s)
                .HasForeignKey(d => d.IssueCategoryId)
                .HasConstraintName("FKp7vaw0dtnxor2diltpljk36fq");
        });

        modelBuilder.Entity<ComplaintStatus>(entity =>
        {
            entity.HasKey(e => e.ComplaintId).HasName("PRIMARY");

            entity.ToTable("complaint_status");

            entity.HasIndex(e => e.HandledBy, "handled_by");

            entity.Property(e => e.ComplaintId)
                .ValueGeneratedNever()
                .HasColumnName("complaint_id");
            entity.Property(e => e.HandledBy).HasColumnName("handled_by");
            entity.Property(e => e.Note)
                .HasMaxLength(255)
                .HasColumnName("note");
            entity.Property(e => e.Status)
                .HasColumnType("enum('SUBMITTED','IN_PROGRESS','RESOLVED','REJECTED')")
                .HasColumnName("status");
            entity.Property(e => e.UpdatedAt)
                .HasColumnType("datetime")
                .HasColumnName("updated_at");

            entity.HasOne(d => d.Complaint).WithOne(p => p.ComplaintStatus)
                .HasForeignKey<ComplaintStatus>(d => d.ComplaintId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("complaint_status_ibfk_1");

            entity.HasOne(d => d.HandledByNavigation).WithMany(p => p.ComplaintStatuses)
                .HasForeignKey(d => d.HandledBy)
                .HasConstraintName("complaint_status_ibfk_2");
        });

        modelBuilder.Entity<IssueCategory>(entity =>
        {
            entity.HasKey(e => e.IssueId).HasName("PRIMARY");

            entity.ToTable("issue_category");

            entity.Property(e => e.IssueId).HasColumnName("issue_id");
            entity.Property(e => e.Description)
                .HasMaxLength(255)
                .HasColumnName("description");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.Rid).HasName("PRIMARY");

            entity.ToTable("role");

            entity.Property(e => e.Rid).HasColumnName("rid");
            entity.Property(e => e.Rname)
                .HasMaxLength(255)
                .HasColumnName("rname");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Uid).HasName("PRIMARY");

            entity.ToTable("user");

            entity.HasIndex(e => e.Rid, "rid");

            entity.Property(e => e.Uid).HasColumnName("uid");
            entity.Property(e => e.Email)
                .HasMaxLength(100)
                .HasColumnName("email");
            entity.Property(e => e.Password)
                .HasMaxLength(255)
                .HasColumnName("password");
            entity.Property(e => e.PhoneNo)
                .HasMaxLength(15)
                .HasColumnName("phone_no");
            entity.Property(e => e.Rid).HasColumnName("rid");
            entity.Property(e => e.Status)
                .HasDefaultValueSql("'Active'")
                .HasColumnType("enum('Active','Inactive')")
                .HasColumnName("status");
            entity.Property(e => e.Uname)
                .HasMaxLength(255)
                .HasColumnName("uname");

            entity.HasOne(d => d.RidNavigation).WithMany(p => p.Users)
                .HasForeignKey(d => d.Rid)
                .HasConstraintName("user_ibfk_1");
        });

        modelBuilder.Entity<ZoneOperator>(entity =>
        {
            entity.HasKey(e => e.OperatorId).HasName("PRIMARY");

            entity.ToTable("zone_operator");

            entity.HasIndex(e => e.AreaId, "area_id");

            entity.HasIndex(e => e.Uid, "uid");

            entity.Property(e => e.OperatorId).HasColumnName("operator_id");
            entity.Property(e => e.AreaId).HasColumnName("area_id");
            entity.Property(e => e.Designation)
                .HasMaxLength(255)
                .HasColumnName("designation");
            entity.Property(e => e.JoinedDate).HasColumnName("joined_date");
            entity.Property(e => e.Uid).HasColumnName("uid");

            entity.HasOne(d => d.Area).WithMany(p => p.ZoneOperators)
                .HasForeignKey(d => d.AreaId)
                .HasConstraintName("zone_operator_ibfk_2");

            entity.HasOne(d => d.UidNavigation).WithMany(p => p.ZoneOperators)
                .HasForeignKey(d => d.Uid)
                .HasConstraintName("zone_operator_ibfk_1");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
