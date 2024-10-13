/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Inputter;
/**
 *
 * @author nguye
 */
public class VehicleManage {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    
    //----------------------------------------1.Manage Vehicle------------------------------------------------------------------------------------------------------------------- 
      //-----------------------------------Add-------------------------------------------       
    public void handleAddVehicle(){
        boolean check;
        do{
            boolean isDup = true;
            String newVehicleID = null;
            while(isDup){
                newVehicleID = Inputter.getString(">Enter vehicle ID(MM0000): ", ">Wrong format", "[M][M]\\d{4}");
                int position = handleSearchVehicleByID(newVehicleID);
                if(position != -1){
                    System.out.println(">Product is dup");
                    isDup = true;
                }else{
                    isDup = false;
                }
            }
            String newVehicleName = Inputter.getString("Enter vehicle name", ">do not empty");
            String newVehicleColor = Inputter.getString("Enter vehicle color: ", ">do not empty");
            double newVehiclePrice = Inputter.getADouble("Enter price", ">do not empty");
            String newVehicleBrand = Inputter.getString("Enter vehicle brand: ", ">do not empty");
            String newvehicleType = Inputter.getString("Enter vehicle type: ", ">do not empty");
            int quantity = Inputter.getAnIteger("Enter quantity", "Do not empty");
            int newManufacturingMonth = Inputter.getAnIteger(">Enter Month of manufacture(1-12)", ">Month between 1-12",1,12);
            int newManufacturingDay;
                if (newManufacturingMonth == 2) {
                    newManufacturingDay = Inputter.getAnIteger(">Enter day of manufacturing (1-28): ", ">Day between 1-28", 1, 28);
                } else if (newManufacturingMonth == 4 || newManufacturingMonth == 6 || newManufacturingMonth == 9 || newManufacturingMonth == 11) {
                    newManufacturingDay = Inputter.getAnIteger(">Enter day of manufacturing (1-30): ", ">Day between 1-30", 1, 30);
                } else {
                    newManufacturingDay = Inputter.getAnIteger(">Enter day of manufacturing (1-31): ", ">Day between 1-31", 1, 31);
                }
                int newManufacturingYear = Inputter.getAnIteger(">Enter year of manufacture", "year must bewlow 2024", 1,2024);
                LocalDate newManufactureDate = LocalDate.of(newManufacturingYear, newManufacturingMonth, newManufacturingDay);
            
            Vehicle nVehicle = new Vehicle(newVehicleID, newVehicleName, newVehicleColor, newVehiclePrice, newVehicleBrand, newvehicleType, quantity, newManufactureDate);
            vehicles.add(nVehicle);
            check = useAgain();
        }while(check);
    } 
      //-------------------------------Update--------------------------------------
    public void handleUpdateVehicle(){
        boolean check;
        if(vehicles.isEmpty()){
            System.out.println(">Vehicles list is empty, have nothing to update");
            return;
        }
    do{
      String vehicleID = Inputter.getString("Enter vehicleID that you want to update (Format MM0000) \nPress X to exit: ", ">Wrong format", "[M][M]\\d{4}");   
      if(vehicleID.equalsIgnoreCase("X")){
                System.out.println(">Exiting...");
                break;
    }
      int position = handleSearchVehicleByID(vehicleID);
      if(position == -1){
          System.out.println("not found");
      }else{
          Vehicle nVehicle = vehicles.get(position);
          
          String newVehicleName = Inputter.getString("Enter vehicle name", ">do not empty");
          String newVehicleColor = Inputter.getString("Enter vehicle color: ", ">do not empty");
            double newVehiclePrice = Inputter.getADouble("Enter price", ">do not empty");
            String newVehicleBrand = Inputter.getString("Enter vehicle brand: ", ">do not empty");
            String newvehicleType = Inputter.getString("Enter vehicle type: ", ">do not empty");
            int quantity = Inputter.getAnIteger("Enter quantity", "Do not empty");
             int newManufacturingMonth = Inputter.getAnIteger(">Enter Month of manufacture(1-12)", ">Month between 1-12",1,12);
                int newManufacturingDay;
                if (newManufacturingMonth == 2) {
                    newManufacturingDay = Inputter.getAnIteger(">Enter day of manufacturing (1-28): ", ">Day between 1-28", 1, 28);
                } else if (newManufacturingMonth == 4 || newManufacturingMonth == 6 || newManufacturingMonth == 9 || newManufacturingMonth == 11) {
                    newManufacturingDay = Inputter.getAnIteger(">Enter day of manufacturing (1-30): ", ">Day between 1-30", 1, 30);
                } else {
                    newManufacturingDay = Inputter.getAnIteger(">Enter day of manufacturing (1-31): ", ">Day between 1-31", 1, 31);
                }
                int newManufacturingYear = Inputter.getAnIteger(">Enter year of manufacture", "year must bewlow 2024", 1,2024);
                LocalDate newManufactureDate = LocalDate.of(newManufacturingYear, newManufacturingMonth, newManufacturingDay);
            nVehicle.setVehicleName(newVehicleName);
            nVehicle.setVehicleColor(newVehicleColor);
            nVehicle.setVehiclePrice(newVehiclePrice);
            nVehicle.setVehicleBrand(newVehicleBrand);
            nVehicle.setVehicleType(newvehicleType);
            nVehicle.setProductDate(newManufactureDate);
            System.out.println("----------Update succesfully--------");
      }
      check = useAgain();
}
    while(check);
    }
    //---------------------------search by id---------------------------------------------

