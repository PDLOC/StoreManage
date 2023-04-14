/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.KhachHang;
import Helper.XDate;
import Helper.XJdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {

    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaKH, TenKH, GioiTinh, SoDienThoai, DiaChi, NgayDauTien) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaKh(),
                model.getTenKh(),
                model.isGioiTinh(),
                model.getSdt(),
                model.getDiaChi(),
                XDate.toString(model.getNgayTG()));//, "yyyy-MM-dd")
    }

    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET TenKH=?, GioiTinh=?, SoDienThoai=?, DiaChi=?, NgayDauTien=? WHERE MaKH=?";
        XJdbc.executeUpdate(sql,
                model.getTenKh(),
                model.isGioiTinh(),
                model.getSdt(),
                model.getDiaChi(),
                XDate.toString(model.getNgayTG()),//, "yyyy-MM-dd")
                model.getMaKh());
    }

    public void delete(String makh) {
        String sql = "DELETE FROM KhachHang WHERE MaKH=?";
        XJdbc.executeUpdate(sql, makh);
    }

    public List<KhachHang> select(){
        String sql="SELECT * FROM KhachHang";
        return select(sql);
    }
    public KhachHang findById(String makh) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<KhachHang> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH LIKE ? OR TenKH LIKE ? OR SoDienThoai LIKE ? order by Convert(int,Substring(makh,Patindex('%[0-9]%',makh),len(makh)))";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
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

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKh(rs.getString("MaKH"));
        model.setTenKh(rs.getString("TenKH"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setSdt(rs.getString("SoDienThoai"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setNgayTG(rs.getDate("NgayDauTien"));
        return model;
    }
}
