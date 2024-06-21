/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;



/**
 *
 * @author NganNganchimte
 */
public class BanBe {
    private String soDT;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private int loaiQuanHe;
    private String ghiChu;

    public BanBe(String soDT, String hoTen, boolean gioiTinh, Date ngaySinh, String diaChi, int loaiQuanHe, String ghiChu) {
        this.soDT = soDT;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.loaiQuanHe = loaiQuanHe;
        this.ghiChu = ghiChu;
    }

    public BanBe() {
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getLoaiQuanHe() {
        return loaiQuanHe;
    }

    public void setLoaiQuanHe(int loaiQuanHe) {
        this.loaiQuanHe = loaiQuanHe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
