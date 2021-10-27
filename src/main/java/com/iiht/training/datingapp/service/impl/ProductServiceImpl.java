package com.iiht.training.datingapp.service.impl;

import com.iiht.training.datingapp.dto.ProductDto;
import com.iiht.training.datingapp.repository.ProductRepository;
import com.iiht.training.datingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public ProductDto enlistBidsForProduct(ProductDto product) {
        return null;
    }

    @Override
    public ProductDto putProductOnAuction(ProductDto product) {
        return null;
    }
}
