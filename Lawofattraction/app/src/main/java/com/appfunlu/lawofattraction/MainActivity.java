package com.appfunlu.lawofattraction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        TextView numbers = (TextView) findViewById(R.id.gratitude_front_page);

        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent gIntent = new Intent(MainActivity.this, GratitudeActivity.class);

                startActivity(gIntent);
            }
        });


        TextView family = (TextView) findViewById(R.id.vision_front_page);


        family.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent vIntent = new Intent(MainActivity.this, VisionActivity.class);


                startActivity(vIntent);
            }
        });


        TextView colors = (TextView) findViewById(R.id.quote_front_page);

        colors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent qIntent = new Intent(MainActivity.this, QuotesActivity.class);


                startActivity(qIntent);
            }
        });

    }
}
