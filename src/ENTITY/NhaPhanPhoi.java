/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Admin
 */
public class NhaPhanPhoi {

    private String MaNPP;
    private String TenNPP;
    private String NoiSX;
    private String Hinh;

    public NhaPhanPhoi() {
    }

    public NhaPhanPhoi(String MaNPP, String TenNPP, String NoiSX, String Hinh) {
        this.MaNPP = MaNPP;
        this.TenNPP = TenNPP;
        this.NoiSX = NoiSX;
        this.Hinh = Hinh;
    }
    
    @Override
    public String toString() {
        return this.MaNPP;
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

    public String getNoiSX() {
        return NoiSX;
    }

    public void setNoiSX(String NoiSX) {
        this.NoiSX = NoiSX;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
}
