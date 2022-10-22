package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageHelpers extends AppCompatActivity {

    Button btn_add_helpers1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_helpers);

        btn_add_helpers1 = (Button) findViewById(R.id.btn_add_helpers);
        btn_add_helpers1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ManageHelpers.this, AddHelpers.class);
                startActivity(intent);

            }

        });
    }
}