/*
 * Copyright 2018.  Xi Lu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appfunlu.draftforlawofattractionapp;

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

