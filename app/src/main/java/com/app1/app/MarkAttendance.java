package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MarkAttendance extends AppCompatActivity {

    Button mark_attendance_for_MW;
    Button mark_attendance_for_H;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);

        mark_attendance_for_MW = (Button) findViewById(R.id.btnA_MasonryWorkers);
        mark_attendance_for_MW.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MarkAttendance.this, MarkAttendanceOfMasonryW.class);
                startActivity(intent);
            }
        });

        mark_attendance_for_H = (Button) findViewById(R.id.btnA_Helpers);
        mark_attendance_for_H.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MarkAttendance.this, MarkAttendanceOfHelpers.class);
                startActivity(intent);
            }
        });
    }
}