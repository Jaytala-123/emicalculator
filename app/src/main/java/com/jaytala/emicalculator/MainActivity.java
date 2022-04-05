package com.jaytala.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText principal,intreset,time;
    TextView result;
    Button reset,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = findViewById(R.id.principal);
        intreset = findViewById(R.id.intrest);
        time = findViewById(R.id.time);
        result = findViewById(R.id.result);
        reset = findViewById(R.id.reset);
        submit = findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float p = Float.parseFloat(principal.getText().toString());
                float r = Float.parseFloat(intreset.getText().toString());
                float n = Float.parseFloat(time.getText().toString());

                r = r/(12*100);

                float final_r = 1.0f;

                for (int i = 0; i < n*12; i++) {
                    final_r = final_r*(1+r);
                }

                float f_ans = p*r*(final_r/(final_r-1));

                result.setText("Your Payable Amount with Intrest : "+(f_ans+p)+"\n\n"+"Your Intrest : "+f_ans);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principal.setText("");
                intreset.setText("");
                time.setText("");
                result.setText("");
            }
        });

    }
}