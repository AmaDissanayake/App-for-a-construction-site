package com.app1.app;

import androidx.activity.result.contract.ActivityResultContracts;
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
import com.app1.app.GettersandSetters.GetSet_salary;

public class Salary extends AppCompatActivity {

    Button Calculate_the_salary;
    Button Save_the_record;
    EditText No_of_days;
    EditText Employee_salary;
    EditText textEnter_the_worker_ID;
    EditText textYear_and_month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);

        No_of_days = (EditText) findViewById(R.id.editnumOfDays_forsalary);
        Employee_salary = (EditText) findViewById(R.id.editsalaryamnt);
        textEnter_the_worker_ID = (EditText) findViewById(R.id.editWorkerID_forsalary);
        textYear_and_month = (EditText) findViewById(R.id.editYear_forsalary);
        Calculate_the_salary = (Button) findViewById(R.id.btnCalc);
        Save_the_record = (Button) findViewById(R.id.btnsaveSDetails);

        Save_the_record = (Button) findViewById(R.id.btnsaveSDetails);
        Save_the_record.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String no_of_days = No_of_days.getText().toString();
                String employee_salary = Employee_salary.getText().toString();
                String enter_the_workerID = textEnter_the_worker_ID.getText().toString();
                String year_and_month = textYear_and_month.getText().toString();

                if (TextUtils.isEmpty(no_of_days)) {
                    No_of_days.setError("Please enter the number of days");
                } else if (TextUtils.isEmpty(enter_the_workerID)) {
                    textEnter_the_worker_ID.setError("Please enter the workerID");
                } else if (TextUtils.isEmpty(year_and_month)) {
                    textYear_and_month.setError("Please enter the year and the month");
                } else {

                    GetSet_salary getSet_salary = new GetSet_salary();


                    getSet_salary.setSalary_No_of_days(no_of_days);
                    getSet_salary.setSalary_Employee_salary(employee_salary);
                    getSet_salary.setSalary_Enter_the_workerID(enter_the_workerID);
                    getSet_salary.setSalary_Year_and_month(year_and_month);

                    DataBase dbConnector = new DataBase(Salary.this);
                    dbConnector.addSalary(getSet_salary);

                    Intent intent = new Intent(Salary.this, Supervisor_menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Salary added successfully", Toast.LENGTH_SHORT).show();
                }
            }

        });

        Calculate_the_salary = findViewById(R.id.btnCalc);
        No_of_days = findViewById(R.id.editnumOfDays_forsalary);
        Employee_salary = findViewById(R.id.editsalaryamnt);

        Calculate_the_salary = (Button) findViewById(R.id.btnCalc);
        Calculate_the_salary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double a, b, c;
                a = Double.parseDouble(No_of_days.getText().toString());
                b = 3000;
                c = a * b;
                Employee_salary.setText(Double.toString(c));
            }
        });
    }
}