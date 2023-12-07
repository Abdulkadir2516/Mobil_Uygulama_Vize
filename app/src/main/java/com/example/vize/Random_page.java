package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Random_page extends AppCompatActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);
        Toast.makeText(this,"Random Sayfası", Toast.LENGTH_SHORT).show();

            EditText adet = findViewById(R.id.adet);
            EditText max = findViewById(R.id.max);
            EditText min = findViewById(R.id.min);
            Button btn = findViewById(R.id.button);
            LinearLayout barlar = findViewById(R.id.barlar);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try
                    {
                        for (int i = 0; i<Integer.valueOf(adet.getText().toString()); i++)
                        {

                            ProgressBar newProgress = new ProgressBar(getBaseContext(), null, android.R.attr.progressBarStyleHorizontal);

                            int maks = Integer.valueOf(max.getText().toString());
                            int minn = Integer.valueOf(min.getText().toString());


                            int minvalue = newRandom(maks-1,minn+1);
                            int maxvalue = newRandom(maks-1,minn+1);

                            int gecici = maxvalue;
                            if(minvalue>maxvalue)
                            {
                                maxvalue = minvalue;
                                minvalue = gecici;
                            }

                            int rnd_sayı = newRandom(maxvalue-1,minvalue+1);

                            newProgress.setMax(maxvalue);
                            newProgress.setProgress(rnd_sayı);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                newProgress.setMin(minvalue);
                            }

                            float a = rnd_sayı - minvalue;
                            float b = maxvalue - minvalue;


                            float s = (a/b) *100;
                            float yuzde = (a/b) * 100 ;
                            Toast.makeText(getBaseContext(), String.valueOf(a/b), Toast.LENGTH_SHORT).show();


                            TextView value = new TextView(getBaseContext());
                            TextView min_value = new TextView(getBaseContext());
                            TextView max_value = new TextView(getBaseContext());



                            String deger = rnd_sayı+ " % "+ yuzde;


                            value.setText(deger);

                            min_value.setText(String.valueOf(minvalue));
                            max_value.setText(String.valueOf(maxvalue));



                            LinearLayout layout1 = new LinearLayout(getBaseContext());
                            layout1.setOrientation(LinearLayout.VERTICAL);
                            layout1.setGravity(Gravity.CENTER);
                            layout1.addView(value);
                            layout1.addView(newProgress);


                            LinearLayout layout2 = new LinearLayout(getBaseContext());
                            layout2.setOrientation(LinearLayout.HORIZONTAL);
                            layout2.setGravity(Gravity.CENTER);
                            layout2.addView(min_value);
                            layout2.addView(layout1);
                            layout2.addView(max_value);

                            barlar.addView(layout2);

                        }









                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        //Toast.makeText(getBaseContext(), String.valueOf(newRandom(50,20)), Toast.LENGTH_LONG).show();

                    }

                }
            });

















    }

    public static int newRandom(int max,int min)
    {
        Random rnd = new Random();
        return rnd.nextInt(max-min + 1) + min;
    }

}