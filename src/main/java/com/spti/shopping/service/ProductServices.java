package com.spti.shopping.service;

import java.util.List;

import org.hibernate.boot.model.relational.Namespace.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.spti.shopping.model.Product;

@Service
public class ProductServices {

    @Autowired JdbcTemplate db;
    
    public List<Product> getAll(){
        System.out.println("\n Entered Product Services \n");
        String sql = "SELECT * FROM products";
        System.out.println("Query \n" + sql + " \n");
        List<Product> products = db.query(sql, new BeanPropertyRowMapper<>(Product.class));
        System.out.println("\n Result:" + products + "\n");

        return products;
    }

    public Product getProductById(String id) {
        String sql = "SELECT * FROM products WHERE id=" + id;
        Product product = db.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class));
        return product;
    }

    public List<Product> getProductByName(String name) {
        System.out.println("Name: " + name);
        String sql = "SELECT * FROM products WHERE name LIKE \'" + name + "%\'";
        System.out.println("Query \n" + sql + " \n");
        List<Product> product = db.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return product;
    }
}
