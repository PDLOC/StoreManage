/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.ChiTietHoaDon;
import ENTITY.HoaDon;
import Helper.XDate;
import Helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hdct1DAO {

    public List<HoaDon> select() {
        String sql = "select*from HoaDon order by STTHD";
        return select(sql);
    }

    public List<HoaDon> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM HoaDon WHERE  mahd like ? or tenkh like ? or tennv like ? order by STTHD";
        
        return select(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMahd(rs.getString("MaHD"));
        model.setManv(rs.getString("MaNV"));
        model.setMakh(rs.getString("MaKH"));
        model.setTennv(rs.getString("tennv"));
        model.setTenkh(rs.getString("tenkh"));
        model.setThanhtien(rs.getLong("thanhtien"));
        model.setNgaymua(rs.getDate("Ngaytaodon"));
        return model;
    }
}
