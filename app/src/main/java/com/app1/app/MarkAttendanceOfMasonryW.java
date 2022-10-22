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
import com.app1.app.GettersandSetters.GetSet_Attendance_MW;
import com.app1.app.GettersandSetters.GetSet_Supervisors;

import java.util.Calendar;

public class MarkAttendanceOfMasonryW extends AppCompatActivity {

    Button MarkAttendance_MW;
    EditText textSelectDate_MW;
    EditText textWorkerID_MW;
    Spinner StatusOfAttendance_MW;

    EditText etdDate;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance_of_masonry_w);

        textSelectDate_MW = (EditText) findViewById(R.id.et_date);
        textWorkerID_MW = (EditText) findViewById(R.id.editTextTextWorkerID_MW);
        StatusOfAttendance_MW = (Spinner) findViewById(R.id.spinnerAMW);
        MarkAttendance_MW = (Button) findViewById(R.id.btnMW_markAttendance);

        etdDate = findViewById(R.id.et_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        MarkAttendance_MW.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     // TODO Auto-generated method stub

                                                     String selectDate_MW = textSelectDate_MW.getText().toString();
                                                     String workerID_MW = textWorkerID_MW.getText().toString();
                                                     String statusOfAttendance_MW = StatusOfAttendance_MW.getSelectedItem().toString();

                                                     if (TextUtils.isEmpty(selectDate_MW)) {
                                                         textSelectDate_MW.setError("Please select the date");
                                                     } else if (TextUtils.isEmpty(workerID_MW)) {
                                                         textWorkerID_MW.setError("Please enter workerID");
                                                     } else {

                                                         GetSet_Attendance_MW getSet_attendance_mw = new GetSet_Attendance_MW();

                                                         getSet_attendance_mw.setMWAttendance_selectDate(selectDate_MW);
                                                         getSet_attendance_mw.setMWAttendance_workerID(workerID_MW);
                                                         getSet_attendance_mw.setMWAttendance_statusOfAttendance(statusOfAttendance_MW);

                                                         DataBase dbConnector = new DataBase(MarkAttendanceOfMasonryW.this);
                                                         dbConnector.markattendanceMW(getSet_attendance_mw);

                                                         Intent intent = new Intent(MarkAttendanceOfMasonryW.this, MarkAttendance.class);
                                                         startActivity(intent);
                                                         Toast.makeText(getApplicationContext(), "Attendance marked successfully", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
                                             });
        etdDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MarkAttendanceOfMasonryW.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etdDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerAMW);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MarkAttendanceOfMasonryW.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Attendance));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }
}