package techtonic.academy.cardealership.vehicles;

import com.google.gson.JsonObject;

public class Motorcycle extends Vehicle {

    private int mpg = 60;
    private int fuelCapacity = 2;
    private int wheels = 2;

    public Motorcycle (JsonObject order)
    {
        super(order);
    }

    public int getMpg() {
        return mpg;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getWheels() {
        return wheels;
    }

}
