package techtonic.academy.cardealership.vehicles;

import com.google.gson.JsonObject;

public class Ev extends Vehicle {

    private int mpc = 200;
    private int fuelCapacity = 100;
    private int wheels = 4;

    public Ev(JsonObject order)
    {
        super(order);
    }

    public int getMpc() {
        return mpc;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getWheels() {
        return wheels;
    }

}

