package com.mengshitech.colorrun.bean;

import java.io.Serializable;

/**
 * Created by kanghuicong on 2016/7/22  20:43.
 * 515849594@qq.com
 */
public class OrderEntity implements Serializable {
    private String lerun_id;
    private String lerun_title;
    private String lerun_poster;
    private String lerun_type;
    private String lerun_state;
    private String lerun_time;
    private String lerun_address;

    public OrderEntity(String lerun_id, String lerun_title, String lerun_poster, String lerun_type, String lerun_time, String lerun_state,String lerun_address) {
        this.lerun_id = lerun_id;
        this.lerun_title = lerun_title;
        this.lerun_poster = lerun_poster;
        this.lerun_type = lerun_type;
        this.lerun_time = lerun_time;
        this.lerun_state = lerun_state;
        this.lerun_address = lerun_address;
    }

    public OrderEntity() {
        super();
    }

    public String getLerun_address() {
        return lerun_address;
    }

    public void setLerun_address(String lerun_address) {
        this.lerun_address = lerun_address;
    }



    public String getLerun_id() {
        return lerun_id;
    }

    public void setLerun_id(String lerun_id) {
        this.lerun_id = lerun_id;
    }

    public String getLerun_title() {
        return lerun_title;
    }

    public void setLerun_title(String lerun_title) {
        this.lerun_title = lerun_title;
    }

    public String getLerun_poster() {
        return lerun_poster;
    }

    public void setLerun_poster(String lerun_poster) {
        this.lerun_poster = lerun_poster;
    }

    public String getLerun_type() {
        return lerun_type;
    }

    public void setLerun_type(String lerun_type) {
        this.lerun_type = lerun_type;
    }

    public String getLerun_state() {
        return lerun_state;
    }

    public void setLerun_state(String lerun_state) {
        this.lerun_state = lerun_state;
    }

    public String getLerun_time() {
        return lerun_time;
    }

    public void setLerun_time(String lerun_time) {
        this.lerun_time = lerun_time;
    }
}
