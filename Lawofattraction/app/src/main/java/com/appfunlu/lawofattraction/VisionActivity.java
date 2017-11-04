package com.appfunlu.lawofattraction;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VisionActivity extends AppCompatActivity{

    private EditText mInputVisionList;

    private TextView mVisionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vision_list);


        mInputVisionList = (EditText) findViewById(R.id.vision_list_input);

        mVisionList = (TextView) findViewById(R.id.vision_list);


    }

    private void showVisionText(){
        String vTextView = mInputVisionList.getText().toString();
        mVisionList.setText(vTextView.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vision_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();

        if (itemThatWasClickedId == R.id.grateful_tab2) {
            Context context = VisionActivity.this;
            Class destinationActivity3 = MainActivity.class;
            Intent startMainActivityIntent = new Intent(context, destinationActivity3);
            startActivity(startMainActivityIntent);
            return true;

        }

        if (itemThatWasClickedId == R.id.quotes_tab2) {
            Context context = VisionActivity.this;
            Class destinationActivity4 = QuotesActivity.class;
            Intent startQuotesActivityIntent = new Intent(context, destinationActivity4);
            startActivity(startQuotesActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveVisionList(View v){

        showVisionText();
    }

}
