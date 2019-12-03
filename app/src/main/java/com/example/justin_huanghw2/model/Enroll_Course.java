package com.example.justin_huanghw2.model;

public class Enroll_Course {
    private String mCourseID;
    private String mGrade;

    public Enroll_Course(String CourseID, String Grade){
        mCourseID = CourseID;
        mGrade = Grade;
    }

    public String getCourseID(){return mCourseID;}
    public void setCourseID(String CourseID){mCourseID = CourseID;}

    public String getGrade(){return  mGrade;}
    public void setGrade(String Grade){mGrade = Grade;}
}

