package com.iiht.training.datingapp.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductDto {
    @NotNull
    private Long productId;
    @NotNull
    @Length(min = 5, max = 30)
    private Long productName;
    private Integer startingPrice;
    private String shortDescription;
    private String detailedDescription;
    Date bidEndDate;
    List<String> category=List.of("Painting", "Sculptor", "Ornament");

    public ProductDto(){}

    public ProductDto(Long productId, Long productName, Integer startingPrice, String shortDescription, String detailedDescription, Date bidEndDate, List<String> category) {
        this.productId = productId;
        this.productName = productName;
        this.startingPrice = startingPrice;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.bidEndDate = bidEndDate;
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(startingPrice, that.startingPrice) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(detailedDescription, that.detailedDescription) && Objects.equals(bidEndDate, that.bidEndDate) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, startingPrice, shortDescription, detailedDescription, bidEndDate, category);
    }
}
