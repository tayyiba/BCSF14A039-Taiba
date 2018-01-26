package com.example.awais.spendo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by awais on 7/25/2017.
 */

public class AddExpense extends AppCompatActivity {

    String categoryName = "";
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        et = (EditText) findViewById(R.id.editTextAmount);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                categoryName = adapterView.getItemAtPosition(pos).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final MyDatabaseHandler db = new MyDatabaseHandler(this);

        Button btnAdd = (Button) findViewById(R.id.btnAddExp);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = et.getText().toString();
                int amt = Integer.parseInt(amount);

                if(categoryName.equals("Food")){
                    Log.d("tag", "food k ander ");
                    Expense exp = new Expense(amt,1);
                    long i = db.addExpense(exp);
                    if(i>0){
                        Toast.makeText(getApplicationContext(),"Expense Added",Toast.LENGTH_SHORT).show();
                    }
                }else if(categoryName.equals("Bills")){
                    Expense exp = new Expense(amt,2);
                    long i = db.addExpense(exp);
                    if(i>0){
                        Toast.makeText(getApplicationContext(),"Expense Added",Toast.LENGTH_SHORT).show();
                    }
                }else if(categoryName.equals("Shopping")){
                    Expense exp = new Expense(amt,3);
                    long i = db.addExpense(exp);
                    if(i>0){
                        Toast.makeText(getApplicationContext(),"Expense Added",Toast.LENGTH_SHORT).show();
                    }
                }else if(categoryName.equals("Transportation")){
                    Expense exp = new Expense(amt,4);
                    long i = db.addExpense(exp);
                    if(i>0){
                        Toast.makeText(getApplicationContext(),"Expense Added",Toast.LENGTH_SHORT).show();
                    }
                }
                finish();
                Intent i = new Intent(AddExpense.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
