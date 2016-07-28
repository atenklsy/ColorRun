package com.mengshitech.colorrun.bean;

import java.io.Serializable;

/**
 * Created by kanghuicong on 2016/7/20  14:08.
 * 515849594@qq.com
 */
public class UserEntiy implements Serializable {

    private String user_id;
    private String user_name;
    private String user_pwd;
    private String user_birthday;
    private String user_sex;
    private String user_header;
    private String user_identity;
    private String user_address;
    private String user_bankid;
    private String user_fullname;
    private String user_level;
    private String user_health;
    private String user_height;
    private String user_weight;
    private String user_sign;
    private String user_phone;
    private String user_email;
    private String user_state;
    private String user_otherid;

    public UserEntiy(String user_bankid, String user_id, String user_pwd, String user_name, String user_birthday, String user_sex, String user_header, String user_identity, String user_address, String user_fullname, String user_level, String user_height, String user_health, String user_weight, String user_sign, String user_phone, String user_email, String user_state, String user_otherid) {
        this.user_bankid = user_bankid;
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_birthday = user_birthday;
        this.user_sex = user_sex;
        this.user_header = user_header;
        this.user_identity = user_identity;
        this.user_address = user_address;
        this.user_fullname = user_fullname;
        this.user_level = user_level;
        this.user_height = user_height;
        this.user_health = user_health;
        this.user_weight = user_weight;
        this.user_sign = user_sign;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_state = user_state;
        this.user_otherid = user_otherid;
    }

    public UserEntiy() {
    }

    public String getUser_sign() {
        return user_sign;
    }

    public void setUser_sign(String user_sign) {
        this.user_sign = user_sign;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_otherid() {
        return user_otherid;
    }

    public void setUser_otherid(String user_otherid) {
        this.user_otherid = user_otherid;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_weight() {
        return user_weight;
    }

    public void setUser_weight(String user_weight) {
        this.user_weight = user_weight;
    }

    public String getUser_health() {
        return user_health;
    }

    public void setUser_health(String user_health) {
        this.user_health = user_health;
    }

    public String getUser_height() {
        return user_height;
    }

    public void setUser_height(String user_height) {
        this.user_height = user_height;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getUser_bankid() {
        return user_bankid;
    }

    public void setUser_bankid(String user_bankid) {
        this.user_bankid = user_bankid;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_header() {
        return user_header;
    }

    public void setUser_header(String user_header) {
        this.user_header = user_header;
    }

    public String getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(String user_identity) {
        this.user_identity = user_identity;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
