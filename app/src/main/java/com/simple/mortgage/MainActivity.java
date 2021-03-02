package com.simple.mortgage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //EditText ToplamKredi,OnOdeme,ToplamVade,YillikFaiz;
    //TextView AylikOdeme;
    //Button calculate;
    //int Hkredi,Honodeme,Htoplamsure,Hfaizorani,HaylikOdeme;

    EditText ToplamKredi;
    TextView Odeme, AylikOdeme, test_textview;
    Button calculate;
    SeekBar seekbar;
Spinner spinnertime;

    double mortgage_time_monthly, mortgage_interest,
            mortgage_payment;
    int mortgage_total;

    DecimalFormat currency = new DecimalFormat("$ ###,###,###.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  ToplamKredi=(EditText) findViewById(R.id.ToplamKredi);
        //  OnOdeme=(EditText) findViewById(R.id.OnOdeme);
        //  ToplamVade=(EditText) findViewById(R.id.ToplamVade);
        //  YillikFaiz=(EditText) findViewById(R.id.YıllıkFaiz);


        ToplamKredi = (EditText) findViewById(R.id.ToplamKredi);
        // Odeme=(TextView) findViewById(R.id.odeme);
        calculate = (Button) findViewById(R.id.calculate);
        AylikOdeme = (TextView) findViewById(R.id.AylıkOdeme);
        seekbar = (SeekBar) findViewById(R.id.seek_bar);
        test_textview = (TextView) findViewById(R.id.test_textview);

        mortgage_total = 0;
        mortgage_time_monthly = 0;
        mortgage_interest = 0;

        spinnertime=findViewById(R.id.spinnertime);
        DetermineTime();






        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ToplamKredi.setText(currency.format(progress) + "");
                mortgage_total = progress;
                Calculation();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculation();


            }
        });

    }

    private void DetermineTime() {
        ArrayAdapter<String> timeAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.time));
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertime.setAdapter(timeAdapter);

    }

    public void Calculation() {
        double mortgage_interest_monthly;
        double uslusayi;
        int mortgage_payment_int;

        String time=spinnertime.getSelectedItem().toString();
        Toast.makeText(MainActivity.this,time,Toast.LENGTH_SHORT).show();

        mortgage_interest_monthly = mortgage_interest / 12 / 100;
        uslusayi = Math.pow((1 + (mortgage_interest_monthly)), mortgage_time_monthly);

        mortgage_payment = (mortgage_total * mortgage_interest_monthly * uslusayi) / (uslusayi - 1);
        mortgage_payment_int = (int) (mortgage_payment);

        AylikOdeme.setText("aylık odeme : " + currency.format(mortgage_payment_int));


    }


}