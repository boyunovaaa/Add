package com.example.add;

public class User {
    private String login;
    private String password;
    private String newPass;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public User(String login, String password, String newPass){
        this.login = login;
        this.password = password;
        this.newPass = newPass;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getNewPass(){
        return newPass;
    }
}
