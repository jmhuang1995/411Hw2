package com.example.justin_huanghw2.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student {
    private String mFirstName;
    private String mLastname;
    private int mCWID;
    private ArrayList<Enroll_Course> mCourses;

    public Student(String mFirstName, String mLastname, int mCWID){
        this.mFirstName = mFirstName;
        this.mLastname = mLastname;
        this.mCWID = mCWID;
    }

    public String getFirstName(){return mFirstName;}
    public void setFirstName(String firstName){mFirstName = firstName;}

    public String getLastName(){return mLastname;}
    public void setLastName(String lastName){mLastname = lastName;}

    public int getCWID(){return mCWID;}
    public void setCWID(int CWID){mCWID = CWID;}

    public void setCourses(ArrayList<Enroll_Course> courses){mCourses = courses;}
    public ArrayList<Enroll_Course> getmCourses(){return mCourses;}

}
