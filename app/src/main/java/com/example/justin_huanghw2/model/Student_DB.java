package com.example.justin_huanghw2.model;

import java.util.ArrayList;

public class Student_DB {
    private static final Student_DB ourInstance = new Student_DB();

    private ArrayList<Student> mStudents;

    public static Student_DB getInstance() {return ourInstance;}

    private Student_DB(){createStudentObjects();}

    public ArrayList<Student> getStudents(){return mStudents;}

    public void setStudents(ArrayList<Student> students){mStudents = students;}

    private void createStudentObjects(){

        Student studetObject;
        ArrayList<Enroll_Course> courses = new ArrayList<Enroll_Course>();
        mStudents = new ArrayList<Student>();

        studetObject  = new Student("Justin", "Huang", 105678455);
        courses.add(new Enroll_Course("CPSC 411", "B+"));
        courses.add(new Enroll_Course("CPSC 349", "C"));
        studetObject.setCourses(courses);

        mStudents.add(studetObject);


        studetObject  = new Student("John", "Doe", 456789123);
        courses = new ArrayList<Enroll_Course>();
        courses.add(new Enroll_Course("CPSC 411", "D"));
        courses.add(new Enroll_Course("CPSC 481", "C-"));
        studetObject.setCourses(courses);
        
        mStudents.add(studetObject);

        studetObject  = new Student("Liz", "Doe", 1234856789);
        courses = new ArrayList<Enroll_Course>();
        courses.add(new Enroll_Course("CPSC 440", "A"));
        courses.add(new Enroll_Course("CPSC 411", "B"));
        studetObject.setCourses(courses);

        mStudents.add(studetObject);
    }
}
