package techtonic.academy.cardealership.sales;

import techtonic.academy.cardealership.vehicles.Vehicle;

public class Receipt {
    private Vehicle vehicle;
    private Customer customer;

    public Receipt (Vehicle vehicle, Customer customer) {
        this.vehicle = vehicle;
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void printReceiptInfo() {
        System.out.println("----------------------------");
        System.out.println(" Receipt Info ");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.println("Vehicle Make: \t" + this.getVehicle().getMake());
        System.out.println("Vehicle Model: \t" + this.getVehicle().getModel());
        System.out.println("Vehicle Year: \t" + this.getVehicle().getYear());
        System.out.println("Vehicle Vin: \t" + this.getVehicle().getVin());
        System.out.println("Vehicle Price: \t" + this.getVehicle().getPrice());
        System.out.println("Customer Name: \t" + this.getCustomer().getName());
        System.out.println("Customer Phone: \t" + this.getCustomer().getPhone());
        System.out.println("Customer Address: \t" + this.getCustomer().getAddress());
        System.out.println("");
    }

}
