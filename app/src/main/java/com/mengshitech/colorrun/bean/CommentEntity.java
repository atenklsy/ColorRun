package com.mengshitech.colorrun.bean;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/7/16 16:57.
 * E-address:atenk@qq.com.
 */
public class CommentEntity implements Serializable {

    private int ivUserHead;
    private String tvUserName;
    private String tvSendTime;
    private String tvCommentContent;

    public int getIvUserHead() {
        return ivUserHead;
    }

    public void setIvUserHead(int ivUserHead) {
        this.ivUserHead = ivUserHead;
    }

    public String getTvUserName() {
        return tvUserName;
    }

    public void setTvUserName(String tvUserName) {
        this.tvUserName = tvUserName;
    }

    public String getTvSendTime() {
        return tvSendTime;
    }

    public void setTvSendTime(String tvSendTime) {
        this.tvSendTime = tvSendTime;
    }

    public String getTvCommentContent() {
        return tvCommentContent;
    }

    public void setTvCommentContent(String tvCommentContent) {
        this.tvCommentContent = tvCommentContent;
    }
}
