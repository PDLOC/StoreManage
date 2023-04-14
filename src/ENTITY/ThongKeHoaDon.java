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
public class ThongKeHoaDon {
    private int mahd;
    private int masp;
    private int soluong;
    private long tongtien;

    public ThongKeHoaDon() {
    }

    public ThongKeHoaDon(int mahd, int masp, int soluong, long tongtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    
    
    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
