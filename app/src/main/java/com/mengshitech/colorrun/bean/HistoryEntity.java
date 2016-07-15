package com.mengshitech.colorrun.bean;

import java.io.Serializable;
/**
 * atenklsy
 */
public class HistoryEntity implements Serializable {
	private int Imageid;
	private String ActivityTitle;
	private String ActivityTime;
	private String ActivityLoc;

	public int getImageid() {
		return Imageid;
	}

	public void setImageid(int imageid) {
		Imageid = imageid;
	}

	public String getActivityTitle() {
		return ActivityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		ActivityTitle = activityTitle;
	}

	public String getActivityTime() {
		return ActivityTime;
	}

	public void setActivityTime(String activityTime) {
		ActivityTime = activityTime;
	}

	public String getActivityLoc() {
		return ActivityLoc;
	}

	public void setActivityLoc(String activityLoc) {
		ActivityLoc = activityLoc;
	}

}
