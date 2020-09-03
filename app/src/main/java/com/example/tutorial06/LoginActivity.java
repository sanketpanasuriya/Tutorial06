package com.example.tutorial06;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    EditText Email;
    EditText Password;
    int count = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=(EditText)findViewById(R.id.edtEmail);
        Password=(EditText)findViewById(R.id.edtPassword);

        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                checkDataEntered();
            }
        });
    }
    void checkDataEntered(){
        if(count==0){
            finish();
        }
        if(isEmpty(Email)) {
            Toast t = Toast.makeText(this,"You must enter Username",Toast.LENGTH_SHORT);
            t.show();
        }
        else if(isEmpty(Password)) {
            Toast t = Toast.makeText(this,"You must enter Password",Toast.LENGTH_SHORT);
            t.show();
        } else if(!isEmail(Email)){
            Email.setError("Enter valid email");
            Toast t = Toast.makeText(this,"Enter valid Email address",Toast.LENGTH_SHORT);
            t.show();
        } else if(!Email.getText().toString().equals("admin@gmail.com")){
            Email.setError("Enter valid username");
            Toast t = Toast.makeText(this,"Enter valid username "+count+" attepmt left",Toast.LENGTH_SHORT);
            t.show();
            count--;
        } else if(!Password.getText().toString().equals("admin")){
            Password.setError("Enter valid password");
            Toast t = Toast.makeText(this,"Enter valid password "+count+" attepmt left",Toast.LENGTH_SHORT);
            t.show();
            count--;
        }else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void registration_click(View view) {
                Intent intent = new Intent(LoginActivity.this,Registration.class);
                startActivity(intent);
    }

}