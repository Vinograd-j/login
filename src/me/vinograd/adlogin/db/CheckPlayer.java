package me.vinograd.adlogin.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckPlayer extends database {
    PreparedStatement pst;
    public boolean check(String val, String val2) {
        try {
            pst = conn.prepareStatement("SELECT * FROM adminss WHERE `nickname` = ? AND `password` = ?;");
            pst.setString(1, val);
            pst.setString(2, val2);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int checkLevel(String name,String pass){
        int level = 1;
        try {
            pst = conn.prepareStatement("SELECT * FROM adminss WHERE `nickname`= ? AND `password` = ?;");
            pst.setString(1,name);
            pst.setString(2,pass);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               level = rs.getInt(3);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            pst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return level;
    }


    public boolean nameCheck(String val) {
        try {
            pst = conn.prepareStatement("SELECT * FROM adminss WHERE `nickname` = ?;");
            pst.setString(1,val);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}