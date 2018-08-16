package com.example.pabitra.sudhahisaba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
EditText mula,sudhahara,dina;
TextView tv2;
Button total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mula=findViewById(R.id.mula);
        sudhahara=findViewById(R.id.sudhahara);
        dina=findViewById(R.id.dina);
        tv2=findViewById(R.id.tv2);
        total=findViewById(R.id.total);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mul=mula.getText().toString();
                String sud=sudhahara.getText().toString();
                String din=dina.getText().toString();

                Double base=Double.parseDouble(mul);
                Double intrest=Double.parseDouble(sud);
                Double day=Double.parseDouble(din);

                Double res1=(base*(intrest/100)*(day));
                Double tot=res1+base;
                String sudhares = Double.toString(res1);
                String result=Double.toString(tot);
                tv2.setText("Total Sudha :"+sudhares+"\n"+"\n"+"Total Mula :"+mul+"\n"+"\n"+"Total Sudha Mula :"+result);

            }
        });



    }
}
