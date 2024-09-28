/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.Inputter;
/**
 *
 * @author nguyengiahuy
 */
public class productManage {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Receipt> receipts = new ArrayList<>();
    
  //-----------------------------------Import Receipt-------------------------------------------
  public void createImportReceipt(String receiptID, String productID, int quantity){
      int position = handleSearchProductByID(productID);
      if(position != -1){
          Product product = products.get(position);
          product.setQuantity(product.getQuantity() + quantity);
          Receipt receipt = new Receipt(receiptID, LocalDate.now(), "import", product, quantity);
          receipts.add(receipt);
          System.out.println("Import receipt created: " + receipt);
      }else{
          System.out.println(">Product not found. Cannot create import receipt.");
      }
  }  
  //-----------------------------------Export Receipt-------------------------------------------
public void createExportReceipt(String receiptID, String productID, int quantity){
    int position =handleSearchProductByID(productID);
    if(position != -1){
        Product product = products.get(position);
        if(product.getQuantity() >= quantity){
            product.setQuantity(product.getQuantity() - quantity );
            Receipt receipt = new Receipt(receiptID, LocalDate.now(), "export", product, quantity);
            receipts.add(receipt);
            System.out.println("Export receipt created: " + receipt);
        }else{
            System.out.println(">Not enough stock for export");
        }
    }else{
        System.out.println("Product not found. cannot create export receipt.");
    }
}
  //--------------------- Hiển thị tất cả các phiếu nhập/xuất-----------------
public void showAllReceipts(){
    if(receipts.isEmpty()){
        System.out.println(">No recript available");
    }else{
        for (Receipt receipt : receipts) {
            System.out.println(receipt);
        }
    }
}

  //-----------------------------------Add-------------------------------------------       
    public void handleAddProduct(){
        boolean check;
        do{
            boolean isDup = true;
           String newProductID = null;
           while(isDup){
               newProductID = Inputter.getString(">Enter Product ID(MM0000): ", ">Wrong format", "[M][M]\\d{4}");
               int position = handleSearchProductByID(newProductID);
               if(position != -1){
                   System.out.println(">product is dup");
                   isDup = true;
               }else{
                   isDup = false;
               }
           }
           String newProductName = Inputter.getString(">Enter fullname: ",">do not empty" );
           int newManufacturingDay = Inputter.getAnIteger(">Enter Day of manufacture",">Day between 1-31", 1,31);
           int newManufacturingMonth = Inputter.getAnIteger(">Enter Month of manufacture(1-12)", ">Month between 1-12",1,12);
           int newManufacturingYear = Inputter.getAnIteger(">Enter year of manufacture", "year must bewlow 2024", 0,2024);
           LocalDate newManufactureDate =LocalDate.of(newManufacturingYear, newManufacturingMonth, newManufacturingDay);
           
           int newExpiryDay = Inputter.getAnIteger(">Enter Day of expiry",">Day between 1-31", 1,31);
           int newExpiryMonth = Inputter.getAnIteger(">Enter Month of expiry(1-12)", ">Month between 1-12",1,12);
           int newExpiryYear = Inputter.getAnIteger(">Enter year of expiry", "year must greater than manufacturing year", newManufacturingYear ,3000);
           LocalDate newExpiryDate =LocalDate.of( newExpiryYear,  newExpiryMonth,newExpiryDay);
           
           Double price = Inputter.getADouble("Enter price : ", "Do not empty!");
           Product nProduct = new Product(newProductID , newProductName, newManufactureDate, newExpiryDate, 0, price);
           products.add(nProduct);
           check = useAgain();
        }while(check);
        
    
    }
  //-------------------------------Update--------------------------------------

    public void handleUpdateProduct(){
        boolean check;
        if(products.isEmpty()){
            System.out.println(">ProductList is empty, have nothing to update");
            return;
        }do{
            String productID = Inputter.getString("Enter productID that you want to update (Format MM0000) \n Press X to exit: ", ">Wrong format", "[M][M]\\\\d{4}|^[Xx]$");
            if(productID.equalsIgnoreCase("X")){
                System.out.println(">Exiting...");
                break;
            }
            int position = handleSearchProductByID(productID);
            if(position == -1){
                System.out.println("not found");
            }else{
                Product nProduct = products.get(position);

                String newProductName = Inputter.getString(">Enter fullname: ",">do not empty" );
                int newManufacturingDay = Inputter.getAnIteger(">Enter Day of manufacture",">Day between 1-31", 1,31);
                int newManufacturingMonth = Inputter.getAnIteger(">Enter Month of manufacture(1-12)", ">Month between 1-12",1,12);
                int newManufacturingYear = Inputter.getAnIteger(">Enter year of manufacture", "year must bewlow 2024", 0,2024);
                LocalDate newManufactureDate =LocalDate.of(newManufacturingYear, newManufacturingMonth, newManufacturingDay);

                int newExpiryDay = Inputter.getAnIteger(">Enter Day of expiry",">Day between 1-31", 1,31);
                int newExpiryMonth = Inputter.getAnIteger(">Enter Month of expiry(1-12)", ">Month between 1-12",1,12);
                int newExpiryYear = Inputter.getAnIteger(">Enter year of expiry", "expiration year must over manufacture yrar", newManufacturingYear, 3000);
                LocalDate newExpiryDate =LocalDate.of(newExpiryDay, newExpiryMonth, newExpiryYear);

                Double price = Inputter.getADouble("Enter price : ", "Do not empty!");
                nProduct.setProductID(productID);
                nProduct.setProductName(newProductName);
                nProduct.setManufacturingDate(newManufactureDate);
                nProduct.setExpiryDate(newExpiryDate);
                nProduct.setPrice(price);
                System.out.println("----------Update succesfully--------");
            }
            check = useAgain();
        }while(check);
    }
//---------------------------search by id---------------------------------------------

