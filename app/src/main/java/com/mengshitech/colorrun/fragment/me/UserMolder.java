package com.mengshitech.colorrun.fragment.me;

import java.io.Serializable;

/**
 * Created by kanghuicong on 2016/7/20  14:08.
 * 515849594@qq.com
 */
public class UserMolder implements Serializable {

    private byte[] image;

    private String userid;
    private String nickname;
    private String userpwd;
    private String sex;
    private String email;
    private String address;
    private String phone;
    private String autograph;

    public UserMolder(String userid,String nickname,String userpwd,String sex,String email,
                      String address,String phone,String autograph,byte[] image){
        this.address = address;
        this.autograph = autograph;
        this.email = email;
        this.image = image;
        this.phone = phone;
        this.sex = sex;
        this.userid = userid;
        this.nickname = nickname;
        this.userpwd = userpwd;
    }

    public void UserMolder(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
