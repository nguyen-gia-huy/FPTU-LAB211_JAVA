import data.productManage;
import java.util.Scanner;
import utils.Inputter;
import java.lang.String;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        productManage pm = new productManage();
        boolean out = true;
        String proURL = "product.dat";
        String wareURL = "warehouse.dat";
        while(out) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("___________________________________________");
            System.out.println("|Application for managing product by Java  |");
            System.out.println("|1. Manage Products                        |");
            System.out.println("|2. Manage Import/Export Receipts          |"); // Gọi sub menu mới
            System.out.println("|3. Reports                                |");
            System.out.println("|4. menuStore                              |");
            System.out.println("|5. Exit program                           |");
            System.out.println("|__________________________________________|");
            
            int choice = Inputter.getAnIteger(">Your choice: ", ">Choose 1-4");
            switch(choice) {
                case 1: {
                    productSubMenu(pm);  // Gọi sub menu cho quản lý sản phẩm
                    break;
                }
                case 2: {
                    receiptSubMenu(pm);  // Gọi sub menu cho phiếu nhập/xuất
                    break;
                }
                case 3: {
                    reportSubMenu(pm);  // Gọi sub menu cho báo cáo
                    break;
                }
                case 4: {
                    menuStore(proURL ,wareURL, pm);  // Gọi sub menu cho báo cáo
                    break;
                }
                case 5: {
                    out = false;
                    break;
                }
                default: {
                    System.out.println(">Invalid choice. Please try again.");
                }
            }
        }
        sc.close();
    }

    // Sub menu cho quản lý sản phẩm
    public static void productSubMenu(productManage pm) {
        boolean exitProductMenu = false;
        Scanner sc = new Scanner(System.in);
        
        while (!exitProductMenu) {
            System.out.println("------------- Manage Products -------------");
            System.out.println("|1. Show all products information          |");
            System.out.println("|2. Add product                            |");
            System.out.println("|3. Find product                           |");
            System.out.println("|4. Update product Information             |");
            System.out.println("|5. Remove product By ID                   |");
            System.out.println("|6. Back to main menu                      |");
            System.out.println("|__________________________________________|");
            
            int productChoice = Inputter.getAnIteger(">Your choice: ", ">Choose 1-6");
            switch (productChoice) {
                case 1: {
                    pm.listAllProducts();
                    break;
                }
                case 2: {
                    pm.handleAddProduct();
                    break;
                }
                case 3: {
                    // Tìm sản phẩm logic ở đây
                    System.out.print(">Enter Product ID to find: ");
                    String productID = sc.nextLine();
                    pm.handleSearchProductByID(productID);
                    break;
                }
                case 4: {
                    pm.handleUpdateProduct();
                    break;
                }
                case 5: {
                    pm.handleremoveProduct();
                    break;
                }
                case 6: {
                    exitProductMenu = true; // Quay lại menu chính
                    break;
                }
                default: {
                    System.out.println(">Invalid choice. Please try again.");
                }
            }
        }
    }

    // Sub menu cho quản lý phiếu nhập/xuất
    public static void receiptSubMenu(productManage pm) {
        boolean exitReceiptMenu = false;
        Scanner sc = new Scanner(System.in);
        
        while (!exitReceiptMenu) {
            System.out.println("------------- Manage Import/Export Receipts -------------");
            System.out.println("|1. Create Import Receipt                                |");
            System.out.println("|2. Create Export Receipt                                |");
            System.out.println("|3. Show all receipts                                    |");
            System.out.println("|4. Back to main menu                                    |");
            System.out.println("|________________________________________________________|");

            int receiptChoice = Inputter.getAnIteger(">Your choice: ", ">Choose 1-4");

            switch (receiptChoice) {
                case 1: {
                    System.out.print(">Enter receipt ID: ");
                    String receiptID = sc.nextLine();
                    System.out.print(">Enter Product ID to import: ");
                    String productID = sc.nextLine();
                    int quantity = Inputter.getAnIteger(">Enter quantity: ", ">Invalid quantity");
                    pm.createImportReceipt(receiptID, productID, quantity);
                    break;
                }
                case 2: {
                    System.out.print(">Enter receipt ID: ");
                    String receiptID = sc.nextLine();
                    System.out.print(">Enter Product ID to export: ");
                    String productID = sc.nextLine();
                    int quantity = Inputter.getAnIteger(">Enter quantity: ", ">Invalid quantity");
                    pm.createExportReceipt(receiptID, productID, quantity);
                    break;
                }
                case 3: {
                    pm.showAllReceipts();
                    break;
                }
                case 4: {
                    exitReceiptMenu = true; // Quay lại menu chính
                    break;
                }
                default: {
                    System.out.println(">Invalid choice. Please try again.");
                }
            }
        }
    }

    // Sub menu cho báo cáo
    public static void reportSubMenu(productManage pm) {
        boolean exitReportMenu = false;
        Scanner sc = new Scanner(System.in);
        
        while (!exitReportMenu) {
            System.out.println("------------------ Reports ------------------");
            System.out.println("|1. Products that have expired               |");
            System.out.println("|2. Products that the store is selling       |");
            System.out.println("|3. Products that are running out of stock   |");
            System.out.println("|4. Import/export receipt of a product       |");
            System.out.println("|5. Back to main menu                        |");
            System.out.println("|____________________________________________|");

            int reportChoice = Inputter.getAnIteger(">Choose report: ", ">Invalid choice");

            switch(reportChoice) {
                case 1: {
                    pm.reportExpiredProducts();
                    break;
                }
                case 2: {
                    pm.reportSellingProducts();
                    break;
                }
                case 3: {
                    pm.reportRunningOutOfStock();
                    break;
                }
                case 4: {
                    System.out.print(">Enter Product ID: ");
                    String productID = sc.nextLine();
                    pm.reportProductReceipts(productID);
                    break;
                }
                case 5: {
                    exitReportMenu = true; // Quay lại menu chính
                    break;
                }
                default: {
                    System.out.println(">Invalid report choice.");
                }
            }
        }
    }
    public static void menuStore(String URLPro, String URLWare, productManage pm ) {
         while(true){
            System.out.println("---------Management Data----------");
            System.out.println("|1. Store List Product            |");
            System.out.println("|2. Store List WareHouse          |");
            System.out.println("|3. Read List Product             |");
            System.out.println("|4. Read List WareHouse           | ");
            System.out.println("|5. Back to Main Menu             |");
            System.out.println("|_________________________________|");

            int choice;
            do{
                choice = Inputter.getAnIteger("Select an option: ", "Choose 1-5");
                if(choice <= 0 || choice >= 6){
                    System.out.println("Choose 1-5");
                }
            }while(choice <= 0 || choice >= 6);
            switch (choice) {
                case 1 : {
                    if(pm.writeToFile(URLPro)){
                    System.out.println("Save to file successfully!");
                    }else{
                          System.out.println("Save to file fail!!!");  
                    }
                    break;
                }
                case 2 : {
                    if(pm.writeToFileWh(URLWare)){
                        System.out.println("Save to file successfully!");
                    }else{
                          System.out.println("Save to file fail!!!");  
                    }
                    break;
                }
                case 3 : {
                    if(pm.readFromFile(URLPro)){
                        System.out.println("Read file successfully!");
                    }else{
                          System.out.println("Read file fail!!!");  
                    }
                    break;
                }
                case 4 : {
                    if(pm.readFromFileWh(URLWare)){
                        System.out.println("Read file successfully!");
                    }else{
                          System.out.println("Read file fail!!!");  
                    }
                    break;
                }
                case 5 : {
                    return;
                }
            }
        }   
    }
}