    public int handleSearchProductByID(String productID){
       
        for(int i = 0; i <= products.size() - 1; i++){
            if(products.get(i).getProductID().equals(productID)){
                return i;
            }
        }
        return -1;
    }
    //---------------------------search by name---------------------------------------------

   public int handleSearchProductByName(String productName){
       for(int i = 0; i<= products.size()-1; i++){
           if(products.get(i).getProductName().equals(productName)){
               return i;
           }
       }
       return -1;
    }
   //---------------------------search---------------------------------------------

    public void handleSearchProduct(){
        boolean check;
        if(products.isEmpty()){
            System.out.println(">Product list is empty, have nothing to search");
            return;
        }
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Search Product By ID");
            System.out.println("2. Search Product By Name");
            System.out.println(">Press X to exit");
            String choiceStr = sc.nextLine();
            if (choiceStr.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }
        int choice = Integer.parseInt(choiceStr);
        int position = 0;
        String productID;
        String productName;
        if (choice == 1) {
            productID = Inputter.getString(">Enter productID that you want to search (MM0000):\n>Press X to exit: ", ">Wrong format", "^[M][M]\\d{4}|^[Xx]$");
            if (productID.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }   
           position = handleSearchProductByID(productID);
        }
        if (choice == 2) {
            productName = Inputter.getString(">Enter product name that you want to search:\n>Press X to exit: ", ">Do not empty");
            if (productName.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }
            position = handleSearchProductByName(productName);
        }
        Product pr;
        if (position != -1) {
            pr = products.get(position);
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
public void handleremoveProduct(){
    boolean check;
    do{
        if(products.isEmpty()){
            System.out.println(">ProductList is empty, have nothing to remove");
            break;
        }
        String productID = Inputter.getString(">Enter productID (Format MM0000) \nPress X to exit","Wrong format", "^[M][M]\\d{4}|^[Xx]$");
        if(productID.equalsIgnoreCase("X")){
            System.out.println(">Exiting...");
            break;
        }
        int index = handleSearchProductByID(productID);
if (index == -1) {
    System.out.println(">Product does not exist");
} else {
    products.remove(index);
    System.out.println(">Product removed successfully");
}

        check = useAgain();
    }while(check);
}
//-----------------------list all-----------------------------
public void listAllProducts(){
    if(products.isEmpty()){
        System.out.println(">ProductList is empty, have nothing to list");
        return;
    }
    System.out.println("___________ProductList___________");
    for(Product pr : products){
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
    public Product getProductAtPosition(int position) {
    return products.get(position);
}
//---------------------ExpiredProduct-----------------------
    public void reportExpiredProducts(){
        boolean hasExpiredProducts = false;
        for(Product product : products){
            if(product.getExpiryDate().isBefore(LocalDate.now())){
                System.out.println(product);
                hasExpiredProducts = true;
            }
        }
        if(!hasExpiredProducts){
            System.out.println(">No expired products found.");
    }
}
//---------------------Products are selling-------------------
    public void reportSellingProducts(){
        boolean hasSellingProducts = false;
        for(Product product : products){
            if(product.getExpiryDate().isAfter(LocalDate.now())){
                System.out.println(product);
                hasSellingProducts = true;
            }
        }
        if(!hasSellingProducts){
            System.out.println(">No products currently being sold.");
        }
    }
//---------------------Products running out of stocks----------
    public void reportRunningOutOfStock(){
        //product sorted asc
        products.sort((p1,p2) -> Integer.compare(p1.getQuantity(), p2.getQuantity()));
        
        boolean hasLowStockProducts = false;
        for(Product product : products){
            if(product.getQuantity() > 0){
                System.out.println(product);
                hasLowStockProducts = true;
            }
    }
        if (!hasLowStockProducts) {
        System.out.println(">No products running out of stock.");
        }
    }
//-----------------Xem phieu nhap/ xuat cua san pham
    public void reportProductReceipts(String ProductID){
        boolean hasReceips = false;
        for(Receipt receipt : receipts){
            if(receipt.getProduct().getProductID().equalsIgnoreCase(ProductID)){
                System.out.println(receipt);
                hasReceips =true;
            }
        }
        if(!hasReceips){
            System.out.println(">No import/export receipts found for this product.");
        }
    }
    
     public boolean writeToFile(String fileName){
        boolean resutl = false;
        FileOutputStream fos ;
        ObjectOutputStream os = null;
        File file = new File(fileName);
        try {
            fos = new FileOutputStream(file);
            os = new ObjectOutputStream(fos);
            for (Product p : products) {
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
    
    //hàm ddocjj từ file
    public boolean readFromFile(String fileName) {
        products.clear();
        File file = new File(fileName);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis= new FileInputStream(file);
            ois= new ObjectInputStream(fis);
            Product product;
            while(fis.available()>0){
                product = (Product) ois.readObject();
                products.add(product);
            } 
            ois.close();
            fis.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean writeToFileWh(String fileName){
        boolean resutl = false;
        FileOutputStream fos ;
        ObjectOutputStream os = null;
        File file = new File(fileName);
        try {
            fos = new FileOutputStream(file);
            os = new ObjectOutputStream(fos);
            for (Receipt p : receipts) {
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
    
    //hàm ddocjj từ file
    public boolean readFromFileWh(String fileName) {
        receipts.clear();
        File file = new File(fileName);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis= new FileInputStream(file);
            ois= new ObjectInputStream(fis);
            Receipt receipt;
            while(fis.available()>0){
                receipt = (Receipt) ois.readObject();
                receipts.add(receipt);
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