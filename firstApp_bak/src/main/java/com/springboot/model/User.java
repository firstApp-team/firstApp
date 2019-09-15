package com.springboot.model;

/**
 * Created by duyuqiang on 2019/9/4.
 */
public class User {

    private int id;
    private String name;

    public User(int Id,String name){
        super();
        this.id = Id;
        this.name = name;
    }

    public User(){
        super();
    }

    public int getUserid() {
        return id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public void setUserid(int userid) {
        this.id = userid;
    }

    @Override
    public String toString(){
        return "User [id="+id+",name="+name+"]";
    }
}
