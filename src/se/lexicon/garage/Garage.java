package se.lexicon.garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Garage implements GarageInterface<Vehicle> {


    public static final int MAX_PARKING_LOT_NUMBER = 72 ;
    private ArrayList<Vehicle> vehicles = new ArrayList<>(72);
    private Map<Integer, Vehicle> vehicleWithLots =new HashMap<>(72);
    {
        for(int i=0; i<=72; i++){
            vehicles.add(new EmptyVehicle("empty"));
           // for (int i = vehicles.size(); i<72; i++);
            vehicleWithLots.put(i+1, new EmptyVehicle());
        }
    }
    public Garage() throws SQLException{
       //vehicles = MySQLConnection.getVehiclesDB();
        for(int i = 1; i<=72; i++) {
            vehicles.add(new EmptyVehicle());
        }
    }
    public int park(Vehicle vehicle){
        int lotNumber = -1;
        for(Vehicle v : vehicles) {
            if(v instanceof EmptyVehicle) {
                lotNumber = vehicles.indexOf(v);
                vehicles.remove(v);
                vehicles.add(lotNumber, vehicle);
                return vehicles.indexOf(vehicle);
            }
        }
        for(int i = 1; i<=72; i++)
            if(vehicleWithLots.get(i) instanceof EmptyVehicle){
                vehicleWithLots.put(i, vehicle);
                vehicle.setParkingLot(i);
                return i;
            }

        return lotNumber;
    }

    public Vehicle find(int parkingLot){
        Vehicle found = vehicleWithLots.get(parkingLot);
        return vehicles.get(parkingLot);
    }

    public Vehicle unpark(int parkingLot){
        Vehicle temp = vehicles.get(parkingLot);
        vehicles.remove(parkingLot);
        vehicles.add(parkingLot, new EmptyVehicle());

        vehicleWithLots.put(parkingLot, new EmptyVehicle());
        return temp;
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public Map<Integer, Vehicle> getVehicleWithLots() {
        return vehicleWithLots;
    }



    public String toString() {
        String output = "";
        for(Vehicle vehicle : vehicles){
            output += "Lot nr "+vehicles.indexOf(vehicle)+": "+vehicle + "\n";
        }

        output += "\nVehiclesWithLots:\n";
        for(int i = 1; i<=72; i++){
            output += "Lot nr " + i +" : " + vehicleWithLots.get(i)+"\n";
        }

        return output;
    }
}
