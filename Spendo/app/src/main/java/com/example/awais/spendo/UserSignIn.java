package com.example.awais.spendo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by awais on 7/25/2017.
 */

public class UserSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signin);

        final HashMap<String,String> values = new HashMap<>();
    //    final webApiService api = new webApiService();

        EditText ed1 = (EditText) findViewById(R.id.email);
        EditText ed2 = (EditText) findViewById(R.id.password);

        final String email = ed1.getText().toString();
        final String passw = ed2.getText().toString();

        Button btn = (Button) findViewById(R.id.Signin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                values.put("Email",email);
                values.put("Password",passw);
              //  api.performPostCall("http://localhost/logon/Login",values);
            }
        });
    }


}
