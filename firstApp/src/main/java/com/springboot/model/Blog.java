package com.springboot.model;

public class Blog {
    int bid;
    int id;
    String text;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    String bname;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    int rid;
    public Blog(int bid,int id,String text,String bname){
        super();
        this.bid = bid;
        this.id = id;
        this.text = text;
        this.bname = bname;
    }

    public Blog(){
        super();
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


}
