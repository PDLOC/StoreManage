/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.NhanVien;
import Helper.XDate;
import Helper.XJdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO {

    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (Manv, tennv, Gioitinh, Email, SoDienThoai, Luong, DiaChi, Vaitro, Hinh, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.isGioiTinh(),
                model.getEmail(),
                model.getSDT(),
                model.getLuong(),
                model.getDiaChi(),
                model.isVaiTro(),
                model.getHinh(),
                model.getMatKhau());
    }

    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET tennv=?, GioiTinh=?, Email=?, SoDienThoai=?, Luong=?, DiaChi=?, Vaitro=?, Hinh=?, password=? WHERE Manv=?";
        XJdbc.executeUpdate(sql,
                model.getTenNV(),
                model.isGioiTinh(),
                model.getEmail(),
                model.getSDT(),
                model.getLuong(),
                model.getDiaChi(),
                model.isVaiTro(),
                model.getHinh(),
                model.getMatKhau(),
                model.getMaNV());
    }

    public void delete(String manv) {
        String sql = "DELETE FROM NhanVien WHERE Manv=?";
        XJdbc.executeUpdate(sql, manv);
    }

    public NhanVien selectById(String manv) {
        String sql = "select * from nhanvien where manv = ?";
        List<NhanVien> list = this.select(sql, manv);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE Manv=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE Manv LIKE ? OR TenNV LIKE ? OR Sodienthoai LIKE ? order by Convert( int,Substring(manv,Patindex('%[0-9]%',manv),len(manv)))";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("Manv"));
        model.setTenNV(rs.getString("Tennv"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setEmail(rs.getString("Email"));
        model.setSDT(rs.getString("SoDienThoai"));
        model.setLuong(rs.getDouble("Luong"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setHinh(rs.getString("Hinh"));
        model.setMatKhau(rs.getString("Password"));
        model.setCode(rs.getString("code"));
        return model;
    }

    public void updateCode(String code, String manv) {
        String sql = "UPDATE NHANVIEN SET CODE = ? WHERE MANV LIKE ?";
        XJdbc.executeUpdate(sql, code, manv);
    }

    public void resetPassword(String pass, String MaNV) {
        String sql = "UPDATE NHANVIEN SET PASSWORD = ? WHERE MANV LIKE ?";
        XJdbc.executeUpdate(sql, pass, MaNV);
    }
}
