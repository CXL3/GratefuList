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





        TextView gratitudeFront = (TextView) findViewById(R.id.gratitude_front_page);

        gratitudeFront.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent gIntent = new Intent(MainActivity.this, GratitudeActivity.class);

                startActivity(gIntent);
            }
        });





        TextView VisionFront = (TextView) findViewById(R.id.vision_front_page);


        VisionFront.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent vIntent = new Intent(MainActivity.this, VisionActivity.class);


                startActivity(vIntent);
            }
        });






        TextView QuoteFront = (TextView) findViewById(R.id.quote_front_page);

        QuoteFront.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent qIntent = new Intent(MainActivity.this, QuotesActivity.class);


                startActivity(qIntent);
            }
        });

    }
}
