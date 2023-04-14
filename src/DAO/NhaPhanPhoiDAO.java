/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.NhaPhanPhoi;
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
public class NhaPhanPhoiDAO {

    public void insert(NhaPhanPhoi model) {
        String sql = "INSERT INTO NhaPhanPhoi (MaNPP, TenNPP, NoiSX, Hinh) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNPP(),
                model.getTenNPP(),
                model.getNoiSX(),
                model.getHinh());
    }

    public void update(NhaPhanPhoi model) {
        String sql = "UPDATE NhaPhanPhoi SET TenNPP=?, NoiSX=?, Hinh=? WHERE MaNPP=?";
        XJdbc.executeUpdate(sql,
                model.getTenNPP(),
                model.getNoiSX(),
                model.getHinh(),
                model.getMaNPP());
    }

    public void delete(String manpp) {
        String sql = "DELETE FROM NhaPhanPhoi WHERE MaNPP=?";
        XJdbc.executeUpdate(sql, manpp);
    }

    public List<NhaPhanPhoi> select() {
        String sql = "SELECT * FROM NhaPhanPhoi";
        return select(sql);
    }

    public NhaPhanPhoi findById(String manpp) {
        String sql = "SELECT * FROM NhaPhanPhoi WHERE MaNPP=?";
        List<NhaPhanPhoi> list = select(sql, manpp);
        return list.size() > 0 ? list.get(0) : null;
    }

    public NhaPhanPhoi findByName(String tennpp) {
        String sql = "SELECT * FROM NhaPhanPhoi WHERE TenNPP=?";
        List<NhaPhanPhoi> list = select(sql, tennpp);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhaPhanPhoi> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhaPhanPhoi WHERE MaNPP LIKE ? OR TenNPP LIKE ? OR Noisx LIKE ?";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    private List<NhaPhanPhoi> select(String sql, Object... args) {
        List<NhaPhanPhoi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhaPhanPhoi model = readFromResultSet(rs);
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

    private NhaPhanPhoi readFromResultSet(ResultSet rs) throws SQLException {
        NhaPhanPhoi model = new NhaPhanPhoi();
        model.setMaNPP(rs.getString("MaNPP"));
        model.setTenNPP(rs.getString("TenNPP"));
        model.setNoiSX(rs.getString("NoiSX"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}
