package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageMasonryWorkers extends AppCompatActivity {

    Button btn_add_masonry_workers1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_masonry_workers);

        btn_add_masonry_workers1 = (Button) findViewById(R.id.btn_add_ms_workers);
        btn_add_masonry_workers1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ManageMasonryWorkers.this, AddMasonryWorkers.class);
                startActivity(intent);

            }

        });
    }
}