package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView mTextViewName;
    private TextView mTextViewRoll;
    private TextView mTextViewHouse;
    private TextView mTextViewStreet;
    private TextView mTextViewCity;
    private TextView mTextViewEmail;
    private Button mButtonShare, mButtonStart;
    private String firstName, lastName, roll, house, street, city, email;

    @SuppressLint("SetTextI18n")
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
        mButtonShare = findViewById(R.id.bt_share);
        mButtonStart = findViewById(R.id.bt_start);

        if (savedInstanceState != null) {
            firstName = savedInstanceState.getString("firstName");
            lastName = savedInstanceState.getString("lastName");
            house = savedInstanceState.getString("house");
            street = savedInstanceState.getString("street");
            street = savedInstanceState.getString("city");
            roll = savedInstanceState.getString("roll");
            city = savedInstanceState.getString("city");
            email = savedInstanceState.getString("email");
        } else {
            firstName = getIntent().getStringExtra("firstName");
            lastName = getIntent().getStringExtra("lastName");
            roll = getIntent().getStringExtra("roll");
            house =  getIntent().getStringExtra("house");
            street = getIntent().getStringExtra("street");
            city = getIntent().getStringExtra("city");
            email = getIntent().getStringExtra("email");
        }

        mTextViewName.setText( firstName +" " + lastName);
        mTextViewRoll.setText(roll);
        mTextViewHouse.setText(house);
        mTextViewStreet.setText(street);
        mTextViewCity.setText(city);
        mTextViewEmail.setText(email);

        mButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String data = "Name: " + firstName + " " + lastName +"\n"
                        +  "RollNo: "+ roll+"\n"+
                        "House: " + house +"\n"+
                        "Street: " + street +"\n"+
                        "City: "+ city+"\n"+
                        "Email: "+ email;
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, data);
                startActivity(Intent.createChooser(intent,getResources().getString(R.string.sharingText)));
            }
        });

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                FinalActivity.this.finish();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("firstName", firstName);
        savedInstanceState.putString("lastName", lastName);
        savedInstanceState.putString("roll", roll);
        savedInstanceState.putString("email", email);
        savedInstanceState.putString("house", house);
        savedInstanceState.putString("street", street);
        savedInstanceState.putString("city", city);
        super.onSaveInstanceState(savedInstanceState);
    }
}
