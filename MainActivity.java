package com.example.pabitra.sudhahisaba;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
EditText date1,date2;
TextView tv1;
Button b1;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date1=findViewById(R.id.date1);
        date2=findViewById(R.id.date2);
        tv1=findViewById(R.id.tv1);
        b1=findViewById(R.id.b1);

        date1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender

                final Calendar c = Calendar.getInstance();
                int mYear1 = c.get(Calendar.YEAR); // current year
                try {
                    // c.setTime(new SimpleDateFormat("MMM").parse("july"));
                    int mMonth1 = c.get(Calendar.MONTH);
                    //String mMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
                    int mDay1 = c.get(Calendar.DAY_OF_MONTH); // current day

                    // SimpleDateFormat mMonth = new SimpleDateFormat("MMM");
                    // String Month_name = mMonth.format(c);

                    // date picker dialog
                    datePickerDialog = new DatePickerDialog(MainActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth){
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.set(year, monthOfYear, dayOfMonth);
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    String dateString = format.format(calendar.getTime());
                                    date1.setText(dateString);
                                }
                            }, mYear1, mMonth1, mDay1);
                    datePickerDialog.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//for date2
        date2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear2 = c.get(Calendar.YEAR); // current year

                try {
                    // c.setTime(new SimpleDateFormat("MMM").parse("july"));
                    int mMonth2 = c.get(Calendar.MONTH);
                    //String mMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
                    int mDay2 = c.get(Calendar.DAY_OF_MONTH); // current day

                    // SimpleDateFormat mMonth = new SimpleDateFormat("MMM");
                    // String Month_name = mMonth.format(c);

                    // date picker dialog
                    datePickerDialog = new DatePickerDialog(MainActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth){
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.set(year, monthOfYear, dayOfMonth);
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    String dateString = format.format(calendar.getTime());
                                    date2.setText(dateString);
                                }
                            }, mYear2, mMonth2, mDay2);
                    datePickerDialog.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    //Dates to compare
                    String CurrentDate=  date1.getText().toString();
                    String FinalDate=  date2.getText().toString();

                    Date fdate;
                    Date ldate;

                    SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd");

                    //Setting dates
                    fdate = dates.parse(CurrentDate);
                    ldate = dates.parse(FinalDate);

                    //Comparing dates
                    long difference = Math.abs(fdate.getTime() - ldate.getTime());
                    long differenceDates = difference / (24 * 60 * 60 * 1000);

                    long monthdiff=differenceDates/30;
                    //Convert long to String

                    String dayDifference = Long.toString(monthdiff);

                    Log.e("HERE","HERE: " + dayDifference);

                    tv1.setText(dayDifference+"  "+"months");
                } catch (Exception exception) {
                    Log.e("DIDN'T WORK", "exception " + exception);
                }



            }
        });

    }
    public void sudha(View v)
    {
        Intent i=new Intent(this,Welcome.class);
        startActivity(i);
    }



}
