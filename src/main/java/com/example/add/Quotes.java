package com.example.add;

public class Quotes {
    private String Text;
    private String Date;
    private String Subject;
    private String Teacher;

    public Quotes() {
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
}
