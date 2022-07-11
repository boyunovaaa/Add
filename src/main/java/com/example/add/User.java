package com.example.add;

public class User {
    private int id;
    private String login;
    private String password;
    private String group;
    private String newPass;
    private int status;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, String group, int status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.group = group;
        this.status = status;
    }

    public User(String login, String password, String newPass){
        this.login = login;
        this.password = password;
        this.newPass = newPass;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public int getStatus() {
        return status;
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
