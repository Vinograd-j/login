package me.vinograd.adlogin.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class database {
    String url = "jdbc:mysql://localhost:3306/vinocraft?autoReconnect=true";
    String username = "root";
    String passwords = "root";
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection(url, username, passwords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Statement statement;

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        try {
            statement.executeUpdate("CREATE TABLE `adminss` (`nickname` VARCHAR(15) NOT NULL COLLATE 'utf8_general_ci',`password` VARCHAR(8) NOT NULL COLLATE 'utf8_general_ci')COLLATE='utf8_general_ci' ENGINE=InnoDB;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void input(String sql1, String sql2) throws SQLException {
        statement = conn.createStatement();
//        String txt= "INSERT INTO players(nickname) VALUES('"+sql1 +"');";
//        String txt2 = "INSERT INTO players(password) VALUES('" +sql2+"');";
        try {
            statement.executeUpdate("INSERT INTO adminss(nickname,password) VALUES('" + sql1 + "','" + sql2 + "');");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void time(String admin, String what) throws SQLException {
        statement = conn.createStatement();
        String format = "dd.MM.yyyy HH:mm:ss";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            statement.executeUpdate("INSERT INTO adminlogs(admin,date) VALUES('" + what + "" + admin + "','" + dateFormat.format(date) + "');");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    PreparedStatement pst;

    public void remove(String name) throws SQLException {
        pst = conn.prepareStatement("DELETE FROM `adminss` WHERE `nickname` = ?");
        pst.setString(1,name);
        pst.executeUpdate();
        pst.close();
    }
}