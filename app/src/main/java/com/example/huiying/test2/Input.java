package com.example.huiying.test2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Date;


public class Input extends AppCompatActivity implements View.OnClickListener {
    TextView inputType;
    Intent intent;
    Button button_back;
    Button button_save;
    private TextView amountTextView; // shows formatted bill amount
    private TextView noteTextView; // shows entered notes
    TextView pickedDate;
    Button datePicker;

    // currency and string formatter objects
    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    //define database
    SQLiteDatabase db = null;

    //call when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        datePicker = (Button)findViewById(R.id.dateofRecord);
        pickedDate = (TextView) findViewById(R.id.recordDate);
        datePicker.setOnClickListener(this);

        db = openOrCreateDatabase("Details", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS detail" + "(id integer primary key, type VARCHAR, amount VARCHAR, note VARCHAR, date VARCHAR);");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get references to programmatically manipulated TextViews
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        noteTextView = (TextView) findViewById(R.id.noteTextView);

        // set amountEditText's TextWatcher
        final EditText amountEditText =
                (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);

        // set noteEditText's TextWatcher
        final EditText noteEditText =
                (EditText) findViewById(R.id.noteEditText);
        noteEditText.addTextChangedListener(noteEditTextWatcher);

        // get input categories from other screen and display in corresponding textView
        Bundle extras = getIntent().getExtras();
        String type = extras.getString("InputType");
        inputType = (TextView) findViewById(R.id.typeTextView);
        inputType.setText(type);

        // click to get back to scrolling activity
        button_back = (Button) findViewById(R.id.Backbutton);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Input.this, AddScreens.class);
                startActivity(intent);
            }
        });

        // click to save values into database and open XXX activity
        button_save = (Button) findViewById(R.id.SaveButton);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("INSERT INTO Detail(type, amount, note, date) VALUES('" + inputType.getText()
                + "','" + amountEditText.getText() + "','" + noteEditText.getText() + "','" + pickedDate.getText() + "');");

                //Intent intent = new Intent(InputPage.this, [display record].class);
                //startActivity(intent);
                //intent.putExtra("[category]",[value to be stored]);
            }
        });
    }

    // listener object for the amountEditText's text-changed events
    private final TextWatcher amountEditTextWatcher = new TextWatcher() {
        // called when the user modifies the bill amount
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            double inputAmount = 0.0;
            try { // get bill amount and display currency formatted value
                inputAmount = Double.parseDouble(s.toString()) ;
                amountTextView.setText(currencyFormat.format(inputAmount));
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                amountTextView.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    // listener object for the noteEditText's text-changed events
        private final TextWatcher noteEditTextWatcher = new TextWatcher() {
        // called when the user modifies the notes
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            String notes="";
            notes=s.toString();
            noteTextView.setText(notes);
        }
        @Override
        public void afterTextChanged(Editable s) { }
        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    @Override
    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        final int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Date date = new Date(year - 1900, month, dayOfMonth);
                String dateForDB = DateFormat.format("yyyy-MM-dd", date).toString();;
                pickedDate.setText(dateForDB);
            }
        }
        , day, month, year);
        datePickerDialog.show();
    }

}

