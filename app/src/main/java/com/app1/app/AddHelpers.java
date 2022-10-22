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
import com.app1.app.GettersandSetters.GetSet_Helpers;

public class AddHelpers extends AppCompatActivity {

    Button AddHelper;
    EditText textHFirstName;
    EditText textHLastName;
    EditText textHNIC;
    EditText textHPhone;
    EditText textHAssignedSiteNumber;
    EditText textHWorkerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_helpers);

        textHFirstName = (EditText) findViewById(R.id.editH_1stN);
        textHLastName = (EditText) findViewById(R.id.editH_LN);
        textHNIC = (EditText) findViewById(R.id.editH_NIC);
        textHPhone = (EditText) findViewById(R.id.editH_PhnNum);
        textHAssignedSiteNumber = (EditText) findViewById(R.id.editH_Assigned_SiteID);
        textHWorkerID = (EditText) findViewById(R.id.editH_WorkerID);
        AddHelper = (Button) findViewById(R.id.btnH_Add_Masonry_worker);

        AddHelper.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String H_first_name = textHFirstName.getText().toString();
                String H_last_name = textHLastName.getText().toString();
                String H_NIC = textHNIC.getText().toString();
                String H_phone_number = textHPhone.getText().toString();
                String H_assigned_site_number = textHAssignedSiteNumber.getText().toString();
                String H_workerID = textHWorkerID.getText().toString();

                if (TextUtils.isEmpty(H_first_name)) {
                    textHFirstName.setError("Please enter first name");
                } else if (TextUtils.isEmpty(H_last_name)) {
                    textHLastName.setError("Please enter last name");
                } else if (TextUtils.isEmpty(H_NIC)) {
                    textHNIC.setError("Please enter NIC");
                } else if (TextUtils.isEmpty(H_phone_number)) {
                    textHPhone.setError("Please enter phone number");
                } else if (TextUtils.isEmpty(H_assigned_site_number)) {
                    textHAssignedSiteNumber.setError("Please enter assigned site number");
                } else if (TextUtils.isEmpty(H_workerID)) {
                    textHWorkerID.setError("Please enter workerID");
                } else {

                    GetSet_Helpers getSet_helpers = new GetSet_Helpers();


                    getSet_helpers.setHelper_firstname(H_first_name);
                    getSet_helpers.setHelper_lastname(H_last_name);
                    getSet_helpers.setHelper_NIC(H_NIC);
                    getSet_helpers.setHelper_phone(H_phone_number);
                    getSet_helpers.setHelper_assigned_site_number(H_assigned_site_number);
                    getSet_helpers.setHelper_workerID(H_workerID);

                    DataBase dbConnector = new DataBase(AddHelpers.this);
                    dbConnector.addHelper(getSet_helpers);

                    Intent intent = new Intent(AddHelpers.this, ManageHelpers.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Helper added successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}