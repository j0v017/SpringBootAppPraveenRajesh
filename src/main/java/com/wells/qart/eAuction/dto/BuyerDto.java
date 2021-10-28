package com.wells.qart.eAuction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
@Data
@NoArgsConstructor
public class BuyerDto {

	@NotNull
	private Long buyerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String firstName;

	@NotBlank
	@Length(min = 3, max = 25)
	private String lastName;

//	@NotNull
//	@Min(100000)
//	@Max(999999)
	private Long pin;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
	@NotBlank
	private String address;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String city;
	@NotBlank
	private String state;



//	Long productId;
//	Long bidAmt;
//
//	public BuyerDto() {
//	}
//
//	public BuyerDto(Long buyerId, String firstName, String lastName, Integer pin, Long phoneNumber, String address, String email, String city,
//                    String state, Long productId, Long bidAmt) {
//		super();
//		this.buyerId = buyerId;
//		this.firstName = firstName;
//		this.lastName = lastName;
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
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
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
//	@Override
//	public int hashCode() {
//		return Objects.hash(pin, city, state, email, address, firstName, lastName, phoneNumber, buyerId, productId, bidAmt);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BuyerDto other = (BuyerDto) obj;
//		return Objects.equals(pin, other.pin) && Objects.equals(city, other.city)
//				&& Objects.equals(state, other.state) && Objects.equals(email, other.email)
//				&& Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(lastName, other.lastName)
//				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(buyerId, other.buyerId)
//				&& Objects.equals(productId, other.productId) && Objects.equals(bidAmt, other.bidAmt);
//	}

}
