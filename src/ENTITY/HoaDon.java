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
public class HoaDon {
    private String mahd;
    private String makh;
    private String manv;
   
        private String tennv;
        private String tenkh;
        private long thanhtien;
        private Date ngaymua;

    public HoaDon() {
    }

    public HoaDon(String mahd, String makh, String manv, String tennv, String tenkh, long thanhtien, Date ngaymua) {
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.tennv = tennv;
        this.tenkh = tenkh;
        this.thanhtien = thanhtien;
        this.ngaymua = ngaymua;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public long getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(long thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

 

   
}
