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
import com.app1.app.GettersandSetters.GetSet_MasonryWorkers;

public class AddMasonryWorkers extends AppCompatActivity {

    Button AddMasonryWorker;
    EditText textMFirstName;
    EditText textMLastName;
    EditText textMNIC;
    EditText textMPhone;
    EditText textMAssignedSiteNumber;
    EditText textMWorkerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_masonry_workers);

        textMFirstName = (EditText) findViewById(R.id.editM_1stN);
        textMLastName = (EditText) findViewById(R.id.editM_LN);
        textMNIC = (EditText) findViewById(R.id.editM_NIC);
        textMPhone = (EditText) findViewById(R.id.editM_PhnNum);
        textMAssignedSiteNumber = (EditText) findViewById(R.id.editM_Assigned_SiteID);
        textMWorkerID = (EditText) findViewById(R.id.editM_WorkerID);
        AddMasonryWorker = (Button) findViewById(R.id.btnM_Add_Masonry_worker);

        AddMasonryWorker.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String M_first_name = textMFirstName.getText().toString();
                String M_last_name = textMLastName.getText().toString();
                String M_NIC = textMNIC.getText().toString();
                String M_phone_number = textMPhone.getText().toString();
                String M_assigned_site_number = textMAssignedSiteNumber.getText().toString();
                String M_workerID = textMWorkerID.getText().toString();

                if (TextUtils.isEmpty(M_first_name)) {
                    textMFirstName.setError("Please enter first name");
                } else if (TextUtils.isEmpty(M_last_name)) {
                    textMLastName.setError("Please enter last name");
                } else if (TextUtils.isEmpty(M_NIC)) {
                    textMNIC.setError("Please enter NIC");
                } else if (TextUtils.isEmpty(M_phone_number)) {
                    textMPhone.setError("Please enter phone number");
                } else if (TextUtils.isEmpty(M_assigned_site_number)) {
                    textMAssignedSiteNumber.setError("Please enter assigned site number");
                } else if (TextUtils.isEmpty(M_workerID)) {
                    textMWorkerID.setError("Please enter workerID");
                } else {

                    GetSet_MasonryWorkers getSet_masonryWorkers = new GetSet_MasonryWorkers();


                    getSet_masonryWorkers.setMasonryWorker_firstname(M_first_name);
                    getSet_masonryWorkers.setMasonryWorker_lastname(M_last_name);
                    getSet_masonryWorkers.setMasonryWorker_NIC(M_NIC);
                    getSet_masonryWorkers.setMasonryWorker_phone(M_phone_number);
                    getSet_masonryWorkers.setMasonryWorker_assigned_site_number(M_assigned_site_number);
                    getSet_masonryWorkers.setMasonryWorker_workerID(M_workerID);

                    DataBase dbConnector = new DataBase(AddMasonryWorkers.this);
                    dbConnector.addMasonryWorker(getSet_masonryWorkers);

                    Intent intent = new Intent(AddMasonryWorkers.this, ManageMasonryWorkers.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Masonry worker added successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

}