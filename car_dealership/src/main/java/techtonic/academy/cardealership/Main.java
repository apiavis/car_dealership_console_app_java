package techtonic.academy.cardealership;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import techtonic.academy.cardealership.sales.Customer;
import techtonic.academy.cardealership.vehicles.Vehicle;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Factory factory = new Factory();
        Dealership dealership = new Dealership(null,null);
        ArrayList<Vehicle> carLot = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        Vehicle[] readyToShip = factory.readyToShip;
        String runAgain = "yes";

        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println(" WELCOME TO YOUR DEALERSHIP APP ");
        System.out.println("---------------------------------");
        System.out.println("");

        while (runAgain == "yes") {
            ProgramNavigation.printMenuOptions();

            System.out.println("Which option would you like (1-12)?: ");
            Scanner scanner = new Scanner(System.in);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println("");

            while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5
            && userChoice != 6 && userChoice != 7 && userChoice != 8 && userChoice != 9 && userChoice != 10
            && userChoice != 11 && userChoice != 12) {
                System.out.println("Please enter a valid response.");
                ProgramNavigation.printMenuOptions();
                System.out.println("Which option would you like (1-12)?: ");
                userChoice = Integer.parseInt(scanner.nextLine());
                System.out.println("");
            }

            switch(userChoice)
            {
                case 1 :
                    factory.printFactoryVehicles();
                    break;

                case 2 :
                    System.out.println("Please enter the name of your dealership: ");
                    String dealershipName = scanner.nextLine();
                    System.out.println("Please enter the starting balance of your dealership (needs to be greater than 2,000,000): ");
                    BigDecimal startingBalance = scanner.nextBigDecimal();
                    Dealership newDealership = new Dealership(dealershipName, startingBalance);
                    dealership = newDealership;
                    newDealership.printDealershipInfo();
                    break;

                case 3 :
                    dealership.purchaseVehicles(factory, dealership);
                    carLot = dealership.carLot;
                    break;

                case 4 :
                    dealership.printDealershipInfo();
                    break;

                case 5 :
                    System.out.println("Please enter the vin number of the vehicle you would like to check insurance for: ");
                    String vinInsurance = scanner.nextLine();
                    Vehicle vehicleInsurance = null;
                    for (int i = 0; i < carLot.size(); i++) {
                        if (carLot.get(i).getVin().equalsIgnoreCase(vinInsurance)) {
                            vehicleInsurance = carLot.get(i);
                        }
                    }
                    dealership.checkInsurance(vehicleInsurance, dealership);
                    break;

                case 6 :
                    System.out.println("Please enter the vin number of the vehicle you would like to check maintenance for: ");
                    String vinMaintenance = scanner.nextLine();
                    Vehicle vehicleMaintenance = null;
                    for (int i = 0; i < carLot.size(); i++) {
                        if (carLot.get(i).getVin().equalsIgnoreCase(vinMaintenance)) {
                            vehicleMaintenance = carLot.get(i);
                        }
                    }
                    dealership.checkMaintenance(vehicleMaintenance, dealership);
                    break;

                case 7 :
                    System.out.println("Please enter the vin number of the vehicle you would like to refuel: ");
                    String vinRefuel = scanner.nextLine();
                    Vehicle vehicleRefuel = null;
                    for (int i = 0; i < carLot.size(); i++) {
                        if (carLot.get(i).getVin().equalsIgnoreCase(vinRefuel)) {
                            vehicleRefuel = carLot.get(i);
                        }
                    }
                    dealership.refuelVehicle(vehicleRefuel);
                    break;

                case 8 :
                    System.out.println("Please enter the vin number of the vehicle you would like to wash: ");
                    String vinWash = scanner.nextLine();
                    Vehicle vehicleWash = null;
                    for (int i = 0; i < carLot.size(); i++) {
                        if (carLot.get(i).getVin().equalsIgnoreCase(vinWash)) {
                            vehicleWash = carLot.get(i);
                        }
                    }
                    dealership.washVehicle(vehicleWash, dealership);
                    break;

                case 9 :
                    System.out.println("Please enter the vin number of the vehicle you would like to test drive: ");
                    String vinTestDrive = scanner.nextLine();
                    Vehicle vehicleTestDrive = null;
                    for (int i = 0; i < carLot.size(); i++) {
                        if (carLot.get(i).getVin().equalsIgnoreCase(vinTestDrive)) {
                            vehicleTestDrive = carLot.get(i);
                        }
                    }
                    dealership.testDriveVehicle(vehicleTestDrive, dealership);
                    break;

                case 10 :
                    System.out.println("Please enter the first and last name of the customer: ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the address of the customer: ");
                    String address = scanner.nextLine();
                    System.out.println("Please enter the phone number of the customer: ");
                    String phone = scanner.nextLine();
                    Customer myCustomer = new Customer (name, address, phone, null);
                    dealership.customers.add(myCustomer);
                    myCustomer.printCustomerInfo();
                    break;

                case 11 :
                    System.out.println("Please enter the vin number of the vehicle you would like to sell: ");
                    String vinSell = scanner.nextLine();
                    System.out.println("Please enter the phone number of the customer: ");
                    String phoneSell = scanner.nextLine();
                    Customer customerSell = null;
                    for (int i = 0; i < dealership.customers.size(); i++) {
                        if (dealership.customers.get(i).getPhone().equalsIgnoreCase(phoneSell)) {
                            customerSell = dealership.customers.get(i);
                        }
                    }
                    Vehicle vehicleSell = null;
                    for (int i = 0; i < carLot.size(); i++) {
                        if (carLot.get(i).getVin().equalsIgnoreCase(vinSell)) {
                            vehicleSell = carLot.get(i);
                        }
                    }
                    dealership.sellVehicle(vehicleSell, dealership, customerSell);
                    break;

                case 12 :
                    System.out.println("You are now exiting your dealership application.  Thank you.");
                    runAgain = "no";
                    break;

                default :
                    System.out.println("Please enter a valid selection.");
            };

        }

    }

}
