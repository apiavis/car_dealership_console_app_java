package techtonic.academy.cardealership.sales;

import techtonic.academy.cardealership.vehicles.Vehicle;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private Vehicle vehicle = null;

    public Customer (String name, String address, String phone, Vehicle vehicle) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicle = vehicle;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void printCustomerInfo() {
        System.out.println("----------------------------");
        System.out.println(" Customer Info ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Name: \t" + this.getName());
        System.out.println("Address: \t" + this.getAddress());
        System.out.println("Phone: \t" + this.getPhone());
        System.out.println("Vehicle: \t" + this.getVehicle());
        System.out.println("");
    }

}
