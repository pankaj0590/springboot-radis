package com.pankaj.springboot.service;

import com.pankaj.springboot.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> allProduct();
    Product findProductById(Integer id);
}
