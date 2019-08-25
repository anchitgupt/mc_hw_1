package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText mEditTextHouse, mEditTextStreet, mEditTextCity;
    private String house, street, city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mEditTextHouse = findViewById(R.id.te_house);
        mEditTextStreet = findViewById(R.id.te_street);
        mEditTextCity = findViewById(R.id.te_city);

        Button mButtonNext = findViewById(R.id.bt_address);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                house = mEditTextHouse.getText().toString().trim();
                street = mEditTextStreet.getText().toString().trim();
                city = mEditTextCity.getText().toString().trim();

                if (house.equals("") || street.equals("") || city.equals(""))
                    Toast.makeText(SecondActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                else
                {
                    startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                }
            }
        });
    }
}
