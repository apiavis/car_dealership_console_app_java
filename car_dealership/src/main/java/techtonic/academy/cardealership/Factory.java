package techtonic.academy.cardealership;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import techtonic.academy.cardealership.vehicles.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

class Factory {

    static String jsonString;
    static Vehicle[] readyToShip = prepareForShipping();

    static String getJsonString() {

        String jsonString = null;
        ClassLoader loader = Factory.class.getClassLoader();
        URL url = loader.getResource("vehicleData.json");
        String pathString = Objects.requireNonNull(url).getPath();
        Path path = Paths.get(pathString);

        try {
            jsonString = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    static Vehicle[] manufacture(String json) {

        JsonArray orderArray = null;
        JsonObject orderObject = null;

        try {
            orderArray = JsonParser.parseString(json).getAsJsonArray();
        } catch (IllegalStateException e) {
            orderObject = JsonParser.parseString(json).getAsJsonObject();
        }

        if (orderArray != null) {
            return processOrders(orderArray);
        } else if (orderObject != null) {
            return new Vehicle[] {buildVehicle(orderObject)};
        } else {
            System.out.println("No orders found.");
            return null;
        }
    }

    private static Vehicle buildVehicle(JsonObject order) {

        String type = order.get("type").getAsString();
        String capitalizedType = type.substring(0, 1).toUpperCase() + type.substring(1);
        String className = "techtonic.academy.cardealership.vehicles." + capitalizedType;
        Class<?> c;
        Vehicle vehicle = null;

        try {

            c = Class.forName(className);

            Constructor constructor = c.getConstructor(JsonObject.class);

            vehicle = (Vehicle) constructor.newInstance(order);
            BigDecimal price = vehicle.getPrice();
            BigDecimal newCostToDealership = price.multiply(new BigDecimal(0.8));
            vehicle.setCostToDealership(newCostToDealership);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return vehicle;
    }

    private static Vehicle[] processOrders(JsonArray orderArray) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < orderArray.size(); i++) {

            JsonObject order = orderArray.get(i).getAsJsonObject();
            Vehicle vehicle = buildVehicle(order);

            vehicles.add(vehicle);
        }

        return vehicles.toArray(Vehicle[]::new);
    }

    static Vehicle[] prepareForShipping () {
        jsonString = getJsonString();
        return manufacture(jsonString);
    }

    public void printFactoryVehicles() {

        System.out.println("----------------------------");
        System.out.println(" Factory Vehicles ");
        System.out.println("----------------------------");
        System.out.println("");
        for (int i = 0; i < readyToShip.length; i++) {
            switch(readyToShip[i].getType())
            {
                case "car" :
                    Car myCar = (Car) readyToShip[i];
                    System.out.println("MPG: \t" + myCar.getMpg());
                    System.out.println("Fuel Capacity: \t" + myCar.getFuelCapacity());
                    System.out.println("Wheels: \t" + myCar.getWheels());
                    break;

                case "ev" :
                    Ev myEv = (Ev) readyToShip[i];
                    System.out.println("MPC: \t" + myEv.getMpc());
                    System.out.println("Fuel Capacity: \t" + myEv.getFuelCapacity());
                    System.out.println("Wheels: \t" + myEv.getWheels());
                    break;

                case "motorcycle" :
                    Motorcycle myMotorcycle = (Motorcycle) readyToShip[i];
                    System.out.println("MPG: \t" + myMotorcycle.getMpg());
                    System.out.println("Fuel Capacity: \t" + myMotorcycle.getFuelCapacity());
                    System.out.println("Wheels: \t" + myMotorcycle.getWheels());
                    break;

                case "truck" :
                    Truck myTruck = (Truck) readyToShip[i];
                    System.out.println("MPG: \t" + myTruck.getMpg());
                    System.out.println("Fuel Capacity: \t" + myTruck.getFuelCapacity());
                    System.out.println("Towing Capacity: \t" + myTruck.getTowingCapacity());
                    System.out.println("Wheels: \t" + myTruck.getWheels());
                    break;

                default :
                    System.out.println("Vehicle is not of a valid type.");
            };

            System.out.println("Type: \t" + readyToShip[i].getType());
            System.out.println("Vin: \t" + readyToShip[i].getVin());
            System.out.println("Make: \t" + readyToShip[i].getMake());
            System.out.println("Model: \t" + readyToShip[i].getModel());
            System.out.println("Color: \t" + readyToShip[i].getColor());
            System.out.println("Year: \t" + readyToShip[i].getYear());
            System.out.println("Mileage: \t" + readyToShip[i].getMileage());
            System.out.println("Fuel: \t" + readyToShip[i].getFuel());
            System.out.println("Description: \t" + readyToShip[i].getDescription());
            System.out.println("Price: \t$" + readyToShip[i].getPrice());
            System.out.println("Cost to dealership: \t$" + readyToShip[i].getCostToDealership());
            System.out.println("Clean: \t" + readyToShip[i].getClean());
            System.out.println("Last Serviced: \t" + readyToShip[i].getLastServiced());
            System.out.println("Last Insured: \t" + readyToShip[i].getLastInsured());
            System.out.println("");
        }
    }
}