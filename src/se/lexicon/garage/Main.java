package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
       /* ArrayList<Vehicle> vehicles = MySQLConnection.getVehiclesDB();

                for(Vehicle vehicle : vehicles){
                    System.out.println(vehicle);
                }

    MySQLConnection.saveVehicleDB(new Car("Audi", 320));*/
      UserInterface ui = new UserInterface(new Garage());

      ui.parkVehicle();

       // Garage garage = new Garage();
      //  ArrayList<Vehicle> vehicles = MySQLConnection.getVehiclesDB();

     //   for(int i=0; i<5; i++) {
     //       garage.park(new Car("Volvo"));
     //   }

      //  System.out.println(garage.find(0));

      //  System.out.println(garage);

      //  garage.unpark(0);


    }
}
