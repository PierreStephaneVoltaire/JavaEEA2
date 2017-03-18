/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author steph
 */
import Model.Car;
import java.sql.*;
import java.util.ArrayList;

public class CarDB {

    public static int addCar(Car c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection myConn = null;
        PreparedStatement ps = null;
        ConControl connManager;

        connManager = new ConControl();
        myConn = connManager.connection();

        try {

            String pstm = "INSERT INTO cars(make,model,debut,carengine,price,color,registration,fuel)"
                    + " VALUES(?, ?, ?,?,?,?,?,?)";

            ps = myConn.prepareStatement(pstm);

            ps.setString(1, c.getMake());
            ps.setString(2, c.getModel());
            ps.setInt(3, c.getDebut());
            ps.setString(4, c.getCarEngine());
            ps.setDouble(5, c.getPrice());
            ps.setString(6, c.getColor());
            ps.setString(7, c.getRegiistration());
            ps.setString(8, c.getFuel());

            return ps.executeUpdate();
        } catch (SQLException e) {

            return 0;
        } finally {
            DBUtils.closePreparedStatement(ps);
            connManager.endConnection(myConn);
        }
    }

    public static int updateCar(Car c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection myConn = null;
        PreparedStatement ps = null;
        ConControl connManager;

        connManager = new ConControl();
        myConn = connManager.connection();

        try {

            String pstm = "update cars set make=?,model=?,debut=?,carengine=?,price=?,color=?,registration=?,fuel=? where id = " + c.getId();

            ps = myConn.prepareStatement(pstm);

            ps.setString(1, c.getMake());
            ps.setString(2, c.getModel());
            ps.setInt(3, c.getDebut());
            ps.setString(4, c.getCarEngine());
            ps.setDouble(5, c.getPrice());
            ps.setString(6, c.getColor());
            ps.setString(7, c.getRegiistration());
            ps.setString(8, c.getFuel());

            return ps.executeUpdate();
        } catch (SQLException e) {

            return 0;
        } finally {
            DBUtils.closePreparedStatement(ps);
            connManager.endConnection(myConn);
        }
    }
  public static Car retreiveCar(int c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException,Exception {
    Statement myStm = null;
        Connection myConn;
        ConControl connManager;
        ResultSet res = null;
        String stm = null;
        int debut = 0;
          String carEngine = null;
        double price = 0;

        String color = null;
        String regiistration = null;
        String fuel = null;
        int id = 0;
        String make;
        String model;
         connManager = new ConControl();
        myConn = connManager.connection();
            Car car = null;
          try {
                stm = "SELECT * FROM cars where id = "+c;
 myStm = myConn.createStatement();
            res = myStm.executeQuery(stm);
        
            while (res.next()) {
                debut = 0;
                carEngine = res.getString("carengine");
                price = res.getDouble("price");
                color = res.getString("color");
                regiistration = res.getString("registration");
                fuel = res.getString("fuel");
                id = res.getInt("id");
                make = res.getString("make");
                model = res.getString("model");
                debut = res.getInt("debut");
                 car=new Car(id, make, model, debut, carEngine, price, color, regiistration, fuel);
            }
            return car;

            
  
  } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            DBUtils.closeStatement(myStm);
            DBUtils.closeResultSet(res);
            connManager.endConnection(myConn);
        }}
    
    
    public static ArrayList<Car> searchCar(Car c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
       String colorS=c.getColor();
        String makeS=c.getMake();
        int yearS=c.getDebut();
        String fuelS=c.getFuel();
        Statement myStm = null;
        Connection myConn;
        ConControl connManager;
        ResultSet res = null;
        String stm = null;
        int debut = 0;
        String carEngine = null;
        double price = 0;
        String color = null;
        String regiistration = null;
        String fuel = null;
        int id = 0;
        String make;
        String model;
        ArrayList<Car> car = new ArrayList();
        connManager = new ConControl();
        myConn = connManager.connection();
        try {
            if (colorS.equals("") && makeS.equals("")&& yearS == 0 && fuelS.equals("")) {

                stm = "SELECT * FROM cars";

            } else if (colorS.equals("") && makeS.equals("") && yearS == 0) {

                stm = "SELECT * FROM cars WHERE fuel LIKE '" + fuelS + "%'";

            } else if (fuelS.equals("") && makeS.equals("") && yearS == 0) {

                stm = "SELECT * FROM cars WHERE color LIKE '" + colorS + "%'";

            } else if (fuelS.equals("") && colorS.equals("")&& yearS == 0) {

                stm = "SELECT * FROM cars WHERE make LIKE '" + makeS + "%'";

            } else if (fuelS.equals("") && colorS.equals("") && makeS.equals("")) {

                stm = "SELECT * FROM cars WHERE debut = '" + yearS + "%'";

            } else if (makeS.equals("")&& yearS == 0) {

                stm = "SELECT * FROM cars WHERE fuel LIKE '" + fuelS + "%'" + " AND " + "color LIKE '" + colorS + "%'";

            } else if (fuelS.equals("") && yearS == 0) {

                stm = "SELECT * FROM cars WHERE make LIKE '" + makeS + "%'" + " AND " + "color LIKE '" + colorS + "%'";

            } else if (fuelS.equals("") && makeS.equals("")) {

                stm = "SELECT * FROM cars WHERE debut = '" + yearS + "%'" + " AND " + "color LIKE '" + colorS + "%'";

            } else if (colorS.equals("") && yearS == 0) {

                stm = "SELECT * FROM cars WHERE fuel LIKE '" + fuelS + "%'" + " AND " + "make LIKE '" + makeS + "%'";

            } else if (fuelS.equals("") && yearS == 0) {

                stm = "SELECT * FROM cars WHERE make LIKE '" + makeS + "%'" + " AND " + "color LIKE '" + colorS + "%'";

            } else if (fuelS.equals("")&& colorS.equals("")) {

                stm = "SELECT * FROM cars WHERE debut = '" + yearS + "%'" + " AND " + "make LIKE '" + makeS + "%'";

            } else if (colorS.equals("")) {

                stm = "SELECT * FROM cars WHERE fuel LIKE '" + fuelS + "%'" + " AND " + "make LIKE '" + makeS + "%'" + " AND " + "debut = '" + yearS + "%'";

            } else if (fuelS.equals("")) {

                stm = "SELECT * FROM cars WHERE make LIKE '" + makeS + "%'" + " AND " + "color LIKE '" + colorS + "%'" + " AND " + "debut = '" + yearS + "%'";

            } else if (makeS.equals("")) {

                stm = "SELECT * FROM cars WHERE debut = '" + yearS + "%'" + " AND " + "make LIKE '" + makeS + "%'" + " AND " + "fuel LIKE '" + fuelS + "%'";

            } else if (yearS == 0) {

                stm = "SELECT * FROM cars WHERE fuel LIKE '" + fuelS + "%'" + " AND " + "make LIKE '" + makeS + "%'" + " AND " + "color LIKE '" + colorS + "%'";

            } else {
                stm = "SELECT * FROM cars WHERE fuel LIKE '" + fuelS + "%'" + " AND " + "make LIKE '" + makeS + "%'" + " AND " + "color LIKE '" + colorS + "%'" + " AND " + "debut = '" + yearS + "%'";
            }

            myStm = myConn.createStatement();
            res = myStm.executeQuery(stm);
            while (res.next()) {
                carEngine = res.getString("carengine");
                price = res.getDouble("price");
                color = res.getString("color");
                regiistration = res.getString("registration");
                fuel = res.getString("fuel");
                id = res.getInt("id");
                make = res.getString("make");
                model = res.getString("model");
                debut = res.getInt("debut");
                car.add(new Car(id, make, model, debut, carEngine, price, color, regiistration, fuel));
            }

            return car;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            DBUtils.closeStatement(myStm);
            DBUtils.closeResultSet(res);
            connManager.endConnection(myConn);
        }

    }

    public static int deleteCar(int c) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection myConn = null;
        PreparedStatement ps = null;
        ConControl connManager;

        connManager = new ConControl();
        myConn = connManager.connection();

        try {

            String pstm = "delete from cars where id =?";

            ps = myConn.prepareStatement(pstm);

            ps.setInt(1, c);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            DBUtils.closePreparedStatement(ps);
            connManager.endConnection(myConn);
        }
    }

}
