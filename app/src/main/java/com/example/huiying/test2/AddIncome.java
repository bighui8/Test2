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

public class AddIncome extends AppCompatActivity {
    String item;
    String type;
    Button button_go;
    Spinner spinner;
    Intent intent;
    Intent inputIntent;
    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_page_income);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner = (Spinner)findViewById(R.id.spinner);
        button_go = (Button) findViewById(R.id.button2);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.InputTypes2));

        spinner.setAdapter(spinnerAdapter);
        //adding setOnItemSelectedListener method on spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = (String) spinner.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?>parent){
            }
        });

        //click button to IncomeActivity
        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (item) {
                    case "Expense":
                        Intent intentExpense = new Intent(AddIncome.this, AddScreens.class);
                        startActivity(intentExpense);
                        Toast.makeText(AddIncome.this, "Record Expense", Toast.LENGTH_SHORT).show();
                    case "Coupon":
                        Intent intentCoupon = new Intent(AddIncome.this, AddCoupon.class);
                        startActivity(intentCoupon);
                        Toast.makeText(AddIncome.this, "Record Coupon", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //click image to InputPage
        img1 = (ImageView)findViewById(R.id.imageView1);
        img1.setClickable(true);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddIncome.this, Input.class);
                inputIntent.putExtra("InputType","Investment");
                startActivity(inputIntent);
            }
        });

        img2 = (ImageView)findViewById(R.id.imageView2);
        img2.setClickable(true);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddIncome.this, Input.class);
                inputIntent.putExtra("InputType","Salary");
                startActivity(inputIntent);
            }
        });

        img3 = (ImageView)findViewById(R.id.imageView3);
        img3.setClickable(true);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputIntent = new Intent(AddIncome.this, Input.class);
                inputIntent.putExtra("InputType","Red Pocket");
                startActivity(inputIntent);
            }
        });
    }
}

