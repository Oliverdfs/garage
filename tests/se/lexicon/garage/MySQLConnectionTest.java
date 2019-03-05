package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MySQLConnectionTest {

    @Test
    void getVehiclesDB() {
    }

    @Test
    void main() {
    }

    @Test
    void saveVehicleDB() throws SQLException {
        Car testCar =new Car("Mikebitzu", 250);
        MySQLConnection.saveVehicleDB(testCar);
        ArrayList<Vehicle> testVehicles = MySQLConnection.getVehiclesDB();
        assertEquals(testCar.getMake(), testVehicles.get(testVehicles.size()-1).getMake());
    }
}