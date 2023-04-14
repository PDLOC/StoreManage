/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

/**
 *
 * @author huyhoai
 */
public class ThongKe {
    private String MaHD;
    private String MaSP;
    private String tensp;
    private String tenkh;
    private String slkm;
    private String tennv;
    private String slnv;
    private int soluong;
    private long thanhtien;
    private String ngaytaodon;

    public ThongKe() {
    }

    public ThongKe(String MaSP, String tensp, int soluong, long thanhtien) {
        this.MaSP = MaSP;
        this.tensp = tensp;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public ThongKe(String tensp, int soluong) {
        this.tensp = tensp;
        this.soluong = soluong;
    }

    public ThongKe(String tenkh, String slkm) {
        this.tenkh = tenkh;
        this.slkm = slkm;
    }

    
    
    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSlkm() {
        return slkm;
    }

    public void setSlkm(String slkm) {
        this.slkm = slkm;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSlnv() {
        return slnv;
    }

    public void setSlnv(String slnv) {
        this.slnv = slnv;
    }

    
    
    

    
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getNgaytaodon() {
        return ngaytaodon;
    }

    public void setNgaytaodon(String ngaytaodon) {
        this.ngaytaodon = ngaytaodon;
    }
    
    
    
}
