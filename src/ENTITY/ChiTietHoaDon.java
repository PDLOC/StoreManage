/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author Nguyen vu
 */
public class ChiTietHoaDon {

    private String MaHD;
     private String MaSP;
    private String TenSP;
    private int SoLuong;
    private long  tongtien;
     private Date ngayTG;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHD, String MaSP, String TenSP, int SoLuong, long tongtien, Date ngayTG) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.tongtien = tongtien;
        this.ngayTG = ngayTG;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
       return MaSP+"\n";
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
       return TenSP+"\n";
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgayTG() {
        return ngayTG;
    }

    public void setNgayTG(Date ngayTG) {
        this.ngayTG = ngayTG;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
