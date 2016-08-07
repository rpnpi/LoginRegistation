package com.webhawksit.rio.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    Button registerBtn;
    EditText etname, email, etUserName, TFPassword, TFconfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        registerBtn = (Button) findViewById(R.id.registerBtn);
//        registerBtn.setOnClickListener(this);


    }

    public void onClickRegister(View view) {
        if (view.getId() == R.id.registerBtn) {
//            Intent intent = new Intent(getApplication(),Display.class);
//            startActivity(intent);
            etname = (EditText) findViewById(R.id.etName);
            email = (EditText) findViewById(R.id.etemail);
            etUserName = (EditText) findViewById(R.id.etUserName);
            TFPassword = (EditText) findViewById(R.id.TFPassword);
            TFconfirmPassword = (EditText) findViewById(R.id.TFconfirmPassword);

            String nameString = etname.getText().toString();
            String emailString = email.getText().toString();
            String usernameString = etUserName.getText().toString();
            String password1String = TFPassword.getText().toString();
            String password2String = TFconfirmPassword.getText().toString();
            if (!password1String.equals(password2String)) {
                //            Toast popup message
                Toast pass = Toast.makeText(RegisterActivity.this, "Password don't Match", Toast.LENGTH_SHORT);
                pass.show();

            } else {
                //insert the data in database
                User user = new User();
                user.setName(nameString);
                user.setEmail(emailString);
                user.setUsername(usernameString);
                user.setPassword(password1String);

                helper.insertUser(user);
            }

        }
    }
}
