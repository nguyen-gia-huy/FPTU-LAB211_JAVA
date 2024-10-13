/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.VehicleManage;
import java.util.Scanner;
import utils.Inputter;

/**
 *
 * @author nguye
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleManage vm = new VehicleManage();
        boolean out = true;
        String vehicleURL = "Vehicle.dat";
        while(out){
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("___________________________________________");
            System.out.println("|Application for managing vehicle by Java  |");
            System.out.println("|1. Manage Vehicles                        |");
            System.out.println("|2. Display Vehicle                        |");
            System.out.println("|3. Manage Vehicle File                    |");
            System.out.println("|4. Exit program                           |");
            System.out.println("|__________________________________________|");
            
            int choice = Inputter.getAnIteger(">Your choice: ", ">Choose 1-4");
            switch(choice){
                case 1:{
                    vehicleSubmenu(vm);
                    break;
                }              
                case 2:{
                    displayVehicle(vm);
                    break;
                }
                case 3:{
                    fileVehicle(vehicleURL ,vm);
                    break;
                }
                case 4:{
                    out = false;
                    break;
                }
                default:{
                    System.out.println(">Invalid choice. Please try again.");
                    }
                }
            }
        sc.close();
    }
    
    
    
    public static void vehicleSubmenu(VehicleManage vm) {
        boolean exitVehicleMenu = false;
        Scanner sc = new Scanner(System.in);
        
        while(!exitVehicleMenu){
            System.out.println("------------- Manage Vehicles --------------");
            System.out.println("|1. Add vehicle                            |");
            System.out.println("|2. Find vehicle                           |");
            System.out.println("|3. Update vehicle Information             |");
            System.out.println("|4. Remove vehicle By ID                   |");
            System.out.println("|5. Back to main menu                      |");
            System.out.println("|__________________________________________|");
            
            int vehicleChoice =  Inputter.getAnIteger(">Your choice: ", ">Choose 1-5");
            switch(vehicleChoice){
                case 1:{
                    vm.handleAddVehicle();
                    break;
                }
                case 2:{
                    vm.handleSearchVehicle();
                    break;
                }
                case 3:{
                    vm.handleUpdateVehicle();
                    break;
                }
                case 4:{
                    vm.handleRemoveVehicle();
                    break;
                }
                case 5:{
                    exitVehicleMenu = true;
                    break;
                }
                default:{
                    System.out.println(">Invalid choice. Please try again.");
                }
            }
        }
    }
    public static void displayVehicle(VehicleManage vm) {
        boolean exitDisplayMenu = false;
        Scanner sc = new Scanner(System.in);
        
        while(!exitDisplayMenu){
            System.out.println("------------- Manage Display Vehicle ---------------------");
            System.out.println("|1. Display all vehicles                                 |");
            System.out.println("|2. Display vehicles descending by price                 |");
            System.out.println("|3. Back to main menu                                    |");
            System.out.println("|________________________________________________________|");
            
            int receiptChoice = Inputter.getAnIteger(">Your choice: ", ">Choose 1-3");
            
            switch(receiptChoice){
             case 1:{
                 vm.listAllProducts();
                 break;
             }
             case 2:{
                 vm.listAllProductDescByPrice();
                 break;
             }
             case 3:{
                 exitDisplayMenu = true;
                 break;
             }
             default:{
                 System.out.println(">Invalid choice. Please try again.");            
             }
         }       
     }    
 }
    public static void fileVehicle(String vehicleURL ,VehicleManage vm) {
                boolean exitFileMenu = false;

        while(!exitFileMenu){
             System.out.println("--------Management Vehicle Data--------|");
            System.out.println("|1. Store List Vehicle                  |");
            System.out.println("|2. Read List Vehicle                   |");
            System.out.println("|3. Back to Main Menu                   |");
            System.out.println("|_______________________________________|");
            
            int choice = Inputter.getAnIteger("Select an option: ", "Choose 1-3");
            
                switch(choice){
                    case 1:{
                        if(vm.writeToFile(vehicleURL)){
                            System.out.println("Save to file successfully!");
                    }else{
                          System.out.println("Save to file fail!!!");   
                        }
                        break;
                    }
                    case 2:{
                        if(vm.readFromFile(vehicleURL)){
                             System.out.println("Read file successfully!");
                    }else{
                          System.out.println("Read file fail!!!");  
                    }
                        break;
                    }
                    case 3:{
                        exitFileMenu = true;
                        break;
                    }
                    default:{
                         System.out.println(">Invalid choice. Please try again.");            

                    }
                }
            }
        }
    }
