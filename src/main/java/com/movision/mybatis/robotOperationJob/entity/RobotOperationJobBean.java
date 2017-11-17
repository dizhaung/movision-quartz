package com.movision.mybatis.robotOperationJob.entity;

import java.util.Date;

public class RobotOperationJobBean {
    private Integer id;

    private Integer userid;

    private Integer postid;

    private Integer type;

    private Integer status;

    private Integer count;

    private Date intime;

    private Date endtime;

    private Integer batch;

    private Integer number;

    private Integer theme;

    private Integer commentType;

    /**
     * 是否立即执行（0：否， 1：是）
     */
    private Integer immediate;

    public void setImmediate(Integer immediate) {
        this.immediate = immediate;
    }

    public Integer getImmediate() {

        return immediate;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getCommentType() {

        return commentType;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public Integer getTheme() {

        return theme;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {

        return number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }
}