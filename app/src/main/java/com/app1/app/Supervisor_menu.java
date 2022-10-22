package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Supervisor_menu extends AppCompatActivity {

    Button logout_from_supervisor;
    Button btn_manage_masonry_workers;
    Button btn_manage_helpers;
    Button btn_attendance;
    Button btn_salary_calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_menu);

        logout_from_supervisor = (Button) findViewById(R.id.btn_logout_from_supervisor);
        logout_from_supervisor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Supervisor_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_manage_masonry_workers = (Button) findViewById(R.id.btn_mng_masnory2);
        btn_manage_masonry_workers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Supervisor_menu.this, ManageMasonryWorkers.class);
                startActivity(intent);
            }
        });

        btn_manage_helpers = (Button) findViewById(R.id.btn_mng_helpers2);
        btn_manage_helpers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Supervisor_menu.this, ManageHelpers.class);
                startActivity(intent);
            }
        });

        btn_attendance = (Button) findViewById(R.id.btn_mark_attendance);
        btn_attendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Supervisor_menu.this, MarkAttendance.class);
                startActivity(intent);
            }
        });

        btn_salary_calculation = (Button) findViewById(R.id.btn_calc_salary);
        btn_salary_calculation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Supervisor_menu.this, Salary.class);
                startActivity(intent);
            }
        });
    }
}