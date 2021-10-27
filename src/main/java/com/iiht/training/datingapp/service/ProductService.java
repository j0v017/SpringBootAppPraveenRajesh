package com.iiht.training.datingapp.service;

import com.iiht.training.datingapp.dto.ProductDto;

public interface ProductService {
    public ProductDto enlistBidsForProduct(ProductDto product);
    public ProductDto putProductOnAuction(ProductDto product);
}
