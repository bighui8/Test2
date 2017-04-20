package com.example.huiying.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class AddScreens extends AppCompatActivity {

    //initiate variables
    String item;
    Button button_go;
    Spinner spinner;
    Intent intent;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screens);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // define spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.InputTypes));
        spinner.setAdapter(spinnerAdapter);

        // adding setOnItemSelectedListener method on spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = (String) spinner.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?>parent){
            }
        });


        //click button to IncomeActivity activity
        button_go = (Button) findViewById(R.id.button2);
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (item) {
                    case "Coupon":
                        Intent intentCoupon = new Intent(AddScreens.this, AddCoupon.class);
                        startActivity(intentCoupon);
                        Toast.makeText(AddScreens.this, "Record Coupon", Toast.LENGTH_SHORT).show();
                    case "Income":
                        Intent intentIncome = new Intent(AddScreens.this, AddIncome.class);
                        startActivity(intentIncome);
                        Toast.makeText(AddScreens.this, "Record Income", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //click image to InputPage activity and pass category value to next activity
        img1 = (ImageView)findViewById(R.id.imageView1);
        img1.setClickable(true);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Food&Drinks");
                startActivity(inputIntent);
            }
        });

        img2 = (ImageView)findViewById(R.id.imageView2);
        img2.setClickable(true);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Transportation");
                startActivity(inputIntent);
            }
        });

        img3 = (ImageView)findViewById(R.id.imageView3);
        img3.setClickable(true);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Health");
                startActivity(inputIntent);
            }
        });

        img4 = (ImageView)findViewById(R.id.imageView4);
        img4.setClickable(true);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Home");
                startActivity(inputIntent);
            }
        });

        img5 = (ImageView)findViewById(R.id.imageView5);
        img5.setClickable(true);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Shopping");
                startActivity(inputIntent);
            }
        });

        img6 = (ImageView)findViewById(R.id.imageView6);
        img6.setClickable(true);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Mobile Phone");
                startActivity(inputIntent);
            }
        });

        img7 = (ImageView)findViewById(R.id.imageView7);
        img7.setClickable(true);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Social");
                startActivity(inputIntent);
            }
        });

        img8 = (ImageView)findViewById(R.id.imageView8);
        img8.setClickable(true);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Travel");
                startActivity(inputIntent);
            }
        });

        img9 = (ImageView)findViewById(R.id.imageView9);
        img9.setClickable(true);
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddScreens.this, Input.class);
                inputIntent.putExtra("InputType","Education");
                startActivity(inputIntent);
            }
        });

    }

}

