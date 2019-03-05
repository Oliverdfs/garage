package se.lexicon.garage;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnection {

    public static ArrayList<Vehicle> getVehiclesDB() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;


        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "enable");

            System.out.println("Connected to sakila database!");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Vehicle");
            while (rs.next()) {

                if (rs.getString("type").equals("Car")) {

//                    System.out.println(rs.getString("make"));

                    Car temp = new Car(rs.getString("make"));

                    vehicles.add(temp);

                }

            }
        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (rs != null) rs.close();

            if (stmt != null) stmt.close();

            if (conn != null) conn.close();

        }
        return vehicles;

    }


    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "enable");
            System.out.println("Connected to sakila database");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery("SELECT * FROM vehicle");


            rs = stmt.executeQuery("SELECT * FROM sakila.city LIMIT 10");

            while (rs.next()) {
                if (rs.getString("type").equals("Car")) {
                    Car temp = new Car(rs.getString("make"));
                    vehicles.add(temp);
                }

                System.out.println(rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("  *****  \n**     **\n*  0 0  *\n*       *\n*   4   *\n*       *\n* *   * *\n*  ***  *\n**     **\n  *****  ");

            rs.beforeFirst();

            while (rs.next()) {
                if (rs.getString("city").equals("Acua")) {
                    rs.updateString("city", "Aqua");
                    rs.updateRow();
                    System.out.println(rs.getString("city"));
                } else {
                    System.out.println(rs.getString("city"));
                }
            }
            rs.beforeFirst();

            //while(rs.next()){
            //    if(rs.getRow() == 7){
            //        rs.deleteRow();
            //        rs.updateRow();
            //    }
            // }

        } //catch (SQLException e) {
        //   e.printStackTrace();
        // }
        finally {
            if (rs != null) rs.close();
            if (stmt != null) rs.close();
            if (conn != null) rs.close();
        }
    }



    public static void saveVehicleDB(Vehicle vehicle)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        String make = vehicle.getMake();
        int speed = 0;
        String type = "";
        int parkingLot = vehicle.getParkingLot();

        if(vehicle instanceof Car) {
            Car temp = (Car) vehicle;
            speed = temp.getTopSpeed();
            type = "Car";
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "enable");
            System.out.println("Connected to sakila database");

            pstmt = conn.prepareStatement("INSERT INTO vehicle (make, speed, type) VALUES( ?, ?, ?, ?)");


            pstmt.setString(1, make);
            pstmt.setInt(2, speed);
            pstmt.setString(3, type);
            pstmt.setInt(4, parkingLot);

            pstmt.executeUpdate();



        } catch (SQLException e) {e.printStackTrace();

        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }



   /* public static void saveVehicleDB(Vehicle vehicle) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean setEmpty = false;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "enable");
            System.out.println("Connected to sakila database");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stmt.executeQuery("SELECT * FROM vehicle");


            rs = stmt.executeQuery("SELECT * FROM sakila.city LIMIT 10");

            if (vehicle instanceof Car) {
                Car tempCar = (Car) vehicle;
                rs.afterLast();
                stmt.executeUpdate("Insert Into vehicle(make, speed, type) values(\'" + tempCar.getMake() + "\', \'"

                        + tempCar.getTopSpeed() + "\', \'car\')");


                *//*while(rs.next()){
                    if(rs.getString("type").equals("empty")){
                        rs = stmt.executeQuery("INSERT INTO vehicle(make, speed)" +
                                "VALUES('"+ tempcar.getMake()+", "+tempcar.getTopSpeed()+")");
                        rs.updateRow();
                        setEmpty = true;

                    }
                }*//*
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/
}


