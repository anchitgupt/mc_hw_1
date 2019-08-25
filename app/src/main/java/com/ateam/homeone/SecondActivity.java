package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "DEBUG";
    private EditText mEditTextHouse, mEditTextStreet, mEditTextCity;
    private String house, street, city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mEditTextHouse = findViewById(R.id.te_house);
        mEditTextStreet = findViewById(R.id.te_street);
        mEditTextCity = findViewById(R.id.te_city);

        if (savedInstanceState != null) {
            house = savedInstanceState.getString("house");
            street = savedInstanceState.getString("street");
            street = savedInstanceState.getString("city");
            mEditTextHouse.setText(house);
            mEditTextStreet.setText(street);
            mEditTextCity.setText(city);
        }


        Button mButtonNext = findViewById(R.id.bt_address);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                house  = mEditTextHouse.getText().toString().trim();
                street = mEditTextStreet.getText().toString().trim();
                city   = mEditTextCity.getText().toString().trim();

                if (house.equals("") || street.equals("") || city.equals(""))
                    Toast.makeText(SecondActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                else
                {
                    getIntent().getStringExtra("lastName");
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("firstName", getIntent().getStringExtra("firstName"));
                    intent.putExtra("lastName", getIntent().getStringExtra("lastName"));
                    intent.putExtra("house", house);
                    intent.putExtra("street", street);
                    intent.putExtra("city", city);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("house", house);
        savedInstanceState.putString("street", street);
        savedInstanceState.putString("city", city);
        super.onSaveInstanceState(savedInstanceState);
    }
}

