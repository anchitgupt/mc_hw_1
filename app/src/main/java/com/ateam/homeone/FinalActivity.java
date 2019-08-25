package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView mTextViewName, mTextViewRoll, mTextViewHouse, mTextViewStreet, mTextViewCity, mTextViewEmail;
    private String name, roll, house, street, city, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        mTextViewName = findViewById(R.id.e_tv_name);
        mTextViewRoll = findViewById(R.id.e_tv_roll);
        mTextViewHouse = findViewById(R.id.e_tv_house);
        mTextViewStreet = findViewById(R.id.e_tv_street);
        mTextViewCity = findViewById(R.id.e_tv_city);
        mTextViewEmail = findViewById(R.id.e_tv_email);


    }
}
