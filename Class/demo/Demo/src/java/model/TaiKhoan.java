/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NganNganchimte
 */
public class TaiKhoan implements Serializable{
    private String account;
    private String pass;
    private String fullName;
    private Date dob;
    private boolean gender;
    private String phone;
    private String addr;
    private String memo;

    public TaiKhoan(String account, String pass, String fullName, 
                    Date dob, boolean gender, String phone, 
                    String addr, String memo) {
        this.account = account;
        this.pass = pass;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.addr = addr;
        this.memo = memo;
    }
    public TaiKhoan(){
        this.account="";
        this.pass = "";
        this.fullName = "";
        this.dob = new Date(1900, 1, 1);
        this.phone = "";
        this.addr = "";
        this.memo = "";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    
}
