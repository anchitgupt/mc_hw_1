package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "DEBUG";
    private EditText mEditTextFirst, mEditTextLast;
    private String firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextFirst = findViewById(R.id.te_firstName);
        mEditTextLast  = findViewById(R.id.te_lastName);

        Button mButtonNext = findViewById(R.id.bt_name);

        if (savedInstanceState != null) {
            firstName = savedInstanceState.getString("firstName");
            lastName = savedInstanceState.getString("lastName");
            mEditTextLast.setText(lastName);
            mEditTextFirst.setText(firstName);
        }

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = mEditTextFirst.getText().toString().trim();
                lastName  = mEditTextLast.getText().toString().trim();

                if (firstName.equals("") || lastName.equals("")){
                    Toast.makeText(MainActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("firstName", firstName);
                    intent.putExtra("lastName", lastName);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("firstName", firstName);
        savedInstanceState.putString("lastName", lastName);
        super.onSaveInstanceState(savedInstanceState);
    }

}
