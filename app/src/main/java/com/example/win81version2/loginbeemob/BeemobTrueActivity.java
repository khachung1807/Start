package com.example.win81version2.loginbeemob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class BeemobTrueActivity extends Activity {
    EditText edittext_beemobtrue_firstname,
            edittext_beemobtrue_lastname,
            edittext_beemobtrue_passpharase,
            edittext_beemobtrue_luggage;
    RadioButton radio_beemobtrue_window,
            radio_beemobtrue_aisle,
            radio_beemobtrue_dontcare;
    CheckBox checkbox_beemobtrue_vegetarian;
    Button button_beemobtrue_placereservation;
    AutoCompleteTextView auto_beemobtrue_country;
    String[] array_beemobtrue_country;
    ArrayAdapter<String> adapter_beemobtrue_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beemob_true);
        edittext_beemobtrue_firstname= findViewById(R.id.edittext_beemobtrue_firstname);
        edittext_beemobtrue_lastname= findViewById(R.id.edittext_beemobtrue_lastname);
        edittext_beemobtrue_luggage= findViewById(R.id.edittext_beemobtrue_luggage);
        edittext_beemobtrue_passpharase= findViewById(R.id.edittext_beemobtrue_passpharase);
        radio_beemobtrue_window= findViewById(R.id.radio_beemobtrue_window);
        radio_beemobtrue_aisle= findViewById(R.id.radio_beemobtrue_aisle);
        radio_beemobtrue_dontcare= findViewById(R.id.radio_beemobtrue_dontcare);
        checkbox_beemobtrue_vegetarian= findViewById(R.id.checkbox_beemobtrue_vegetarian);
        button_beemobtrue_placereservation= findViewById(R.id.button_beemobtrue_placereservation);
        auto_beemobtrue_country= (AutoCompleteTextView) findViewById(R.id.auto_beemobtrue_country);

        array_beemobtrue_country= getResources().getStringArray(R.array.array_beemobtrue_country);
        adapter_beemobtrue_country= new ArrayAdapter<String>(BeemobTrueActivity.this,
                android.R.layout.simple_list_item_1,
                array_beemobtrue_country);
        auto_beemobtrue_country.setAdapter(adapter_beemobtrue_country);
    }

    public void clickbutton_beemobtrue_placereservation(View view) {
        try{
            if(edittext_beemobtrue_firstname.getText().toString().equals("") ||
                    edittext_beemobtrue_lastname.getText().toString().equals("") ||
                    edittext_beemobtrue_passpharase.getText().toString().equals("")){
                Toast.makeText(BeemobTrueActivity.this, "Wrong!!!!", Toast.LENGTH_LONG).show();
            } else {
                Intent intent_beemobtrue= new Intent(BeemobTrueActivity.this, PlaceReservationActivity.class);
                intent_beemobtrue.putExtra("firstname", edittext_beemobtrue_firstname.getText().toString() );
                intent_beemobtrue.putExtra("lastname", edittext_beemobtrue_lastname.getText().toString());
                intent_beemobtrue.putExtra("passpharase", edittext_beemobtrue_passpharase.getText().toString());
                startActivity(intent_beemobtrue);
            }
        } catch (Exception e){
            Log.getStackTraceString(e);
        }
    }
}
