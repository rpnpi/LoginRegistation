package com.webhawksit.rio.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin ;
    EditText etUserName,etPassword;
    TextView linkForRegisterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.loginBtn);

        linkForRegisterBtn = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        linkForRegisterBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtn:

                
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                break;
        }
    }
}
