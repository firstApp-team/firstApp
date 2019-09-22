package com.springboot.model;

public class Blog {
    int bid;
    int id;
    String text;
    int rank;
    String bname;
    int rid;
    //判断登陆人与评论人是否一致
    int remark_status;

    public Blog(){
        super();
    }

    public Blog(int bid,int id,String text,String bname){
        super();
        this.bid = bid;
        this.id = id;
        this.text = text;
        this.bname = bname;
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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return id;
    }

    public void setUid(int id) {
        this.id = id;
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
