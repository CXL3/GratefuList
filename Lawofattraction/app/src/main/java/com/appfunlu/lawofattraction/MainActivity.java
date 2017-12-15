package com.appfunlu.lawofattraction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
     * I give variable names to the text views on the main page.
     */

    private TextView gratitudeFront;
    private TextView visionFront;
    private TextView quoteFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        /*
         * Set the TextView to this variable and set a click listener on it.
         * the intent will open the GratitudeActivity.
         */
        gratitudeFront = (TextView) findViewById(R.id.gratitude_front_page);
        gratitudeFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gIntent = new Intent(MainActivity.this, GratitudeActivity.class);
                startActivity(gIntent);
            }
        });

         /*
         * Set the TextView to this variable and set a click listener on it.
         * the intent will open the VisionActivity
         */

        visionFront = (TextView) findViewById(R.id.vision_front_page);
        visionFront.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent vIntent = new Intent(MainActivity.this, VisionActivity.class);
                startActivity(vIntent);
            }
        });

        /*
         * Set the TextView to this variable and set a click listener on it.
         * the intent will open the QuotesActivity
         */


        quoteFront = (TextView) findViewById(R.id.quote_front_page);
        quoteFront.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent qIntent = new Intent(MainActivity.this, QuotesActivity.class);
                startActivity(qIntent);
            }
        });

    }
}


