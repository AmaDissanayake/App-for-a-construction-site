package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Administrator_menu extends AppCompatActivity {

    Button logout_from_admin;
    Button btn_add_sites;
    Button btn_manage_supervisors;
    Button btn_manage_masonry_workers;
    Button btn_manage_helpers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_menu);

        logout_from_admin = (Button) findViewById(R.id.btn_logout_from_administrator);
        logout_from_admin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Administrator_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_add_sites = (Button) findViewById(R.id.btn_add_construction_sites);
        btn_add_sites.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            Intent intent = new Intent(Administrator_menu.this, add_construction_sites.class);
            startActivity(intent);
            }
        });

        btn_manage_supervisors = (Button) findViewById(R.id.btn_mng_super);
        btn_manage_supervisors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Administrator_menu.this, ManageSupervisors.class);
                startActivity(intent);
            }
        });

        btn_manage_masonry_workers = (Button) findViewById(R.id.btn_mng_masonry1);
        btn_manage_masonry_workers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Administrator_menu.this, ManageMasonryWorkers.class);
                startActivity(intent);
            }
        });

        btn_manage_helpers = (Button) findViewById(R.id.btn_mng_helpers1);
        btn_manage_helpers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Administrator_menu.this, ManageHelpers.class);
                startActivity(intent);

            }
        });
    }
}