package com.app1.app;

import androidx.appcompat.app.AppCompatActivity;

import com.app1.app.GettersandSetters.GetSet_Supervisors;

public class Context extends AppCompatActivity {

    private GetSet_Supervisors getSet_supervisors;

    public GetSet_Supervisors getSet_supervisors() {
        return getSet_supervisors;
    }
    public void setSupervisorBean(GetSet_Supervisors supervisorBean) {
        this.getSet_supervisors = getSet_supervisors;
    }

}
