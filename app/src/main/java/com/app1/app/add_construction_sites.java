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
import com.app1.app.GettersandSetters.GetSet_ConstructionSites;

public class add_construction_sites extends AppCompatActivity {

    Button AddConstructionSite;
    EditText textConstructionSite_ID;
    EditText textSiteLocation;
    EditText textNumberOfPerches;
    EditText textClientName;
    EditText textTimePeriod;
    EditText textAssigned_supervisor_userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_construction_sites);

        textConstructionSite_ID = (EditText) findViewById(R.id.editCon_Site_ID);
        textSiteLocation = (EditText) findViewById(R.id.editLocation);
        textNumberOfPerches = (EditText) findViewById(R.id.editNumber_of_perches);
        textClientName = (EditText) findViewById(R.id.editClient_name);
        textTimePeriod = (EditText) findViewById(R.id.editTime_period);
        textAssigned_supervisor_userID = (EditText) findViewById(R.id.editAssigned_supervisor);
        AddConstructionSite = (Button) findViewById(R.id.btn_add_construction_site);

        AddConstructionSite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String Site_ID = textConstructionSite_ID.getText().toString();
                String Site_Location = textSiteLocation.getText().toString();
                String Site_Perches = textNumberOfPerches.getText().toString();
                String Site_ClientName = textClientName.getText().toString();
                String Site_TimePeriod = textTimePeriod.getText().toString();
                String Site_SupervisorID = textAssigned_supervisor_userID.getText().toString();

                if (TextUtils.isEmpty(Site_ID)) {
                    textConstructionSite_ID.setError("Please enter the siteID");
                } else if (TextUtils.isEmpty(Site_Location)) {
                    textSiteLocation.setError("Please enter the site location");
                } else if (TextUtils.isEmpty(Site_Perches)) {
                    textNumberOfPerches.setError("Please enter the site perches");
                } else if (TextUtils.isEmpty(Site_ClientName)) {
                    textClientName.setError("Please enter the client name");
                } else if (TextUtils.isEmpty(Site_TimePeriod)) {
                    textTimePeriod.setError("Please enter the time period");
                } else if (TextUtils.isEmpty(Site_SupervisorID)) {
                    textAssigned_supervisor_userID.setError("Please enter the site supervisorID");
                } else {

                    GetSet_ConstructionSites getSet_constructionSites = new GetSet_ConstructionSites();


                    getSet_constructionSites.setConstructionSite_ID(Site_ID);
                    getSet_constructionSites.setConstructionSite_location(Site_Location);
                    getSet_constructionSites.setConstructionSite_perches(Site_Perches);
                    getSet_constructionSites.setConstructionSite_clientName(Site_ClientName);
                    getSet_constructionSites.setConstructionSite_timePeriod(Site_TimePeriod);
                    getSet_constructionSites.setConstructionSite_supervisorID(Site_SupervisorID);

                    DataBase dbConnector = new DataBase(add_construction_sites.this);
                    dbConnector.addConstructionSite(getSet_constructionSites);

                    Intent intent = new Intent(add_construction_sites.this, Administrator_menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Construction Site added successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}