package com.appfunlu.lawofattraction;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    /**
     * This Method retrieves the text from EditText and
     * dislpay it in the TextView
     */
    private void showGratefulText(){
        String textInput = mInputGratefulList.getText().toString();
        mGratefulList.setText(textInput.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grateful_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.grateful_tab) {
            Context context = MainActivity.this;
            String textToShow = "Grateful list clicked";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveGratitudeList(View v) {
        showGratefulText();
    }
}
