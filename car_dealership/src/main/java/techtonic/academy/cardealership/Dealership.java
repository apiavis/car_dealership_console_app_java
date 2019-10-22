package techtonic.academy.cardealership;

import techtonic.academy.cardealership.sales.Customer;
import techtonic.academy.cardealership.sales.Receipt;
import techtonic.academy.cardealership.vehicles.*;


import java.util.Collections;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Dealership {

    String name;
    BigDecimal balance;
    ArrayList<Vehicle> carLot = new ArrayList<>();
    ArrayList<Receipt> salesHistory = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    public Dealership(String name, BigDecimal startingBalance) {
        this.name = name;
        this.balance = startingBalance;
    }

    ArrayList purchaseVehicles(Factory factory, Dealership dealership) {
        System.out.println("----------------------------");
        System.out.println(" Add Vehicles to the Lot ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Old dealership balance: \t" + dealership.getBalance());

        Vehicle[] vehicleArr = factory.readyToShip;
        ArrayList<String> vehicleModels = new ArrayList<>();
        if (dealership.carLot.size() == 0) {
            dealership.carLot.add(vehicleArr[0]);
            vehicleModels.add(vehicleArr[0].getModel());
            for (int i = 1; i < vehicleArr.length; i++) {
                String currentModel = vehicleArr[i].getModel();
                if (Collections.frequency(vehicleModels, currentModel) < 2) {
                    dealership.carLot.add(vehicleArr[i]);
                    BigDecimal costOfVehicle = vehicleArr[i].getCostToDealership();
                    BigDecimal newBalance = dealership.getBalance().subtract(costOfVehicle);
                    dealership.setBalance(newBalance);
                }
                vehicleModels.add(vehicleArr[i].getModel());
            }
        } else {
            for (int i = 0; i < vehicleArr.length; i++) {
                String currentModel = vehicleArr[i].getModel();
                if (Collections.frequency(vehicleModels, currentModel) < 2) {
                    dealership.carLot.add(vehicleArr[i]);
                    BigDecimal costOfVehicle = vehicleArr[i].getCostToDealership();
                    BigDecimal newBalance = dealership.getBalance().subtract(costOfVehicle);
                    dealership.setBalance(newBalance);
                }
                vehicleModels.add(vehicleArr[i].getModel());
            }
        }
        System.out.println("New dealership balance: \t" + dealership.getBalance());
        System.out.println("");
        System.out.println(dealership.carLot.size() + " new vehicles have been added to the car lot.");
        System.out.println("");
        return dealership.carLot;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public ArrayList<Vehicle> getCarLot() {
        return carLot;
    }

    public ArrayList<Receipt> getSalesHistory() {
        return salesHistory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCarLot(ArrayList<Vehicle> carLot) {
        this.carLot = carLot;
    }

    public void setSalesHistory(ArrayList<Receipt> salesHistory) {
        this.salesHistory = salesHistory;
    }

    public void printDealershipInfo() {
        System.out.println("----------------------------");
        System.out.println(" Dealership Info ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Name: \t" + this.getName());
        System.out.println("Balance: \t" + this.getBalance());
        System.out.println("Car Lot: \t" + this.getCarLot().size() + " vehicles");
//        System.out.println("Sales History: \t" + this.getSalesHistory);
        System.out.println("");
    }

    public boolean checkInsurance(Vehicle vehicle, Dealership dealership) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------------------------");
        System.out.println(" Check Insurance ");
        System.out.println("----------------------------");
        System.out.println("");
        LocalDate today = LocalDate.now();
        LocalDate expirationDate = today.minusDays(30);
        if(vehicle.getLastInsured().isBefore(expirationDate)) {
            System.out.println("Vehicle needs insurance renewal.");
            System.out.println("");
            renewInsurance(vehicle, dealership);
            return false;
        }
        System.out.println("Vehicle insurance is up to date.");
        System.out.println("");
        return true;
    }

    public boolean renewInsurance(Vehicle vehicle, Dealership dealership) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------------------------");
        System.out.println(" Renew Insurance ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Old lastInsured date: \t" + vehicle.getLastInsured());
        LocalDate today = LocalDate.now();
        vehicle.setLastInsured(today);
        System.out.println("New lastInsured date: \t" + vehicle.getLastInsured());
        System.out.println("Old dealership balance: \t" + dealership.getBalance());
        BigDecimal randomNum = new BigDecimal(getRandomSmall());
        System.out.println("Cost of renewal: \t" + randomNum);
        BigDecimal newBalance = dealership.getBalance().subtract(randomNum);
        dealership.setBalance(newBalance);
        System.out.println("New dealership balance: \t" + dealership.getBalance());
        System.out.println("Old cost to dealership: \t" + vehicle.getCostToDealership());
        BigDecimal newCostToDealership = vehicle.getCostToDealership().add(randomNum);
        vehicle.setCostToDealership(newCostToDealership);
        System.out.println("New cost to dealership: \t" + vehicle.getCostToDealership());
        System.out.println("");
        return true;
    }

    public double getRandomSmall() {
        Random random = new Random();
        double randomNumber = (double) random.nextInt(300 + 1 - 100) + 100;
        return randomNumber;
    }

    public boolean checkMaintenance(Vehicle vehicle, Dealership dealership) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------------------------");
        System.out.println(" Check Maintenance ");
        System.out.println("----------------------------");
        System.out.println("");
        LocalDate today = LocalDate.now();
        LocalDate expirationDate = today.minusDays(90);
        if(vehicle.getLastServiced().isBefore(expirationDate)) {
            System.out.println("Vehicle needs maintenance.");
            System.out.println("");
            serviceVehicle(vehicle, dealership);
            return false;
        }
        System.out.println("Vehicle maintenance is up to date.");
        System.out.println("");
        return true;
    }

    public boolean serviceVehicle(Vehicle vehicle, Dealership dealership) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------------------------");
        System.out.println(" Service Vehicle ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Old lastServiced date: \t" + vehicle.getLastServiced());
        LocalDate today = LocalDate.now();
        vehicle.setLastServiced(today);
        System.out.println("New lastServiced date: \t" + vehicle.getLastServiced());
        System.out.println("Old dealership balance: \t" + dealership.getBalance());
        BigDecimal randomNum = new BigDecimal(getRandomLarge());
        System.out.println("Cost of service: \t" + randomNum);
        BigDecimal newBalance = dealership.getBalance().subtract(randomNum);
        dealership.setBalance(newBalance);
        System.out.println("New dealership balance: \t" + dealership.getBalance());
        System.out.println("Old cost to dealership: \t" + vehicle.getCostToDealership());
        BigDecimal newCostToDealership = vehicle.getCostToDealership().add(randomNum);
        vehicle.setCostToDealership(newCostToDealership);
        System.out.println("New cost to dealership: \t" + vehicle.getCostToDealership());
        System.out.println("");
        return true;
    }

    public double getRandomLarge() {
        Random random = new Random();
        double randomNumber = (double) random.nextInt(2000 + 1 - 100) + 100;
        return randomNumber;
    }

    public void refuelVehicle(Vehicle vehicle) {
        System.out.println("----------------------------");
        System.out.println(" Refuel Vehicle ");
        System.out.println("----------------------------");
        System.out.println("");
        switch(vehicle.getType())
        {
            case "car" :
                Car myCar = (Car) vehicle;
                int fuelCar = myCar.getFuel();
                int fuelCapacityCar = myCar.getFuelCapacity();
                System.out.println("Fuel before refill: \t" + fuelCar);
                myCar.setFuel(fuelCapacityCar);
                System.out.println("Fuel after refill: \t" + myCar.getFuel());
                break;

            case "ev" :
                Ev myEv = (Ev) vehicle;
                int fuelEv = myEv.getFuel();
                int fuelCapacityEv = myEv.getFuelCapacity();
                System.out.println("Fuel before refill: \t" + fuelEv);
                myEv.setFuel(fuelCapacityEv);
                System.out.println("Fuel after refill: \t" + myEv.getFuel());
                break;

            case "motorcycle" :
                Motorcycle myMotorcycle = (Motorcycle) vehicle;
                int fuelMotorcycle = myMotorcycle.getFuel();
                int fuelCapacityMotorcycle = myMotorcycle.getFuelCapacity();
                System.out.println("Fuel before refill: \t" + fuelMotorcycle);
                myMotorcycle.setFuel(fuelCapacityMotorcycle);
                System.out.println("Fuel after refill: \t" + myMotorcycle.getFuel());
                break;

            case "truck" :
                Truck myTruck = (Truck) vehicle;
                int fuelTruck = myTruck.getFuel();
                int fuelCapacityTruck = myTruck.getFuelCapacity();
                System.out.println("Fuel before refill: \t" + fuelTruck);
                myTruck.setFuel(fuelCapacityTruck);
                System.out.println("Fuel after refill: \t" + myTruck.getFuel());
                break;

            default :
                System.out.println("Vehicle is not of a valid type.");
        };
        System.out.println("");
        return;
    }

    public void washVehicle(Vehicle vehicle, Dealership dealership) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------------------------");
        System.out.println(" Wash Vehicle ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Vehicle Before Cleaned: \t" + vehicle.getClean());
        vehicle.setClean(true);
        System.out.println("Vehicle After Cleaned: \t" + vehicle.getClean());
        System.out.println("Old dealership balance: \t" + dealership.getBalance());
        BigDecimal newBalance = dealership.getBalance().subtract(new BigDecimal(10));
        dealership.setBalance(newBalance);
        System.out.println("New dealership balance: \t" + dealership.getBalance());
        System.out.println("Old cost to dealership: \t" + vehicle.getCostToDealership());
        BigDecimal newCostToDealership = vehicle.getCostToDealership().add(new BigDecimal(10));
        vehicle.setCostToDealership(newCostToDealership);
        System.out.println("New cost to dealership: \t" + vehicle.getCostToDealership());
        System.out.println("");
        return;
    }

    public void testDriveVehicle(Vehicle vehicle, Dealership dealership) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("----------------------------");
        System.out.println(" Test Drive  Vehicle ");
        System.out.println("----------------------------");
        System.out.println("");
        checkInsurance(vehicle, dealership);
        checkMaintenance(vehicle, dealership);
        refuelVehicle(vehicle);
        System.out.println("Test drive completed.");
        System.out.println("");
        return;
    }

    public void sellVehicle(Vehicle vehicle, Dealership dealership, Customer customer) throws NoSuchFieldException, IllegalAccessException {
        // TODO: add logic for selling vehicle
        if (vehicle.getClean() == false) {
            this.washVehicle(vehicle, dealership);
        }
        BigDecimal price = vehicle.getPrice();
        BigDecimal newBalance = dealership.getBalance().add(price);
        System.out.println("Old dealership balance: \t" + dealership.getBalance());
        dealership.setBalance(newBalance);
        System.out.println("New dealership balance: \t" + dealership.getBalance());
        customer.setVehicle(vehicle);
        Receipt newReceipt = new Receipt(vehicle, customer);
        newReceipt.printReceiptInfo();
        dealership.salesHistory.add(newReceipt);
        String vin = vehicle.getVin();
        for (int i = 0; i < dealership.carLot.size(); i++) {
            if (dealership.carLot.get(i).getVin() == vin) {
                dealership.carLot.remove(i);
            }
        }
        return;
    }

}