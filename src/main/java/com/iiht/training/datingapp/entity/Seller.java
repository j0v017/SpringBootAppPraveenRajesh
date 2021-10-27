package com.iiht.training.datingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	private String firstName;
	private String lastName;
	private Integer pin;
	private Long phoneNumber;
	private String address;
	private String email;
	private String city;
	private String state;

	public Seller() {
	}

	public Seller(Long sellerId, String firstName, String lastName, Integer pin, Long phoneNumber, String address, String email, String city,
				  String state) {
		super();
		this.sellerId = sellerId;
		this.firstName = firstName;
		this.lastName=lastName;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.city = city;
		this.state = state;
	}

	public Long getsellerId() {
		return sellerId;
	}

	public void setsellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
