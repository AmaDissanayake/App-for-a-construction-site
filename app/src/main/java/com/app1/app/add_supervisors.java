package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app1.app.DB.DataBase;
import com.app1.app.GettersandSetters.GetSet_Supervisors;

public class add_supervisors extends AppCompatActivity {

    Button AddSupervisor;
    EditText textFirstName;
    EditText textLastName;
    EditText textNIC;
    EditText textPhone;
    EditText textUserID;
    EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supervisors);

        textFirstName = (EditText) findViewById(R.id.editFirst_name_superV);
        textLastName = (EditText) findViewById(R.id.editLast_name_superV);
        textNIC = (EditText) findViewById(R.id.editNIC_enter);
        textPhone = (EditText) findViewById(R.id.editPhone_num);
        textUserID = (EditText) findViewById(R.id.editUser_ID_enter);
        textPassword = (EditText) findViewById(R.id.editedit);
        AddSupervisor = (Button) findViewById(R.id.btn_add_supervisors);

        AddSupervisor.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String first_name = textFirstName.getText().toString();
                String last_name = textLastName.getText().toString();
                String NIC = textNIC.getText().toString();
                String phone_number = textPhone.getText().toString();
                String userID = textUserID.getText().toString();
                String passWord = textPassword.getText().toString();

                if (TextUtils.isEmpty(first_name)) {
                    textFirstName.setError("Please enter first name");
                } else if (TextUtils.isEmpty(last_name)) {
                    textLastName.setError("Please enter last name");
                } else if (TextUtils.isEmpty(NIC)) {
                    textNIC.setError("Please enter NIC");
                } else if (TextUtils.isEmpty(phone_number)) {
                    textPhone.setError("Please enter phone number");
                } else if (TextUtils.isEmpty(userID)) {
                    textUserID.setError("Please enter userID");
                } else if (TextUtils.isEmpty(passWord)) {
                    textPassword.setError("Enter password");
                } else {

                    GetSet_Supervisors getSet_supervisors = new GetSet_Supervisors();


                    getSet_supervisors.setSupervisor_firstname(first_name);
                    getSet_supervisors.setSupervisor_lastname(last_name);
                    getSet_supervisors.setSupervisor_NIC(NIC);
                    getSet_supervisors.setSupervisor_phone(phone_number);
                    getSet_supervisors.setSupervisor_userID(userID);
                    getSet_supervisors.setSupervisor_password(passWord);

                    DataBase dbConnector = new DataBase(add_supervisors.this);
                    dbConnector.addSupervisor(getSet_supervisors);

                    Intent intent = new Intent(add_supervisors.this, ManageSupervisors.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Supervisor added successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

}