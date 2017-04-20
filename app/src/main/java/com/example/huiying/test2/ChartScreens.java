package com.example.huiying.test2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;



public class ChartScreens extends AppCompatActivity {

    private static String TAG = "ChartScreens";

    private List<Float> expense = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();
    private TextView[] amountViews = new TextView[9];
    private String[] cateID = {
            "eatAmount","educationAmount","clothesAmount","travelAmount",
            "socialAmount","healthAmount","transportAmount","homeAmount","mobileAmount"};
    PieChart pieChart;
    SQLiteDatabase db;
    private String totalExp;

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_screens);
        Log.d(TAG,"OnCreate: starting to create a chart ");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = openOrCreateDatabase("Details", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS detail" + "(id integer primary key, type VARCHAR, amount VARCHAR);");

        pieChart = (PieChart) findViewById(R.id.idPieChart);

        //find textView
        int temp;
        for (int i=0; i<cateID.length; i++){
            temp = getResources().getIdentifier(cateID[i], "id", getPackageName());
            amountViews[i] = (TextView)findViewById(temp);
        }

        //Properties of the chart
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(30f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Total Expense");
        pieChart.setCenterTextSize(10);
        pieChart.getDescription().setText(" ");

        //Get total Expense
        Cursor cTotal = db.rawQuery("SELECT SUM (amount) as TotalExpenses FROM detail",null);
        int totalExpColumn = cTotal.getColumnIndex("TotalExpenses");
        cTotal.moveToFirst();
        do{
            totalExp = cTotal.getString(totalExpColumn);
        } while (cTotal.moveToNext());
        pieChart.setCenterText("Total Expense\n" + "$"+ totalExp);

        //Get category array from database
        Cursor c = db.rawQuery("SELECT distinct type FROM detail", null);
        int typeColumn = c.getColumnIndex("type");
        c.moveToFirst();
        String type;

        do {
            type = c.getString(typeColumn);
            if (!type.equals("Investment") && !type.equals("Salary") && !type.equals("Pocket Money")) {
                typeList.add(type);
            }
        } while (c.moveToNext());

        for(int i = 0; i < typeList.size(); i++)
        {
            Cursor cExpense = db.rawQuery(
                    "SELECT SUM (amount) as Total FROM detail where type = '" + typeList.get(i) + "'", null);
            int totalColumn = cExpense.getColumnIndex("Total");
            cExpense.moveToFirst();
            String total;
            do{
                total = cExpense.getString(totalColumn);
            } while (cExpense.moveToNext());
            expense.add(Float.parseFloat(total));
        }

        /*
       Cursor cTotal = db.rawQuery(
                "SELECT SUM (amount) as TotalExpense FROM detail", null);
        int totalExpColumn = cTotal.getColumnIndex("TotalExpense");
        cTotal.moveToFirst();
        do{
            totalExp = cTotal.getString(totalExpColumn);
        } while (cTotal.moveToNext());
        pieChart.setCenterText("Total Expense\n"+"$"+totalExp);
        */
        addDataSet();
        addTextView();
    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> expenseEntry = new ArrayList<>();
        ArrayList<String> cateEntry = new ArrayList<>();

        for (int i = 0; i < expense.size(); i++) {
            expenseEntry.add(new PieEntry(expense.get(i), typeList.get(i)));
        }

        /*
        for (int i = 1; i<category.length;i++){
            cateEntry.add(category[i]);
        }
        */

        //Create the data set
        PieDataSet pieDataSet = new PieDataSet(expenseEntry,"Amount Input");
        pieDataSet.setValueTextSize(12);


        /*//Add colors to data set
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(R.color.dining);
        colors.add(R.color.transport);
        colors.add(R.color.cloth);
        colors.add(R.color.study);*/

        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        //Add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        legend.setTextSize(10);


        //Create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

        private void addTextView(){
            for(int i = 0; i<typeList.size(); i++){
                if (typeList.get(i).equals("Food&Drinks")){
                    amountViews[0].setText(currencyFormat.format(expense.get(i)));
                }
                else if (typeList.get(i).equals("Education")){
                    amountViews[1].setText(currencyFormat.format(expense.get(i)));
                }
                else if (typeList.get(i).equals("Shopping")){
                    amountViews[2].setText(currencyFormat.format(expense.get(i)));
                }
                else if (typeList.get(i).equals("Travel")){
                    amountViews[3].setText(currencyFormat.format(expense.get(i)));
                }
                else if (typeList.get(i).equals("Social")){
                    amountViews[4].setText(currencyFormat.format(expense.get(i)).toString());
                }
                else if (typeList.get(i).equals("Health")){
                    amountViews[5].setText(currencyFormat.format(expense.get(i)).toString());
                }
                else if (typeList.get(i).equals("Transportation")){
                    amountViews[6].setText(currencyFormat.format(expense.get(i)).toString());
                }
                else if (typeList.get(i).equals("Home")){
                    amountViews[7].setText(currencyFormat.format(expense.get(i)).toString());
                }
                else if (typeList.get(i).equals("Mobile Phone")){
                    amountViews[8].setText(currencyFormat.format(expense.get(i)).toString());
                }
            }
        }
}

