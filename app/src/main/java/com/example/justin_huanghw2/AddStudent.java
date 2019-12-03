package com.example.justin_huanghw2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justin_huanghw2.model.Student;
import com.example.justin_huanghw2.model.Student_DB;

public class AddStudent extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndex;
    protected final String TAG = "Add Student Screen (AddStudent.java)";




    @Override
    protected void onCreate(Bundle savdInstance){
        Log.d(TAG, "onCreate() called");
        super.onCreate(savdInstance);
        setContentView(R.layout.activity_student_detail);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);

        EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
        EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
        EditText cwidView = (EditText) findViewById(R.id.cwid_val_id);

        fNameView.setEnabled(true);
        lNameView.setEnabled(true);
        cwidView.setEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student_screen_menu, menu);
        detailMenu = menu;
        menu.findItem(R.id.action_student_done).setVisible(true);
        menu.findItem(R.id.action_add_student).setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_student_edit) {
            EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
            EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
            EditText cwidView = (EditText) findViewById(R.id.cwid_val_id);
            fNameView.setEnabled(true);
            lNameView.setEnabled(true);
            cwidView.setEnabled(true);

            detailMenu.findItem(R.id.action_student_done).setVisible(true);
            detailMenu.findItem(R.id.action_add_student).setVisible(false);

        } else if (item.getItemId() == R.id.action_student_done) {
            EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
            EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
            EditText cwidView = (EditText) findViewById(R.id.cwid_val_id);

            Student sObj = new Student(fNameView.getText().toString(),lNameView.getText().toString(),
                    Integer.parseInt(cwidView.getText().toString()));

            Student_DB.getInstance().getStudents().add(sObj);

            fNameView.setEnabled(false);
            lNameView.setEnabled(false);
            cwidView.setEnabled(false);
            detailMenu.findItem(R.id.action_student_done).setVisible(false);
            detailMenu.findItem(R.id.action_add_student).setVisible(false);
        }else if (item.getItemId() == R.id.action_add_student) {
            Log.d(TAG, "Unintended \"Add Student\" button clicked on menu");
        }


        return super.onOptionsItemSelected(item);
    }

}
