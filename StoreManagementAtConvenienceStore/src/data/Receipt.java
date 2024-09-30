/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.time.LocalDate;

/**
 *
 * @author nguyengiahuy
 */
public class Receipt {
    private String receiptID;
    private LocalDate date;
    private String type;
    private Product product;
    private int quantity;

    public Receipt() {
    }

    public Receipt(String receiptID, LocalDate date, String type, Product product, int quantity) {
        this.receiptID = receiptID;
        this.date = date;
        this.type = type;
        this.product = product;
        this.quantity = quantity;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Receipt{" + "receiptID=" + receiptID + ", date=" + date + ", type=" + type + ", product=" + product + ", quantity=" + quantity + '}';
    }
    
    
}
