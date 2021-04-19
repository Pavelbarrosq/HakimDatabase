package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping(path = "/add")
    public String addProduct(@RequestParam String title, String description, int price, String imageURL, int quantity){
        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageURL(imageURL);
        p.setQuantity(quantity);

        productRepo.save(p);
        return "Product was added!";
    }

    @GetMapping(path = "/all")
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

}


