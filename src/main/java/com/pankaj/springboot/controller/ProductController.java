package com.pankaj.springboot.controller;

import com.pankaj.springboot.entity.Product;
import com.pankaj.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    @Cacheable(value = "product")
    public List<Product> getAllProducts() {
        return productService.allProduct();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "product")
    public Product findProduct(@PathVariable int id) {
        return productService.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return null;//productService.deleteProduct(id);



    }

}
