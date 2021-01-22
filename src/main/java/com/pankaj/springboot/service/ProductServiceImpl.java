package com.pankaj.springboot.service;

import com.pankaj.springboot.entity.Product;
import com.pankaj.springboot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        log.info("Save Product {}",product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> allProduct() {
        log.info("return all products {}");
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Integer id) {
        log.info("return  product by id {}", id);
        Optional<Product>  product =productRepository.findById(id);
        Product product1 = new Product();
        if(product.isPresent()){
            product1.setId(product.get().getId());
            product1.setName(product.get().getName());
            product1.setPrice(product.get().getPrice());
            product1.setQty(product.get().getQty());
        }

        return product1;
    }
}
