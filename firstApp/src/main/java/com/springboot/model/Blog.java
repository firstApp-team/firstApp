package com.springboot.model;

import java.util.UUID;

//TODO id字段表意不清楚,所有主键都改为UUID类型
public class Blog {
    String bid;
    String uid;
    String text;
    int rank;
    String bname;
    String cid;
    //判断登陆人与评论人是否一致
    int remark_status;

    public Blog(){
        super();
    }

    public Blog(String bid,String uid,String text,String bname,String cid){
        super();
        this.bid = bid;
        this.uid = uid;
        this.text = text;
        this.bname = bname;
        this.cid = cid;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCid() {
        return cid;
    }

    public void setBid(String bid){
        this.bid = bid;
    }

    public void setCid() {
        this.cid = UUID.randomUUID().toString().replaceAll("-","");
    }

    public String getBid() {
        return bid;
    }

    public void setBid() {
        this.bid = UUID.randomUUID().toString().replaceAll("-","");
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRemark_status() {
        return remark_status;
    }

    public void setRemark_status(int remark_status) {
        this.remark_status = remark_status;
    }
}
