package com.dratek.dragonmanu.dragonsetup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class DeviceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        final EditText _relayid        = (EditText) findViewById(R.id.app_id);
        final EditText _name       = (EditText) findViewById(R.id.app_Name);
        final EditText _power     = (EditText) findViewById(R.id.app_Power);
        final EditText _action     = (EditText) findViewById(R.id.app_Action);

        Button register = (Button) findViewById(R.id.register_device);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String relayid      = _relayid.getText().toString();
                String name     = _name.getText().toString();
                String power   = _power.getText().toString();
                String action   = _action.getText().toString();

                if (TextUtils.isEmpty(relayid)){
                    _relayid.setError("Enter house ID");
                    _relayid.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(name)){
                    _name.setError("Enter Room Name");
                    _name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(power)){
                    _power.setError("Enter Board ID");
                    _power.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(action)){
                    _action.setError("Enter Board ID");
                    _action.requestFocus();
                    return;
                }

                Intent addDevice = new Intent(getApplicationContext(),MainActivity.class);

                addDevice.setType("plain/text");
                addDevice.putExtra("relayid",relayid);
                addDevice.putExtra("name",name);
                addDevice.putExtra("power",power);
                addDevice.putExtra("action",action);
                setResult(RESULT_OK, addDevice);

                DeviceActivity.super.finish();

            }
        });

    }

}
