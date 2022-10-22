package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.app1.app.DB.DataBase;
import com.app1.app.GettersandSetters.GetSet_Attendance_H;
import com.app1.app.GettersandSetters.GetSet_Attendance_MW;

import java.util.Calendar;

public class MarkAttendanceOfHelpers extends AppCompatActivity {

    Button MarkAttendance_H;
    EditText textSelectDate_H;
    EditText textWorkerID_H;
    Spinner StatusOfAttendance_H;

    EditText etdDate2;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance_of_helpers);

        textSelectDate_H = (EditText) findViewById(R.id.et_date2);
        textWorkerID_H = (EditText) findViewById(R.id.editTextHWorkerID);
        StatusOfAttendance_H = (Spinner) findViewById(R.id.spinnerAH);
        MarkAttendance_H = (Button) findViewById(R.id.btnH_markAttendance);

        etdDate2 = findViewById(R.id.et_date2);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        MarkAttendance_H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String selectDate_H = textSelectDate_H.getText().toString();
                String workerID_H = textWorkerID_H.getText().toString();
                String statusOfAttendance_H = StatusOfAttendance_H.getSelectedItem().toString();

                if (TextUtils.isEmpty(selectDate_H)) {
                    textSelectDate_H.setError("Please select the date");
                } else if (TextUtils.isEmpty(workerID_H)) {
                    textWorkerID_H.setError("Please enter workerID");
                } else {

                    GetSet_Attendance_H getSet_attendance_h = new GetSet_Attendance_H();

                    getSet_attendance_h.setHAttendance_selectDate(selectDate_H);
                    getSet_attendance_h.setHAttendance_workerID(workerID_H);
                    getSet_attendance_h.setHAttendance_statusOfAttendance(statusOfAttendance_H);

                    DataBase dbConnector = new DataBase(MarkAttendanceOfHelpers.this);
                    dbConnector.markattendanceH(getSet_attendance_h);

                    Intent intent = new Intent(MarkAttendanceOfHelpers.this, MarkAttendance.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Attendance marked successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etdDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MarkAttendanceOfHelpers.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etdDate2.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerAH);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MarkAttendanceOfHelpers.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Attendance));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }
}