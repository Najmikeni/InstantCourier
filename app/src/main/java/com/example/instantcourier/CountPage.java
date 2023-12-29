package com.example.instantcourier;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class CountPage extends AppCompatActivity {

    //initialization
    private Spinner spVehicle;
    DecimalFormat roundoff = new DecimalFormat("###.##");
    private ImageView changeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_layout);
        changeImage = findViewById(R.id.changeImage);

        //spinner array
        spVehicle = findViewById(R.id.spVehicle);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.vehicle, R.layout.spiner_item);
        spVehicle.setAdapter(adapter);

        //method to change image based on spinner position
        spVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    changeImage.setImageResource(R.drawable.motorcycle);
                }
                else if(position==1){
                    changeImage.setImageResource(R.drawable.car);
                }
                else{
                    changeImage.setImageResource(R.drawable.four4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //method to calculate delivery cost
    public void calculateCost(View view){
        String deliveryTime;

        //get vehicle spinner value
        Spinner spVehicle = findViewById(R.id.spVehicle);
        String vehicle = spVehicle.getSelectedItem().toString();
        //get distance value
        EditText etDistance = findViewById(R.id.etDistance);
        int distance = Integer.parseInt(etDistance.getText().toString());
        //get delivery time value
        RadioButton rbMorning = findViewById(R.id.rbMorning);
        if(rbMorning.isChecked()){
            deliveryTime = "morning";
        }
        else{
            deliveryTime = "night";
        }
        //get destination value
        EditText etDestination = findViewById(R.id.etDestination);
        int destination = Integer.parseInt(etDestination.getText().toString());

        //calculate delivery cost
        double cost = 0.00;
        double pricePerKM = 0.00;

        if(vehicle.equals("Motorcycle")){
            int extraDestination = 1;
            //check distance
            if(distance > 10){
                pricePerKM = 0.80;
            }
            else if(distance > 5){
                pricePerKM = 1.00;
            }
            else {
                pricePerKM = 5.00;
            }

            //check delivery time
            if(deliveryTime.equalsIgnoreCase("night")){
                cost = (pricePerKM * distance) + ((destination - 1) * (extraDestination));
                cost = cost + (cost*0.3);
            }
            else{
                cost = (pricePerKM * distance) + ((destination - 1) * (extraDestination));
            }
        }
        else if (vehicle.equals("Car")){
            int extraDestination = 2;
            if(distance > 10){
                pricePerKM = 1.50;
            }
            else if(distance > 5){
                pricePerKM = 1.00;
            }
            else {
                pricePerKM = 8.00;
            }

            //check delivery time
            if(deliveryTime.equalsIgnoreCase("night")){
                cost = (pricePerKM * distance) + ((destination - 1) * (extraDestination));
                cost = cost + (cost*0.3);
            }
            else{
                cost = (pricePerKM * distance) + ((destination - 1) * (extraDestination));
            }
        }
        else{
            int extraDestination = 5;
            if(distance > 10){
                pricePerKM = 1.65;
            }
            else if(distance > 5){
                pricePerKM = 2.20;
            }
            else {
                pricePerKM = 22.00;
            }

            //check delivery time
            if(deliveryTime.equalsIgnoreCase("night")){
                cost = (pricePerKM * distance) + ((destination - 1) * (extraDestination));
                cost = cost + (cost*0.3);
            }
            else{
                cost = (pricePerKM * distance) + ((destination - 1) * (extraDestination));
            }
        }

        // Error handling if either of destination or distance is 0 value
        if(destination == 0 || distance == 0){
            cost = 0;
        }

        //display delivery cost
        TextView tvCost = findViewById(R.id.tvCost);
        tvCost.setText("The cost of your delivery is RM " + roundoff.format(cost));
    }
}
