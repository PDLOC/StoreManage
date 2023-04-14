/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String MaSP;
    private String TenSP;
    private String MaNPP;
    private String TenNPP;
    private int SoLuong;
    private long DonGia;
    private String Loai;
    private String MoTa;
    private String Hinh;
    private boolean TinhTrang;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String MaNPP, String TenNPP, int SoLuong, long DonGia, String Loai, String MoTa, String Hinh, boolean TinhTrang) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaNPP = MaNPP;
        this.TenNPP = TenNPP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.Loai = Loai;
        this.MoTa = MoTa;
        this.Hinh = Hinh;
        this.TinhTrang = TinhTrang;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMaNPP() {
        return MaNPP;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }

    public String getTenNPP() {
        return TenNPP;
    }

    public void setTenNPP(String TenNPP) {
        this.TenNPP = TenNPP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

}
