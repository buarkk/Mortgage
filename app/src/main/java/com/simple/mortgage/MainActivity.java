package com.simple.mortgage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //EditText ToplamKredi,OnOdeme,ToplamVade,YillikFaiz;
    //TextView AylikOdeme;
    //Button calculate;
    //int Hkredi,Honodeme,Htoplamsure,Hfaizorani,HaylikOdeme;

    EditText ToplamKredi;
    TextView Odeme;
    Button calculate;

    int toplampara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  ToplamKredi=(EditText) findViewById(R.id.ToplamKredi);
      //  OnOdeme=(EditText) findViewById(R.id.OnOdeme);
      //  ToplamVade=(EditText) findViewById(R.id.ToplamVade);
        //  YillikFaiz=(EditText) findViewById(R.id.YıllıkFaiz);
        //AylikOdeme=(TextView) findViewById(R.id.AylıkOdeme);
        //calculate=(Button) findViewById(R.id.calculate);




        ToplamKredi=(EditText) findViewById(R.id.ToplamKredi);
        Odeme=(TextView) findViewById(R.id.AylıkOdeme);
        calculate=(Button) findViewById(R.id.calculate);



calculate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        toplampara = Integer.parseInt(ToplamKredi.getText().toString());
        Odeme.setText(Integer.toString(toplampara));

    }
});

        //  calculate.setOnClickListener(new View.OnClickListener() {
         //   @Override
                    //  public void onClick(View view) {
                    //Hkredi=Integer.parseInt(ToplamKredi.getText().toString());
                    //      Honodeme=Integer.parseInt(OnOdeme.getText().toString());
        //      Htoplamsure=Integer.parseInt(ToplamVade.getText().toString());
        //Hfaizorani=Integer.parseInt(YillikFaiz.getText().toString());

                    //HaylikOdeme=Hkredi+Honodeme;

        //AylikOdeme.setText(Integer.toString(HaylikOdeme));




        //   }
        //});
        //}
          }
 }