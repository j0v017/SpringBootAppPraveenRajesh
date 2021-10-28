package com.wells.qart.eAuction.service;

import com.wells.qart.eAuction.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto addProduct(ProductDto productDto);
    public ProductDto getProductById(Long productId);
    public List<ProductDto> getAllProducts();
    boolean deleteProduct(Long productId);


    public ProductDto enlistBidsForProduct(ProductDto product);
    public ProductDto putProductOnAuction(ProductDto product);
}
