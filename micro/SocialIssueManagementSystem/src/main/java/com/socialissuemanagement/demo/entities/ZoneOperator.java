package com.socialissuemanagement.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "zone_operator")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ZoneOperator {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operator_id;

    @OneToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    private Area area;

    private LocalDate joined_date;

    //Getter Setter
	public Integer getOperatorId() {
		return operator_id;
	}

	public void setOperatorId(Integer operatorId) {
		this.operator_id = operatorId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public LocalDate getJoinedDate() {
		return joined_date;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joined_date = joinedDate;
	}
}
