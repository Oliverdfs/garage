package se.lexicon.garage;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Garage garage;

    private Scanner scanner = new Scanner(System.in);

    public UserInterface(Garage garage){
        this.garage = garage;

    }

    public void runMenu(){
        System.out.println("Hello World! Welcome to Glade Grannens Garage!");
    }

    public void parkVehicle()throws SQLException{
        System.out.println("Please specify vehicle type:");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("Car")) {
            parkCar();
        }
    }

    public void parkCar()throws SQLException {
        System.out.println("Please specify vehicle make:");
        String make = scanner.nextLine();
        System.out.println("Please specify vehicle maximum speed:");
        int topSpeed = scanner.nextInt();
        Car car = new Car(make, topSpeed);
        garage.park(car);
        System.out.println("Car is parked.");

        MySQLConnection.saveVehicleDB(car);

    }

    public void findVehicle(){

    }

    public void unparkVehicle(){

    }

    public void showAllVehiclesInGarage(){

    }

}
