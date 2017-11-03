package com.appfunlu.lawofattraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mInputGratefulList;

    private TextView mGratefulList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputGratefulList = (EditText) findViewById(R.id.grateful_input_box);

        mGratefulList = (TextView) findViewById(R.id.grateful_list);

    }

}
