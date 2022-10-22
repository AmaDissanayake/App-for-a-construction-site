package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageSupervisors extends AppCompatActivity {

    Button btn_add_supervisors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_supervisors);

        btn_add_supervisors = (Button) findViewById(R.id.btn_add_superV);
        btn_add_supervisors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ManageSupervisors.this, add_supervisors.class);
                startActivity(intent);

            }

        });
    }
}