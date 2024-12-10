package com.backend;
public class Signup{
    public String username;
    public String password; 
    Signup(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getusername(){
        return username;
    }
    public String getpassword(){
        return password;
    }
}