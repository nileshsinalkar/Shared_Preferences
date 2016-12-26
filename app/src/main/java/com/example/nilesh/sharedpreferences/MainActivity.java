package com.example.nilesh.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText password;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         name=(EditText)findViewById(R.id.name);
         password=(EditText)findViewById(R.id.password);
        show=(TextView)findViewById(R.id.nileshtext);

    }

    public void saveInfo(View view){
        SharedPreferences sharedPreferences= getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit= sharedPreferences.edit();
        edit.putString("username",name.getText().toString());
        edit.putString("password",password.getText().toString());
        edit.apply();
        Log.d("Tag","saved");
        Toast.makeText(this,"User saved",Toast.LENGTH_SHORT).show();



    }

    public void displayData(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("user_info",Context.MODE_PRIVATE);
        String uname=sharedPreferences.getString("username","");
        String upass=sharedPreferences.getString("password","");
        show.setText(uname + " " + upass);
    }


}
