package com.example.win81version2.loginbeemob;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceReservationActivity extends AppCompatActivity {
    TextView text_placereservation;
    Button button_placereservation_exit;
    Intent intent;
    AlertDialog dialog_placereservation_beemob;
    String firstname, lastname, passpharase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_reservation);
        text_placereservation= (TextView) findViewById(R.id.text_placereservation);
        button_placereservation_exit= (Button) findViewById(R.id.button_placereservation_exit);
        intent= getIntent();
        firstname= intent.getStringExtra("firstname");
        lastname= intent.getStringExtra("lastname");
        passpharase= intent.getStringExtra("passpharase");
        text_placereservation.setText("INFORMATION\n"+"Name: "+firstname+" "+lastname+"\nPasspharase: "+passpharase+"\n");

        button_placereservation_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(PlaceReservationActivity.this);
                builder.setTitle("BEEMOB");
                builder.setMessage("Do you want exit???");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent= new Intent(PlaceReservationActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(PlaceReservationActivity.this, "You are here/ >>>>", Toast.LENGTH_LONG).show();
                    }
                });
//                dialog_placereservation_beemob= new Dialog(PlaceReservationActivity.this);
//                dialog_placereservation_beemob.setTitle("BEEMOB");
//                dialog_placereservation_beemob.setContentView(R.layout.dialog_placereservetion_exit);
//                dialog_placereservation_beemob.show();
                builder.create().show();
            }
        });
    }
}
