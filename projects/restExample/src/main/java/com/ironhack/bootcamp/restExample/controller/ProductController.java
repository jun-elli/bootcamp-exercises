package com.ironhack.bootcamp.restExample.controller;

import com.ironhack.bootcamp.restExample.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> productsRepo;

    public ProductController(){
        productsRepo = new ArrayList<>();

        productsRepo.add(new Product(1l, "Coke", "Soda drink"));
        productsRepo.add(new Product(2l, "Milk", "Before bed drink"));
        productsRepo.add(new Product(3l, "Water", "All day drink"));

    }

    @RequestMapping(value="/products", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct (@RequestBody Product product) {
        productsRepo.add(product);
    }

    @RequestMapping(value="/products", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> list() {
        return productsRepo;
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product readProduct(@PathVariable long id) {
        Product response = null;
        for (Product product : productsRepo) {
            if (product.getId() == id) {
                response = product;
            }
        }

        return response;
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> deleteProduct(@PathVariable long id) {
        Product response = null;
        for (Product product : productsRepo) {
            if (product.getId() == id) {
                response = product;
            }
        }

        if (response != null) {
            productsRepo.remove(response);
        }

        return productsRepo;
    }
}

