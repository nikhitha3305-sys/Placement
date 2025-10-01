package creational;

/*
 * Factory Method Pattern demonstration.
 * Use case: VehicleFactory creates different types of vehicles (Car and Bike) without exposing instantiation logic.
 * Factory pattern defines an interface for creating an object but lets subclasses decide which class to instantiate.
 */

abstract class Vehicle {
    abstract void drive();
}

class Car extends Vehicle {
    @Override
    void drive() {
        System.out.println("Driving a car");
    }
}

class Bike extends Vehicle {
    @Override
    void drive() {
        System.out.println("Riding a bike");
    }
}

class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if(type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if(type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.getVehicle("Car");
        v1.drive();

        Vehicle v2 = VehicleFactory.getVehicle("Bike");
        v2.drive();
    }
}
