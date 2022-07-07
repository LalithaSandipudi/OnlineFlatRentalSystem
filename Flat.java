package com.cg.ofr.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer flatId;
	@Column
	private Double cost;
	@Column
	private String availability;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="FlatAddress")
	private FlatAddress flatAddress;
	
  public Flat() {}
public Flat(Integer flatId, Double cost,  String availability,FlatAddress flatAddress) {
	super();
	this.flatId = flatId;
	this.cost = cost;
	this.flatAddress = flatAddress;
	this.availability =availability;
}
public Integer getFlatId() {
	return flatId;
}
public void setFlatId(int flatId) {
	this.flatId = flatId;
}
public Double getCost() {
	return cost;
}
public void setCost(Double cost) {
	this.cost = cost;
}
public FlatAddress getFlatAddress() {
	return flatAddress;
}
public void setFlatAddress(FlatAddress flatAddress) {
	this.flatAddress = flatAddress;
}


public String getavailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
@Override
public String toString() {
	return "Flat [flatId=" + flatId + ", cost=" + cost + ", availability=" + availability + ", flatAddress="
			+ flatAddress + "]";
}



  
}
