package com.mengshitech.colorrun.bean;

import java.io.Serializable;
/**
 * atenklsy
 */
public class LeRunEntity implements Serializable {

    private int LeRunBackgroundId;
    // 背景图片
    private String LeRunName;
    // 活动主题
    private String LeRunLocation;
    // 活动地点
    private String LeRunTime;
    // 活动时间


    public int getLeRunBackgroundId() {
        return LeRunBackgroundId;
    }

    public void setLeRunBackgroundId(int leRunBackgroundId) {
        LeRunBackgroundId = leRunBackgroundId;
    }

    public String getLeRunName() {
        return LeRunName;
    }

    public void setLeRunName(String leRunName) {
        LeRunName = leRunName;
    }

    public String getLeRunLocation() {
        return LeRunLocation;
    }

    public void setLeRunLocation(String leRunLocation) {
        LeRunLocation = leRunLocation;
    }

    public String getLeRunTime() {
        return LeRunTime;
    }

    public void setLeRunTime(String leRunTime) {
        LeRunTime = leRunTime;
    }
}
