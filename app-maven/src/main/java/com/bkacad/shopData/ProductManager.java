package com.bkacad.shopData;

import java.sql.*;
import java.util.ArrayList;

public class ProductManager {
    static final String TABLE_NAME = "products";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shopManager?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "long200801";

    static public class Product {
        String id, name;
        Integer inventory, price;

        Product(String id, String name, Integer inventory, Integer price) {
            this.id = id;
            this.name = name;
            this.inventory = inventory;
            this.price = price;
        }

        public void printf() {
            System.out.printf("Id: %s, Name: %s, Inventory: %s, Price: %s\n", id, name, inventory, price);
        }
    }

    static public ArrayList<Product> getAllProducts() throws SQLException {
        final String QUERY = "select * from " + TABLE_NAME;
        ArrayList<Product> productsList = new ArrayList<>();

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);

        while (rs.next()) {
            productsList.add(new Product(rs.getString("id"), rs.getString("name"), rs.getInt("inventory"), rs.getInt("price")));
        }
        return productsList;
    }

    static public void addProduct(String id, String name, Integer inventory, Integer price) throws SQLException {
        Product newProduct = new Product(id, name, inventory, price);
        final String QUERY = "insert into " + TABLE_NAME + " (id,name,inventory,price) values ('" + id + "','" + name + "'," + inventory + "," + price + ")";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(QUERY);
    }

    static public void addProduct(String id, String name, Integer inventory, Integer price) throws SQLException {
        Product newProduct = new Product(id, name, inventory, price);
        final String QUERY = "insert into " + TABLE_NAME + " (id,name,inventory,price) values ('" + id + "','" + name + "'," + inventory + "," + price + ")";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(QUERY);
    }
}
