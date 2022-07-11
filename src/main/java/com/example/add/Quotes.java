package com.example.add;

public class Quotes {
    private String id;
    private String Text;
    private String Date;
    private String Subject;
    private Integer UserId;
    private String Teacher;

    public Quotes(String id, String Text, String Date, String Subject, Integer UserId, String Teacher) {
        this.id = id;
        this.Text = Text;
        this.Date = Date;
        this.Subject = Subject;
        this.UserId = UserId;
        this.Teacher = Teacher;
    }

    public String getText(){
        return Text;
    }

    public void setText(String Text){
        this.Text = Text;
    }

    public String getDate(){
        return Date;
    }

    public void setDate(String Date){
        this.Date = Date;
    }

    public String getSubject(){
        return Subject;
    }

    public void setSubject(String Subject){
        this.Subject = Subject;
    }

    public String getTeacher(){
        return Teacher;
    }

    public void setTeacher(String Teacher){
        this.Teacher = Teacher;
    }

    public Integer getUserId(){
        return UserId;
    }

    public void setUserId(Integer UserId){
        this.UserId = UserId;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}
