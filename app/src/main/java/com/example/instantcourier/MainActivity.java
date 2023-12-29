package com.example.instantcourier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Called when the Start button logo is clicked
     */
    public void startBtnClicked(View v) {
        // create a new explicit intent to open count_layout activity
        Intent countLayout = new Intent(this, CountPage.class);
        // start the countLayout activity
        startActivity(countLayout);
    }
}