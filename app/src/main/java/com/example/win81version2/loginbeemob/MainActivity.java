package com.example.win81version2.loginbeemob;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edittext_main_username, edittext_main_password;
    CheckBox checkbox_main_remember;
    Button button_main_login;
    String username_login= "user name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext_main_username= (EditText) findViewById(R.id.edittext_main_username);
        edittext_main_password= (EditText) findViewById(R.id.edittext_main_password);
        checkbox_main_remember= (CheckBox) findViewById(R.id.checkbox_main_remember);
        button_main_login= (Button) findViewById(R.id.button_main_login);

        button_main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_main= "khachung1807";
                String password_main= "khachung";
                if (edittext_main_username.getText().toString().equals(username_main)&&
                        edittext_main_password.getText().toString().equals(password_main)){
                    Toast.makeText(MainActivity.this, "You are login!!!", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainActivity.this, LoginBeemobActivity.class);
                    startActivity(intent);
                } else Toast.makeText(MainActivity.this, "Wrong!!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences= getSharedPreferences(username_login, MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("Username", edittext_main_username.getText().toString());
        editor.putString("Password", edittext_main_password.getText().toString());
        editor.putBoolean("Remember", checkbox_main_remember.isChecked());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences= getSharedPreferences(username_login, MODE_PRIVATE);
        String username= preferences.getString("Username", "");
        String password= preferences.getString("Password", "");
        Boolean remember= preferences.getBoolean("Remember", false);
        if (remember) {
            edittext_main_username.setText(username);
            edittext_main_password.setText(password);
        }
    }
}
