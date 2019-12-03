package com.example.justin_huanghw2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.justin_huanghw2.R;
import com.example.justin_huanghw2.model.Student;
import com.example.justin_huanghw2.model.Student_DB;
import com.example.justin_huanghw2.Student_Activity;
import com.example.justin_huanghw2.model.Enroll_Course;


public class Course_Adapter extends BaseAdapter {

    private int studentIndex;

    public Course_Adapter(int studentIndex){this.studentIndex = studentIndex;}

    @Override
    public int getCount(){return Student_DB.getInstance().getStudents().get(studentIndex).getmCourses().size();}

    @Override
    public Object getItem(int i){return Student_DB.getInstance().getStudents().get(studentIndex).getmCourses().get(i);}

    @Override
    public long getItemId(int i){return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        View row_view;

        if (view == null) {
            // cnt++;
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.course_row, viewGroup, false);
        } else row_view = view;

        Enroll_Course p = Student_DB.getInstance().getStudents().get(studentIndex).getmCourses().get(i);

        TextView firstNameView = (TextView) row_view.findViewById(R.id.course_id);
        firstNameView.setText(p.getCourseID());
        TextView lastNameView = (TextView) row_view.findViewById(R.id.grade);
        lastNameView.setText(p.getGrade());

        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                        Intent intent = new Intent(view.getContext(), Student_Activity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;


    }
}