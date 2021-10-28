package com.wells.qart.eAuction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "buyers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long buyerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String firstName;
	@NotBlank
	@Length(min = 3, max = 25)
	private String lastName;
	private Long pin;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
	private String address;
	@Email
	@NotBlank
	private String email;
	private String city;
	private String state;
//	Long productId;
//	Long bidAmt;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="buyer")
	@JsonIgnore
	private Set<Bid> bids = new HashSet<>();

//	public Long getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Long productId) {
//		this.productId = productId;
//	}
//
//	public Long getBidAmt() {
//		return bidAmt;
//	}
//
//	public void setBidAmt(Long bidAmt) {
//		this.bidAmt = bidAmt;
//	}
//
//	public Buyer() {
//	}
//
//	public Buyer(Long buyerId, String firstName, String lastName, Integer pin, Long phoneNumber, String address, String email, String city,
//                 String state, Long productId, Long bidAmt) {
//		super();
//		this.buyerId = buyerId;
//		this.firstName = firstName;
//		this.lastName=lastName;
//		this.pin = pin;
//		this.phoneNumber = phoneNumber;
//		this.address = address;
//		this.email = email;
//		this.city = city;
//		this.state = state;
//		this.productId=productId;
//		this.bidAmt=bidAmt;
//	}
//
//	public Long getBuyerId() {
//		return buyerId;
//	}
//
//	public void setBuyerId(Long buyerId) {
//		this.buyerId = buyerId;
//	}
//
//	public String getName() {
//		return firstName;
//	}
//
//	public void setName(String name) {
//		this.firstName = name;
//	}
//
//	public Integer getPin() {
//		return pin;
//	}
//
//	public void setPin(Integer pin) {
//		this.pin = pin;
//	}
//
//	public Long getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(Long phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//
}
