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
public class lichHen {
    private String account;
    private String soDT;
    private Date khiNao;
    private String diaDiem;
    private int thoiGian;
    private int chiPhi;
    private String ghiChu;

    public lichHen(String account, String soDT, Date khiNao, String diaDiem, int thoiGian, int chiPhi, String ghiChu) {
        this.account = account;
        this.soDT = soDT;
        this.khiNao = khiNao;
        this.diaDiem = diaDiem;
        this.thoiGian = thoiGian;
        this.chiPhi = chiPhi;
        this.ghiChu = ghiChu;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public Date getKhiNao() {
        return khiNao;
    }

    public void setKhiNao(Date khiNao) {
        this.khiNao = khiNao;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(int chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
