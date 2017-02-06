package com.vrjco.v.example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Written by Vrushabh Jambhulkar
 **/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference of button added in the main layout
        Button button = (Button) findViewById(R.id.button);

        //setting click event listener to button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_layout, null);

                TextView title = (TextView) view.findViewById(R.id.title);
                ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

                title.setText("Hello There!");

                imageButton.setImageResource(R.drawable.smile);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Thank you", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Never Mind!", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setView(view);
                builder.show();

            }
        });
    }
}
