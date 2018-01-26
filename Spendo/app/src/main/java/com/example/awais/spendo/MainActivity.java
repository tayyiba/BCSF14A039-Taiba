package com.example.awais.spendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnExp;
    TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.cart1txt);
        tv2 = (TextView) findViewById(R.id.cart2txt);
        tv3 = (TextView) findViewById(R.id.cart3txt);
        tv4 = (TextView) findViewById(R.id.cart4txt);
        tv5 = (TextView) findViewById(R.id.txtAmountMain);

        final MyDatabaseHandler db = new MyDatabaseHandler(this);

        int sum1 = db.getSumOfCategory(1);
        int sum2 = db.getSumOfCategory(2);
        int sum3 = db.getSumOfCategory(3);
        int sum4 = db.getSumOfCategory(4);

        int totalAmount = sum1 + sum2 + sum3 + sum4;
        tv5.setText(String.valueOf(totalAmount));

        tv1.setText(String.valueOf(sum1));
        tv2.setText(String.valueOf(sum2));
        tv3.setText(String.valueOf(sum3));
        tv4.setText(String.valueOf(sum4));

        btnExp = (Button) findViewById(R.id.btnExp);

        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent i = new Intent(MainActivity.this, AddExpense.class);
                startActivity(i);
            }
        });
    }
}

