package techtonic.academy.cardealership.vehicles;

import com.google.gson.JsonObject;

public class Truck extends Vehicle {

    private int mpg = 15;
    private int towingCapacity = 5000;
    private int fuelCapacity = 65;
    private int wheels = 4;

    public Truck (JsonObject order)
    {
        super(order);
    }

    public int getMpg() {
        return mpg;
    }

    public int getTowingCapacity() {
        return fuelCapacity;
    }

    public int getFuelCapacity() {
        return wheels;
    }

    public int getWheels() {
        return wheels;
    }

}
