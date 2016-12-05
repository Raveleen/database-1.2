package com.raveleen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseController {
    private static DataBaseController dataBaseControl;
    private String DB_CONNECTION;
    private String DB_USER;
    private String DB_PASSWORD;
    private Connection conn;

    static {
        dataBaseControl = new DataBaseController();
    }

    private DataBaseController() {
        DB_CONNECTION = "jdbc:mysql://localhost:3306/database1";
        DB_USER = "root";
        DB_PASSWORD = "1604";
        dbInit();
    }

    public static DataBaseController getInstance() {
        return dataBaseControl;
    }

    private void dbInit() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Apartments (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "rooms TINYINT, area SMALLINT, district VARCHAR(16) NOT NULL , " +
                    "address VARCHAR(20) NOT NULL, price MEDIUMINT)");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DATABASE IS WORKING WRONG.");
        }
    }

    public List<Apartment> getAll() {
        List<Apartment> arrayList = new ArrayList<Apartment>();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT *FROM Apartments");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                arrayList.add(new Apartment(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6)));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        System.out.println(arrayList.toString());
        return arrayList;
    }

    public void addToBase(int rooms, int area, String district, String address, int price) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Apartments " +
                    "(rooms, area, district, address, price) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, rooms);
            preparedStatement.setInt(2, area);
            preparedStatement.setString(3, district);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, price);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
