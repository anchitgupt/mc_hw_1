package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextFirst, mEditTextLast;
    private String firstName, lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextFirst = findViewById(R.id.te_firstName);
        mEditTextLast  = findViewById(R.id.te_lastName);

        Button mButtonNext = findViewById(R.id.bt_name);


        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = mEditTextFirst.getText().toString().trim();
                lastName  = mEditTextLast.getText().toString().trim();

                if (firstName.equals("") || lastName.equals("")){
                    Toast.makeText(MainActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
            }
        });
    }
}
