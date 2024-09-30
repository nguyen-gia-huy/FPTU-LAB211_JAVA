package data;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nguyengiahuy
 */ 
public class Product implements Serializable {
   private String productID;
   private String productName;
   private LocalDate manufacturingDate;
   private LocalDate expiryDate;
   private int quantity;
   private double price;

    public Product() {
        
    }

    public Product(String productID, String productName, LocalDate manufacturingDate, LocalDate expiryDate, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + ", quantity=" + quantity + ", price=" + price + '$'+'}';
    }
   
    
   
}
