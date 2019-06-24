package server.main.beans;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;

@Entity
public class Volunteer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int volunteerId;
	private String volunteerName;
	private String volunteerPhoneNumber;
	private int numberOfBox;
	private String areaDelivery;
	@OneToOne(cascade = CascadeType.ALL)
	private Volunteer partner;
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "family")
	private List<Family> family = new ArrayList<>();
//const
	public Volunteer() {}
	public Volunteer(String volunteerName, String volunteerPhoneNumber, int numberOfBox, String areaDelivery,
			Volunteer partner) {
		this.volunteerName = volunteerName;
		this.volunteerPhoneNumber = volunteerPhoneNumber;
		this.numberOfBox = numberOfBox;
		this.areaDelivery = areaDelivery;
		this.partner = partner;
	}
public Volunteer(int volunteerId, String volunteerName, String volunteerPhoneNumber, int numberOfBox,
		String areaDelivery, Volunteer partner) {
	this.volunteerId = volunteerId;
	this.volunteerName = volunteerName;
	this.volunteerPhoneNumber = volunteerPhoneNumber;
	this.numberOfBox = numberOfBox;
	this.areaDelivery = areaDelivery;
	this.partner = partner;
}
//get&set
public int getVolunteerId() {
	return volunteerId;
}
public void setVolunteerId(int volunteerId) {
	this.volunteerId = volunteerId;
}
public String getVolunteerName() {
	return volunteerName;
}
public void setVolunteerName(String volunteerName) {
	this.volunteerName = volunteerName;
}
public String getVolunteerPhoneNumber() {
	return volunteerPhoneNumber;
}
public void setVolunteerPhoneNumber(String volunteerPhoneNumber) {
	this.volunteerPhoneNumber = volunteerPhoneNumber;
}
public int getNumberOfBox() {
	return numberOfBox;
}
public void setNumberOfBox(int numberOfBox) {
	this.numberOfBox = numberOfBox;
}
public String getAreaDelivery() {
	return areaDelivery;
}
public void setAreaDelivery(String areaDelivery) {
	this.areaDelivery = areaDelivery;
}
public Volunteer getPartner() {
	return partner;
}
public void setPartner(Volunteer partner) {
	this.partner = partner;
}
@Override
public String toString() {
	return "Volunteer [volunteerId=" + volunteerId + ", volunteerName=" + volunteerName + ", volunteerPhoneNumber="
			+ volunteerPhoneNumber + ", numberOfBox=" + numberOfBox + ", areaDelivery=" + areaDelivery + ", partner="
			+ partner + "]";
}

}
