package com.webhawksit.rio.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button registerBtn;
    EditText etname,etUserName,etAge,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etname = (EditText) findViewById(R.id.etName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etAge = (EditText) findViewById(R.id.etAge);
        etPassword = (EditText) findViewById(R.id.etPassword);

        registerBtn = (Button) findViewById(R.id.registerBtn);


        registerBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerBtn:



                break;
        }
    }
}
