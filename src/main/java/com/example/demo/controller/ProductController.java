package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
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

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        for (Product p : productRepo.findAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id) {
        for (Product p : productRepo.findAll()) {
            if (p.getId() == id) {
                productRepo.delete(p);

                return "Product removed.";
            }
        }

        return "Product not found";
    }


}


