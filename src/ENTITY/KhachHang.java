/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String maKh;
    private String tenKh;
    private boolean GioiTinh;
    private String sdt;
    private String diaChi;
    private Date ngayTG;

    public KhachHang() {
    }

    public KhachHang(String maKh, String tenKh, boolean GioiTinh, String sdt, String diaChi, Date ngayTG) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.GioiTinh = GioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngayTG = ngayTG;
    }

    
    
//    @Override
//    public String toString() {
//        return this.tenKh;
//    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTG() {
        return ngayTG;
    }

    public void setNgayTG(Date ngayTG) {
        this.ngayTG = ngayTG;
    }

    
}
