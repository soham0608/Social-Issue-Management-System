package com.operatorservice.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "area")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Area {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer area_id;

    @Column(nullable = false)
    private String area_name;

    @Column(length = 10)
    private String pincode;

    //Getter Setter
	public Integer getAreaId() {
		return area_id;
	}

	public void setAreaId(Integer areaId) {
		this.area_id = areaId;
	}

	public String getAreaName() {
		return area_name;
	}

	public void setAreaName(String areaName) {
		this.area_name = areaName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	} 
}

