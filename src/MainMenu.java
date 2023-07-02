package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    static MobileAppManager mobileAppManager = new MobileAppManager();

    public static void run() {
        int choice = 0;

        createApps();
        createMobiles();
        createUsers();

        System.out.println("-----   Welcome to the SMART PHONE MANAGEMENT Application   -----");
        System.out.println("Please enter your user name to login: ");

        while (!logIn()){
            logIn();
        }
        printMenu();
        boolean logIn = true;
        //assign mobile to user

        do {
            System.out.println("Make your choice? ");
            try {
                Scanner kb = new Scanner(System.in);
                choice = kb.nextInt();

                switch (choice) {
                    case 1 -> {
                        listApps();
                    }
                    case 5 -> {
                        searchApp();
                    }
                    case 9 -> {
                        //addApp();
                    }
                    case 13 -> {
                        //deleteApp();
                    }
                    case 17 -> {
                       // downloadApp();
                    }
                    case 18 -> {
                        //removeApp();
                    }
                    case 0 -> {
                        if (logIn)
                            logOut();
                    }
                    default -> printMenu();
                }
            } catch (InputMismatchException inputMismatchException){
                System.out.println("Please enter a number to choice !");
            }
        } while (choice != 0);
    }

    private static void printMenu(){
        System.out.println("####    MENU    ####");
        System.out.println("1: List apps ");
        System.out.println("2: List contacts ");
        System.out.println("3: List mobiles ");
        System.out.println("4: List users ");
        System.out.println("5: Search app ");
        System.out.println("6: Search contact ");
        System.out.println("7: Search mobiles ");
        System.out.println("8: Search users ");
        System.out.println("9: Add app");
        System.out.println("10: Add contact ");
        System.out.println("11: Add mobile ");
        System.out.println("12: Add user ");
        System.out.println("13: Delete app ");
        System.out.println("14: Delete contact ");
        System.out.println("15: Delete mobile ");
        System.out.println("16: Delete user ");
        System.out.println("17: Download app ");
        System.out.println("18: Remove app ");
        System.out.println("19: Back up apps ");
        System.out.println("20: Back up contacts ");
        System.out.println("21: Restore apps ");
        System.out.println("22: Restore contacts ");
        System.out.println("23: Filter mobiles by OS ");
        System.out.println("24: Categorize contacts by eMail ");
        System.out.println("0: Exit\n");
    }

    private static void createApps(){
        mobileAppManager.addApp(new App("Instagram", "1.0", 100))
                .addApp(new App("Whatsapp", "1.0", 200))
                .addApp(new App("Contacts", "1.0", 300))
                .addApp(new App("Facebook", "1.0", 400))
                .addApp(new App("", "1.0", 500));
    }

    private static void createMobiles(){
        mobileAppManager.addMobile(new Mobile(Brand.XIAOMI, "RedMi Note 10", 32, OperatingSystem.ANDROID))
                .addMobile(new Mobile(Brand.LG, "K61", 64, OperatingSystem.ANDROID))
                .addMobile(new Mobile(Brand.SAMSUNG, "Galaxy ", 128, OperatingSystem.ANDROID))
                .addMobile(new Mobile(Brand.NOKIA, "3310", 256, OperatingSystem.WINDOWS))
                .addMobile(new Mobile(Brand.APPLE, "iPhone 14 ProMax", 512, OperatingSystem.IOS));
    }

    private static void createUsers(){
        mobileAppManager.addUser(new User("Busra", "Uludag", "+90 546 9550000", "busra.uludag@gmail.com"))
                .addUser(new User("Zeynep", "Ozan", "+90 535 9550000", "zeynozan@hotmail.com"))
                .addUser(new User("Zakire", "Cinar", "+90 536 9550000", "zakirecin@gmail.com"))
                .addUser(new User("Nazmiye", "Kahraman", "+90 532 9550000", "natsmie@example.com"))
                .addUser(new User("Ceren", "Celik", "+90 555 9110000", "cerencelik@outlook.com"));
    }
    private static boolean logIn(){
        Scanner kb = new Scanner(System.in);
        String userName = kb.nextLine();
        //password can be added
        mobileAppManager.searchUserByName(userName);
        System.out.println("Your login is successful. Make your choice from menu below !");
        return true;
    }

    private static void logOut(){
        System.out.println("Log out is successful. GOOD BYE...");
    }

    private static void listApps(){
        System.out.println("-------------------------");
        mobileAppManager.listApps();
        System.out.println("-------------------------");
    }

    private static void searchApp(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter App name you want to search: ");
        String appName = kb.nextLine();
        mobileAppManager.searchAppByName(appName);
        System.out.println("-------------------------");
    }




}