    public int handleSearchVehicleByID(String vehicleID){
        for(int i = 0; i <= vehicles.size() - 1; i++){
            if(vehicles.get(i).getVehicleID().equals(vehicleID)){
                return i;
            }
        }
        return -1;
    }
        //---------------------------search by name---------------------------------------------

    public int handleSearchVehicletByName(String vehicleName){
        for(int i = 0; i<= vehicles.size()-1; i++){
           if(vehicles.get(i).getVehicleName().equals(vehicleName)){
               return i;
           }
       }
       return -1;
    }
       //---------------------------search---------------------------------------------

    public void handleSearchVehicle(){
        boolean check;
        if(vehicles.isEmpty()){
            System.out.println(">Vehicle list is empty, have nothing to search");
            return;
        }
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Search Vehicle By ID");
            System.out.println("2. Search Vehicle By Name");
            System.out.println(">Press X to exit");
            String choiceStr = sc.nextLine();
            if (choiceStr.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }
        int choice = Integer.parseInt(choiceStr);
        int position = 0;
        String vehicleID;
        String vehicleName;
        if (choice == 1) {
            vehicleID = Inputter.getString(">Enter vehicle ID that you want to search (MM0000):\n>Press X to exit: ", ">Wrong format", "^[M][M]\\d{4}|^[Xx]$");
            if (vehicleID.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }   
           position = handleSearchVehicleByID(vehicleID);
        }
        if (choice == 2) {
            vehicleName = Inputter.getString(">Enter vehicle name that you want to search:\n>Press X to exit: ", ">Do not empty");
            if (vehicleName.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }
            position = handleSearchVehicletByName(vehicleName);
        }
        Vehicle pr;
        if (position != -1) {
            pr = vehicles.get(position);
        } else {
            pr = null;
        }

        if (pr != null) {
            System.out.println(pr);
        } else {
            System.out.println(">Not Found");
        }
        check = useAgain();

        }while(check);
    }
//--------------------------------remove----------------------------------- 
    public void handleRemoveVehicle(){
        boolean check;
        do{
            if(vehicles.isEmpty()){
                System.out.println(">Vehicle list is empty, have nothing to remove"); 
                break;
            }
            String VehicleID = Inputter.getString(">Enter vehicle ID (Format MM0000) \nPress X to exit","Wrong format", "^[M][M]\\d{4}|^[Xx]$");
            if(VehicleID.equalsIgnoreCase("X")){
                System.out.println(">Exiting...");
                break;
        }
           int index = handleSearchVehicleByID(VehicleID);
           if(index == -1){
               System.out.println("Vehicle does not exits");
           }else{
               vehicles.remove(index);
               System.out.println(">Vehicle removed successfully");
           }
           check = useAgain();
        }while(check);
    }
    //-----------------------list all-----------------------------
public void listAllProducts(){
    if(vehicles.isEmpty()){
        System.out.println(">Vehicle List is empty, have nothing to list");
        return;
    }
    System.out.println("___________Vehicle List___________");
    for(Vehicle pr : vehicles){
        System.out.println(pr);
    }
}
public void listAllProductDescByPrice(){
    if(vehicles.isEmpty()){
        System.out.println(">Vehicle List is empty, have nothing to list");
        return;
    }
    vehicles.sort((v1,v2) -> Double.compare(v1.getVehiclePrice(), v2.getVehiclePrice()));
    System.out.println("______Vehicle List Sorted by Price (Descending)______");
    for (Vehicle pr : vehicles) {
        System.out.println(pr);
    }
}
//----------------------UseAgain-----------------------------

    public boolean useAgain (){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\n**Press ENTER to continue, ANY KEY to exit the program**\n");     
        String checkESC = sc.nextLine();
        if(checkESC.isEmpty()) return true;
        else return false;
}
    public Vehicle getProductAtPosition(int position) {
    return vehicles.get(position);
}
//6.------------------------Saving Vehicle to file.----------------------------
    public boolean writeToFile(String fileName){
        boolean resutl = false;
        FileOutputStream fos ;
        ObjectOutputStream os = null;
        File file = new File(fileName);
        try {
            fos = new FileOutputStream(file);
            os = new ObjectOutputStream(fos);
            for (Vehicle p : vehicles) {
                os.writeObject(p);
            }
            resutl = true;
            os.flush();
            os.close();
        } catch (Exception e) {
           e.printStackTrace();
        }   
        return resutl;
    }
//7.------------------------Printing list Vehicles the file.-------------------------------------
public boolean readFromFile(String fileName) {
        vehicles.clear();
        File file = new File(fileName);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis= new FileInputStream(file);
            ois= new ObjectInputStream(fis);
            Vehicle product;
            while(fis.available()>0){
                product = (Vehicle) ois.readObject();
                vehicles.add(product);
            } 
            ois.close();
            fis.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
