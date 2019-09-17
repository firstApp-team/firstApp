package com.springboot.model;

/**
 * Created by duyuqiang on 2019/9/4.
 */
public class User {

    private int id;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    private int fid;
    private String name;

    public User(int Id,int fid,String name){
        super();
        this.id = Id;
        this.fid = fid;
        this.name = name;
    }

    public User(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "User [id="+id+",name="+name+"]";
    }
}
