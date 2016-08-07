package com.webhawksit.rio.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

    Button bLogin;
    EditText etUserName, etPassword;
    TextView linkForRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = (Button) findViewById(R.id.loginBtn);

        linkForRegisterBtn = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        linkForRegisterBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                etUserName = (EditText) findViewById(R.id.etUserName);
                String username = etUserName.getText().toString();

                etPassword = (EditText) findViewById(R.id.etPassword);
                String password = etPassword.getText().toString();

                String pass = databaseHelper.searchPass(username);
                if (password.equals(pass)) {
                    startActivity(new Intent(getApplicationContext(), Display.class));
                    Toast message = Toast.makeText(getApplicationContext(), "Successfully Login!", Toast.LENGTH_SHORT);
                    message.show();
                } else {
//                    popup message
                    Toast message = Toast.makeText(getApplicationContext(), "Password and username Don't Match !", Toast.LENGTH_SHORT);
                    message.show();
                }

                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
        }
    }
}
