package com.iiht.training.datingapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private Long productName;
	private Integer startingPrice;
	private String shortDescription;
	private String detailedDescription;
	Date bidEndDate;
	@ElementCollection
	List<String> category=List.of("Painting", "Sculptor", "Ornament");

	public Product() {
	}

	public Product(Long productId, Integer startingPrice, String shortDescription, String detailedDescription, Date bidEndDate, List<String> category) {
		super();
		this.productId = productId;
		this.startingPrice=startingPrice;
		this.shortDescription=shortDescription;
		this.detailedDescription=detailedDescription;
		this.bidEndDate=bidEndDate;
		this.category=category;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductName() {
		return productName;
	}

	public void setProductName(Long productName) {
		this.productName = productName;
	}

	public Integer getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Integer startingPrice) {
		this.startingPrice = startingPrice;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}
}
