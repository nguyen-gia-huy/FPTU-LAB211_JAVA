/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class Vehicle {
    private String vehicleID;
    private String vehicleName;
    private String vehicleColor;
    private double vehiclePrice;
    private String vehicleBrand;
    private String vehicleType;
    private int quantity;
    private LocalDate productDate;

    public Vehicle(String vehicleID, String vehicleName, String vehicleColor, double vehiclePrice, String vehicleBrand, String vehicleType, int quantity, LocalDate productYear) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehiclePrice = vehiclePrice;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.quantity = quantity;
        this.productDate = productYear;
    }

    public Vehicle() {
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDate productDate) {
        this.productDate = productDate;
    }

    @Override
    public String toString() {
        return "vehicle{" + "vehicleID=" + vehicleID + ", vehicleName=" + vehicleName + ", vehicleColor=" + vehicleColor + ", vehiclePrice=" + vehiclePrice + ", vehicleBrand=" + vehicleBrand + ", vehicleType=" + vehicleType + ", quantity=" + quantity + ", productYear=" + productDate + '}';
    }
    
   
    
    
}
