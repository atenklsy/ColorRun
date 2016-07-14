package com.mengshitech.colorrun.bean;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/7/14 10:49.
 * E-address:atenk@qq.com.
 */
public class ShowEntity implements Serializable {
    private int ivUserHead;
    private String tvShow_UserName;
    private int ivShowPic;
    private String tvWordContent;
    private String tvSendTime;
    private String tvShow_Heart;
    private String tvShow_Comment;
    private String tvShow_Share;

    public int getIvUserHead() {
        return ivUserHead;
    }

    public void setIvUserHead(int ivUserHead) {
        this.ivUserHead = ivUserHead;
    }

    public String getTvShow_UserName() {
        return tvShow_UserName;
    }

    public void setTvShow_UserName(String tvShow_UserName) {
        this.tvShow_UserName = tvShow_UserName;
    }

    public int getIvShowPic() {
        return ivShowPic;
    }

    public void setIvShowPic(int ivShowPic) {
        this.ivShowPic = ivShowPic;
    }

    public String getTvWordContent() {
        return tvWordContent;
    }

    public void setTvWordContent(String tvWordContent) {
        this.tvWordContent = tvWordContent;
    }

    public String getTvSendTime() {
        return tvSendTime;
    }

    public void setTvSendTime(String tvSendTime) {
        this.tvSendTime = tvSendTime;
    }

    public String getTvShow_Heart() {
        return tvShow_Heart;
    }

    public void setTvShow_Heart(String tvShow_Heart) {
        this.tvShow_Heart = tvShow_Heart;
    }

    public String getTvShow_Comment() {
        return tvShow_Comment;
    }

    public void setTvShow_Comment(String tvShow_Comment) {
        this.tvShow_Comment = tvShow_Comment;
    }

    public String getTvShow_Share() {
        return tvShow_Share;
    }

    public void setTvShow_Share(String tvShow_Share) {
        this.tvShow_Share = tvShow_Share;
    }
}
