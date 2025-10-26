package com.youssef.server_ui_demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;

        List<Product> products = new ArrayList<>();

        Product milk = new Product();
        milk.setName("Milk");
        milk.setProducer("Lamar");
        milk.setFeatured(true);
        milk.setImageUrl("/milk.jpg");
        products.add(milk);

        Product cheese = new Product();
        cheese.setName("Cheese");
        cheese.setProducer("Domty");
        cheese.setImageUrl("/cheese.jpg");
        cheese.setFeatured(false);
        products.add(cheese);

        Product water = new Product();
        water.setName("Water");
        water.setProducer("Nestle");
        water.setImageUrl("/water.jpg");
        water.setFeatured(true);
        products.add(water);

        Product chocolate = new Product();
        chocolate.setName("Chocolate");
        chocolate.setImageUrl("/choco.jpg");
        chocolate.setProducer("Galaxy");
        chocolate.setFeatured(true);
        products.add(chocolate);

        products.forEach(productRepo::save);
    }
}
