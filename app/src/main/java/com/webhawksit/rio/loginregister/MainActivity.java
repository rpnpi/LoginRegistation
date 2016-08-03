package com.webhawksit.rio.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button logoutBtn;
    EditText etname,etUserName,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText) findViewById(R.id.etName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etAge = (EditText) findViewById(R.id.etAge);

        logoutBtn = (Button) findViewById(R.id.logOutbtn);

        logoutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logOutbtn:
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
        }
    }
}
