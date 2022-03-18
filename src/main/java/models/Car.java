package models;

public class Car {

    String address;
    String make;
    String model;
    String year;
    String engine;

    String fuel;
    String gear;
    String WD;

    String doors;
    String seats;
    String clasS;
    String fuelConsumption;
    String carRegNumber;
    String price;
    String distanceIncluded;
    String typeFeature;
    String about;

    public Car withTypeFeature(String typeFeature) {
        this.typeFeature = typeFeature;
        return this;

    }

    public Car withAbout(String about) {
        this.about = about;
        return this;
    }

    public String getTypeFeature() {
        return typeFeature;
    }

    public String getAbout() {
        return about;
    }

    public Car withAddress(String location) {
        this.address = location;
        return this;
    }

    public Car withMake(String make) {
        this.make = make;
        return this;
    }

    public Car withModel(String model) {
        this.model = model;
        return this;
    }

    public Car withYear(String year) {
        this.year = year;
        return this;
    }

    public Car withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car withFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car withGear(String gear) {
        this.gear = gear;
        return this;
    }

    public Car withWD(String wd) {
        this.WD = wd;
        return this;
    }

    public Car withDoors(String doors) {
        this.doors = doors;
        return this;
    }



    public Car withSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car withClasS(String carClass) {
        this.clasS = carClass;
        return this;
    }

    public Car withFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car withCarRegNumber(String carRegNum) {
        this.carRegNumber = carRegNum;
        return this;
    }

    public Car withPrice(String price) {
        this.price = price;
        return this;
    }

    public Car withDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel() {
        return fuel;
    }

    public String getGear() {
        return gear;
    }

    public String getWD() {
        return WD;
    }

    public String getDoors() {
        return doors;
    }

    public String getSeats() {
        return seats;
    }

    public String getClasS() {
        return clasS;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getDistanceIncluded() {
        return distanceIncluded;
    }


}
