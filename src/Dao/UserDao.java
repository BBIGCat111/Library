package Dao;

import Entity.User;
import Util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends DBConnect{


    public boolean login(User u){
        try {
            Connection conn = super.getConnection();
            String sql = "SELECT password,name FROM User WHERE user=?";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            rs = pst.executeQuery();
            if (rs.next()) {
                if (u.getPassword().equals(rs.getString("password"))){
                    u.setName(rs.getString("name"));
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
