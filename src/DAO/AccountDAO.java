/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.RememberAccount;
import Helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    public static RememberAccount getRememberAccount() {
        String sql = "SELECT * FROM REMEMBERUSER WHERE ID=1";
        List<RememberAccount> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql);
            while (rs.next()) {
                RememberAccount acc = new RememberAccount();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                list.add(acc);
            }
            rs.getStatement().getConnection().close();
            return list.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateRememberAccount(String username, String password) {
        String sql = "UPDATE REMEMBERUSER SET USERNAME = ?, PASSWORD = ? WHERE ID=1";
        try {
            XJdbc.executeUpdate(sql, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
