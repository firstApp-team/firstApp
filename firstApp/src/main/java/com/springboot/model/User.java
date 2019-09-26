package com.springboot.model;

import java.util.UUID;

/**
 * Created by duyuqiang on 2019/9/4.
 */
public class User {

    private String uid;
    private String password;
    private String fid;
    private String name;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public User(String uid,String fid,String name){
        super();
        this.uid = uid;
        this.fid = fid;
        this.name = name;
    }

    public User(){
        super();
    }

    public String getId() {
        return uid;
    }

    public void setId() {
        this.uid = UUID.randomUUID().toString().replaceAll("-","");
    }

    public void setId(String id) {
        this.uid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "User [id="+uid+",name="+name+"]";
    }
}
