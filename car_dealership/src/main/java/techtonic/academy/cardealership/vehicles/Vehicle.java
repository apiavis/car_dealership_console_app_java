package techtonic.academy.cardealership.vehicles;

import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.time.*;
import java.time.LocalDate;

public class Vehicle {

    private final Vehicle maintenanceAndInsurance = null;
    String type, vin, make, model, color, servicedDateInString, insuredDateInString;
    int year, mileage, fuel, description;
    BigDecimal price, costToDealership;
    boolean clean;
    LocalDate lastServiced, lastInsured;

    public Vehicle(JsonObject order) {
        this.type = order.get("type").getAsString();
        this.vin = order.get("vin").getAsString();
        this.make = order.get("make").getAsString();
        this.model = order.get("model").getAsString();
        this.color = order.get("color").getAsString();
        this.year = order.get("year").getAsInt();
        this.mileage = order.get("mileage").getAsInt();
        this.fuel = order.get("fuel").getAsInt();
        this.description = order.get("description").getAsInt();
        this.price = order.get("price").getAsBigDecimal();
        this.costToDealership = order.get("costToDealership").getAsBigDecimal();
        this.clean = order.get("clean").getAsBoolean();
        String servicedDateInString = order.get("maintenanceAndInsurance").getAsJsonObject().get("lastServiced").getAsString();
        Instant servicedInstant = Instant.parse(servicedDateInString);
        LocalDateTime servicedResult = LocalDateTime.ofInstant(servicedInstant, ZoneId.of(ZoneOffset.UTC.getId()));
        this.lastServiced = servicedResult.toLocalDate();
        String insuredDateInString = order.get("maintenanceAndInsurance").getAsJsonObject().get("lastInsured").getAsString();
        Instant insuredInstant = Instant.parse(insuredDateInString);
        LocalDateTime insuredResult = LocalDateTime.ofInstant(insuredInstant, ZoneId.of(ZoneOffset.UTC.getId()));
        this.lastInsured = insuredResult.toLocalDate();
    }

    public String getType() {
        return type;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() { return make; }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getFuel() {
        return fuel;
    }

    public int getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCostToDealership() {
        return costToDealership;
    }

    public boolean getClean() {
        return clean;
    }

    public LocalDate getLastServiced() { return lastServiced; }

    public LocalDate getLastInsured() { return lastInsured; }

    public void setType(String type) {
        this.type = type;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setServicedDateInString(String servicedDateInString) {
        this.servicedDateInString = servicedDateInString;
    }

    public void setInsuredDateInString(String insuredDateInString) {
        this.insuredDateInString = insuredDateInString;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCostToDealership(BigDecimal costToDealership) {
        this.costToDealership = costToDealership;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void setLastServiced(LocalDate lastServiced) {
        this.lastServiced = lastServiced;
    }

    public void setLastInsured(LocalDate lastInsured) {
        this.lastInsured = lastInsured;
    }
}
