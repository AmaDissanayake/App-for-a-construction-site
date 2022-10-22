package com.app1.app.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app1.app.GettersandSetters.GetSet_Attendance_H;
import com.app1.app.GettersandSetters.GetSet_Attendance_MW;
import com.app1.app.GettersandSetters.GetSet_ConstructionSites;
import com.app1.app.GettersandSetters.GetSet_Helpers;
import com.app1.app.GettersandSetters.GetSet_MasonryWorkers;
import com.app1.app.GettersandSetters.GetSet_Supervisors;
import com.app1.app.GettersandSetters.GetSet_salary;

public class DataBase extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "WJcontractorsPVT";

    // Contacts table name
    private static final String SUPERVISORS_TABLE = "supervisors_table";
    private static final String MASONRY_WORKERS_TABLE = "masonry_workers_table";
    private static final String HELPERS_TABLE = "helpers_table";
    private static final String CONSTRUCTION_SITES_TABLE = "construction_sites_table";
    private static final String ATTENDANCE_TABLE_MW = "attendance_table_mw";
    private static final String ATTENDANCE_TABLE_H = "attendance_table_h";
    private static final String SALARY_TABLE = "salary_table";

    // Contacts Table Columns names - Supervisor
    private static final String Supervisor_NUMBER = "supervisor_number";
    private static final String Supervisor_FIRSTNAME = "supervisor_firstname";
    private static final String Supervisor_LASTNAME = "supervisor_lastname";
    private static final String Supervisor_NIC = "supervisor_NIC";
    private static final String Supervisor_PHONE_NUMBER = "supervisor_phone";
    private static final String Supervisor_USER_ID = "supervisor_userID";
    private static final String Supervisor_PASSWORD = "supervisor_password";

    // Contacts Table Columns names - Masonry worker
    private static final String Masonry_Worker_NUMBER = "masonryWorker_number";
    private static final String Masonry_Worker_FIRSTNAME = "masonryWorker_firstname";
    private static final String Masonry_Worker_LASTNAME = "masonryWorker_lastname";
    private static final String Masonry_Worker_NIC = "masonryWorker_NIC";
    private static final String Masonry_Worker_PHONE_NUMBER = "masonryWorker_phone";
    private static final String Masonry_Worker_ASSIGNED_SITE_ID = "masonryWorker_assigned_site_number";
    private static final String Masonry_Worker_WORKER_ID = "masonryWorker_workerID";

    // Contacts Table Columns names - Helper
    private static final String Helper_NUMBER = "helper_number";
    private static final String Helper_FIRSTNAME = "helper_firstname";
    private static final String Helper_LASTNAME = "helper_lastname";
    private static final String Helper_NIC = "helper_NIC";
    private static final String Helper_PHONE_NUMBER = "helper_phone";
    private static final String Helper_ASSIGNED_SITE_ID = "helper_assigned_site_number";
    private static final String Helper_WORKER_ID = "helper_workerID";

    // Contacts Table Columns names - Construction site
    private static final String Construction_site_NUMBER = "construction_site_number";
    private static final String Construction_site_ID = "construction_siteID";
    private static final String Construction_site_LOCATION = "construction_site_location";
    private static final String Construction_site_NO_OF_PERCHES = "construction_site_perches";
    private static final String Construction_site_CLIENT_NAME = "construction_site_client_name";
    private static final String Construction_site_TIME_PERIOD = "construction_site_time_period";
    private static final String Construction_site_ASSIGNED_SUPERVISOR_USER_ID = "construction_site_supervisorID";

    // Contacts Table Columns names Masonry worker attendance
    private static final String AttendanceMW_NUMBER = "attendance_number";
    private static final String AttendanceMW_SELECT_DATE = "MWAttendance_selectDate";
    private static final String AttendanceMW_WORKER_ID = "MWAttendance_workerID";
    private static final String AttendanceMW_STATUS_OF_ATTENDANCE = "MWAttendance_statusOfAttendance";

    // Contacts Table Columns names Helper attendance
    private static final String AttendanceH_NUMBER = "attendance_number";
    private static final String AttendanceH_SELECT_DATE = "HAttendance_selectDate";
    private static final String AttendanceH_WORKER_ID = "HAttendance_workerID";
    private static final String AttendanceH_STATUS_OF_ATTENDANCE = "HAttendance_statusOfAttendance";

    // Contacts Table Columns names - Salary
    private static final String Salary_NUMBER = "salary_number";
    private static final String Salary_NO_OF_DAYS = "No_of_days";
    private static final String Salary_EMPLOYEE_SALARY = "Employee_salary";
    private static final String Salary_WORKER_ID = "Enter_the_workerID";
    private static final String Salary_YEAR_AND_MONTH = "Year_and_month";

    public DataBase (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dataB) {

        String querySupervisor="CREATE TABLE "+ SUPERVISORS_TABLE +" (" +
                Supervisor_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Supervisor_FIRSTNAME + " TEXT, " +
                Supervisor_LASTNAME + " TEXT, " +
                Supervisor_NIC + " TEXT, " +
                Supervisor_PHONE_NUMBER + " TEXT," +
                Supervisor_USER_ID + " TEXT," +
                Supervisor_PASSWORD + " TEXT " + ")";
        Log.d("querySupervisor",querySupervisor);


        try
        {
            dataB.execSQL(querySupervisor);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryMasonry_worker="CREATE TABLE "+ MASONRY_WORKERS_TABLE +" (" +
                Masonry_Worker_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Masonry_Worker_FIRSTNAME + " TEXT, " +
                Masonry_Worker_LASTNAME + " TEXT, " +
                Masonry_Worker_NIC + " TEXT, " +
                Masonry_Worker_PHONE_NUMBER + " TEXT," +
                Masonry_Worker_ASSIGNED_SITE_ID + " TEXT," +
                Masonry_Worker_WORKER_ID + " TEXT " + ")";
        Log.d("queryMasonry_worker",queryMasonry_worker);


        try
        {
            dataB.execSQL(queryMasonry_worker);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryHelper="CREATE TABLE "+ HELPERS_TABLE +" (" +
                Helper_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Helper_FIRSTNAME + " TEXT, " +
                Helper_LASTNAME + " TEXT, " +
                Helper_NIC + " TEXT, " +
                Helper_PHONE_NUMBER + " TEXT," +
                Helper_ASSIGNED_SITE_ID + " TEXT," +
                Helper_WORKER_ID + " TEXT " + ")";
        Log.d("queryHelper",queryHelper);


        try
        {
            dataB.execSQL(queryHelper);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryConstructionSite="CREATE TABLE "+ CONSTRUCTION_SITES_TABLE +" (" +
                Construction_site_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Construction_site_ID + " TEXT, " +
                Construction_site_LOCATION + " TEXT, " +
                Construction_site_NO_OF_PERCHES + " TEXT, " +
                Construction_site_CLIENT_NAME + " TEXT," +
                Construction_site_TIME_PERIOD + " TEXT," +
                Construction_site_ASSIGNED_SUPERVISOR_USER_ID + " TEXT " + ")";
        Log.d("queryConstructionSite",queryConstructionSite);


        try
        {
            dataB.execSQL(queryConstructionSite);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryAttendanceMW="CREATE TABLE "+ ATTENDANCE_TABLE_MW +" (" +
                AttendanceMW_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AttendanceMW_SELECT_DATE + " TEXT, " +
                AttendanceMW_WORKER_ID + " TEXT, " +
                AttendanceMW_STATUS_OF_ATTENDANCE + " TEXT " + ")";
        Log.d("queryAttendanceMW",queryAttendanceMW);


        try
        {
            dataB.execSQL(queryAttendanceMW);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryAttendanceH="CREATE TABLE "+ ATTENDANCE_TABLE_H +" (" +
                AttendanceH_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AttendanceH_SELECT_DATE + " TEXT, " +
                AttendanceH_WORKER_ID + " TEXT, " +
                AttendanceH_STATUS_OF_ATTENDANCE + " TEXT " + ")";
        Log.d("queryAttendanceH",queryAttendanceH);


        try
        {
            dataB.execSQL(queryAttendanceH);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String querySalary="CREATE TABLE "+ SALARY_TABLE +" (" +
                Salary_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Salary_NO_OF_DAYS + " TEXT, " +
                Salary_EMPLOYEE_SALARY + " TEXT, " +
                Salary_WORKER_ID + " TEXT, " +
                Salary_YEAR_AND_MONTH + " TEXT " + ")";
        Log.d("querySalary",querySalary);


        try
        {
            dataB.execSQL(querySalary);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase dataB, int i, int i1) {

        String querySupervisor="CREATE TABLE "+ SUPERVISORS_TABLE +" (" +
                Supervisor_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Supervisor_FIRSTNAME + " TEXT, " +
                Supervisor_LASTNAME + " TEXT, " +
                Supervisor_NIC + " TEXT, " +
                Supervisor_PHONE_NUMBER + " TEXT," +
                Supervisor_USER_ID + " TEXT," +
                Supervisor_PASSWORD + " TEXT " + ")";
        Log.d("querySupervisor",querySupervisor);


        try
        {
            dataB.execSQL(querySupervisor);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryMasonry_worker="CREATE TABLE "+ MASONRY_WORKERS_TABLE +" (" +
                Masonry_Worker_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Masonry_Worker_FIRSTNAME + " TEXT, " +
                Masonry_Worker_LASTNAME + " TEXT, " +
                Masonry_Worker_NIC + " TEXT, " +
                Masonry_Worker_PHONE_NUMBER + " TEXT," +
                Masonry_Worker_ASSIGNED_SITE_ID + " TEXT," +
                Masonry_Worker_WORKER_ID + " TEXT " + ")";
        Log.d("queryMasonry_worker",queryMasonry_worker);


        try
        {
            dataB.execSQL(queryMasonry_worker);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryHelper="CREATE TABLE "+ HELPERS_TABLE +" (" +
                Helper_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Helper_FIRSTNAME + " TEXT, " +
                Helper_LASTNAME + " TEXT, " +
                Helper_NIC + " TEXT, " +
                Helper_PHONE_NUMBER + " TEXT," +
                Helper_ASSIGNED_SITE_ID + " TEXT," +
                Helper_WORKER_ID + " TEXT " + ")";
        Log.d("queryHelper",queryHelper);


        try
        {
            dataB.execSQL(queryHelper);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryConstructionSite="CREATE TABLE "+ CONSTRUCTION_SITES_TABLE +" (" +
                Construction_site_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Construction_site_ID + " TEXT, " +
                Construction_site_LOCATION + " TEXT, " +
                Construction_site_NO_OF_PERCHES + " TEXT, " +
                Construction_site_CLIENT_NAME + " TEXT," +
                Construction_site_TIME_PERIOD + " TEXT," +
                Construction_site_ASSIGNED_SUPERVISOR_USER_ID + " TEXT " + ")";
        Log.d("queryConstructionSite",queryConstructionSite);


        try
        {
            dataB.execSQL(queryConstructionSite);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryAttendanceMW="CREATE TABLE "+ ATTENDANCE_TABLE_MW +" (" +
                AttendanceMW_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AttendanceMW_SELECT_DATE + " TEXT, " +
                AttendanceMW_WORKER_ID + " TEXT, " +
                AttendanceMW_STATUS_OF_ATTENDANCE + " TEXT " + ")";
        Log.d("queryAttendanceMW",queryAttendanceMW);

        try
        {
            dataB.execSQL(queryAttendanceMW);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String queryAttendanceH="CREATE TABLE "+ ATTENDANCE_TABLE_H +" (" +
                AttendanceH_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AttendanceH_SELECT_DATE + " TEXT, " +
                AttendanceH_WORKER_ID + " TEXT, " +
                AttendanceH_STATUS_OF_ATTENDANCE + " TEXT " + ")";
        Log.d("queryAttendanceH",queryAttendanceH);

        try
        {
            dataB.execSQL(queryAttendanceH);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

        String querySalary="CREATE TABLE "+ SALARY_TABLE +" (" +
                Salary_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Salary_NO_OF_DAYS + " TEXT, " +
                Salary_EMPLOYEE_SALARY + " TEXT, " +
                Salary_WORKER_ID + " TEXT, " +
                Salary_YEAR_AND_MONTH + " TEXT " + ")";
        Log.d("querySalary",querySalary);


        try
        {
            dataB.execSQL(querySalary);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }
    }

    //Supervisor
    public void addSupervisor(GetSet_Supervisors getSet_supervisors) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO supervisors_table (supervisor_firstname,supervisor_lastname,supervisor_NIC,supervisor_phone,supervisor_userID,supervisor_password) values ('"+
                getSet_supervisors.getSupervisor_firstname()+"', '"+
                getSet_supervisors.getSupervisor_lastname()+"', '"+
                getSet_supervisors.getSupervisor_NIC()+"', '"+
                getSet_supervisors.getSupervisor_phone()+"', '"+
                getSet_supervisors.getSupervisor_userID()+"', '"+
                getSet_supervisors.getSupervisor_password()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }

    //Masonry worker
    public void addMasonryWorker(GetSet_MasonryWorkers getSet_masonryWorkers) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO masonry_workers_table (masonryWorker_firstname,masonryWorker_lastname,masonryWorker_NIC,masonryWorker_phone,masonryWorker_assigned_site_number,masonryWorker_workerID) values ('"+
                getSet_masonryWorkers.getMasonryWorker_firstname()+"', '"+
                getSet_masonryWorkers.getMasonryWorker_lastname()+"', '"+
                getSet_masonryWorkers.getMasonryWorker_NIC()+"', '"+
                getSet_masonryWorkers.getMasonryWorker_phone()+"', '"+
                getSet_masonryWorkers.getMasonryWorker_assigned_site_number()+"', '"+
                getSet_masonryWorkers.getMasonryWorker_workerID()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }

    //Helper
    public void addHelper(GetSet_Helpers getSet_helpers) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO helpers_table (helper_firstname,helper_lastname,helper_NIC,helper_phone,helper_assigned_site_number,helper_workerID) values ('"+
                getSet_helpers.getHelper_firstname()+"', '"+
                getSet_helpers.getHelper_lastname()+"', '"+
                getSet_helpers.getHelper_NIC()+"', '"+
                getSet_helpers.getHelper_phone()+"', '"+
                getSet_helpers.getHelper_assigned_site_number()+"', '"+
                getSet_helpers.getHelper_workerID()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }

    //Construction Site
    public void addConstructionSite(GetSet_ConstructionSites getSet_constructionSites) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO construction_sites_table (construction_siteID,construction_site_location,construction_site_perches,construction_site_client_name,construction_site_time_period,construction_site_supervisorID) values ('"+
                getSet_constructionSites.getConstructionSite_ID()+"', '"+
                getSet_constructionSites.getConstructionSite_location()+"', '"+
                getSet_constructionSites.getConstructionSite_perches()+"', '"+
                getSet_constructionSites.getConstructionSite_clientName()+"', '"+
                getSet_constructionSites.getConstructionSite_timePeriod()+"', '"+
                getSet_constructionSites.getConstructionSite_supervisorID()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }

    //Attendance MW
    public void markattendanceMW(GetSet_Attendance_MW getSet_attendance_mw) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO attendance_table_mw (MWAttendance_selectDate,MWAttendance_workerID,MWAttendance_statusOfAttendance) values ('"+
                getSet_attendance_mw.getMWAttendance_selectDate()+"', '"+
                getSet_attendance_mw.getMWAttendance_workerID()+"', '"+
                getSet_attendance_mw.getMWAttendance_statusOfAttendance()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }

    //Attendance H
    public void markattendanceH(GetSet_Attendance_H getSet_attendance_h) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO attendance_table_h (HAttendance_selectDate,HAttendance_workerID,HAttendance_statusOfAttendance) values ('"+
                getSet_attendance_h.getHAttendance_selectDate()+"', '"+
                getSet_attendance_h.getHAttendance_workerID()+"', '"+
                getSet_attendance_h.getHAttendance_statusOfAttendance()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }

    //Salary
    public void addSalary(GetSet_salary getSet_salary) {
        SQLiteDatabase dataB = this.getWritableDatabase();

        String query = "INSERT INTO salary_table (No_of_days,Employee_salary,Enter_the_workerID,Year_and_month) values ('"+
                getSet_salary.getSalary_No_of_days()+"', '"+
                getSet_salary.getSalary_Employee_salary()+"', '"+
                getSet_salary.getSalary_Enter_the_workerID()+"', '"+
                getSet_salary.getSalary_Year_and_month()+"')";
        Log.d("query", query);
        dataB.execSQL(query);
        dataB.close();
    }
}