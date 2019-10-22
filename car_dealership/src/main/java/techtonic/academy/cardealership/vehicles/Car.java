package techtonic.academy.cardealership.vehicles;

import com.google.gson.JsonObject;

public class Car extends Vehicle {

    private int mpg = 20;
    private int fuelCapacity = 16;
    private int wheels = 4;

    public Car (JsonObject order)
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

