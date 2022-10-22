package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app1.app.DB.DataBase;
import com.app1.app.GettersandSetters.GetSet_Supervisors;

public class Login extends AppCompatActivity {

    Button login;
    EditText uID, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.btn_login);
        uID = (EditText) findViewById(R.id.txt_id);
        pass = (EditText) findViewById(R.id.txt_pass);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String user_name = uID.getText().toString();
                String pass_word = pass.getText().toString();

                if (user_name.equals("admin") & pass_word.equals("admin")) {
                    Intent intent = new Intent(Login.this, Administrator_menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                } else if (user_name.equals("S01") & pass_word.equals("S01")) {
                    Intent intent = new Intent(Login.this, Supervisor_menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                }

                    else{
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
