package com.mengshitech.colorrun.bean;

import java.io.Serializable;

public class LeRunEntity implements Serializable {

	private int LeRunBackgroundId;
	// 背景图片
	private String LeRunCity;
	// 活动城市
	private String LeRunTitle;
	// 活动主题
	private String LeRunStatus;
	// 活动状态
	private String LeRunLocation;
	// 活动时间
	private String LeRunTime;
	// 活动时间
	private String LeRunOther;

	// 活动备注
	public int getLeRunBackgroundId() {
		return LeRunBackgroundId;
	}

	public void setLeRunBackgroundId(int leRunBackgroundId) {
		LeRunBackgroundId = leRunBackgroundId;
	}

	public String getLeRunCity() {
		return LeRunCity;
	}

	public void setLeRunCity(String leRunCity) {
		LeRunCity = leRunCity;
	}

	public String getLeRunTitle() {
		return LeRunTitle;
	}

	public void setLeRunTitle(String leRunTitle) {
		LeRunTitle = leRunTitle;
	}

	public String getLeRunStatus() {
		return LeRunStatus;
	}

	public void setLeRunStatus(String leRunStatus) {
		LeRunStatus = leRunStatus;
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

	public String getLeRunOther() {
		return LeRunOther;
	}

	public void setLeRunOther(String leRunOther) {
		LeRunOther = leRunOther;
	}

}
