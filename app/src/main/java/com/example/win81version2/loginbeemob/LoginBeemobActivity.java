package com.example.win81version2.loginbeemob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginBeemobActivity extends Activity {
    Button button_loginbeemob_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_beemob);
        button_loginbeemob_ok= findViewById(R.id.button_loginbeemob_ok);
    }

    public void clickok_playbeemob(View view) {
        Intent intent_loginbeemob= new Intent(LoginBeemobActivity.this, BeemobTrueActivity.class);
        startActivity(intent_loginbeemob);
        finish();
    }
}
