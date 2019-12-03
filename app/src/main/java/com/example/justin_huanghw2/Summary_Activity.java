package com.example.justin_huanghw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justin_huanghw2.adapter.Adapter_Summary;


public class Summary_Activity extends AppCompatActivity {

    protected ListView studentSummaryView;
    protected final String TAG = "Summary Screen";
    protected Adapter_Summary ad;

    protected Menu detailMenu;


    @Override
    protected void onCreate(Bundle savedInstance){
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstance);

        setContentView(R.layout.student_summary_listview);

        studentSummaryView = findViewById(R.id.student_summary_listView_ID);
        ad = new Adapter_Summary();
        studentSummaryView.setAdapter(ad);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        ad.notifyDataSetChanged();
        super.onStart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student_screen_menu, menu);
        detailMenu = menu;
        menu.findItem(R.id.action_student_done).setVisible(false);
        menu.findItem(R.id.action_add_student).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_student_done) {
            Log.d(TAG, "Unintended \"done\" button clicked on menu");
        } else if (item.getItemId() == R.id.action_add_student) {
            Intent intent = new Intent(this, AddStudent.class);
            this.startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}

