package com.example.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lblWelcome;
    String userName ;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Login",Context.MODE_PRIVATE);

        lblWelcome = findViewById(R.id.lblWelcome);
        userName = sharedPreferences.getString("Username","");
        editor = sharedPreferences.edit();

        lblWelcome.setText(lblWelcome.getText().toString()+", "+userName);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_manu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuLogout:
                mnu_onClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void mnu_onClick(){
        editor.remove("isLogin");
        editor.remove("Username");
        editor.commit();
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

}