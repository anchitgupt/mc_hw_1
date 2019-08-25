package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private EditText mEditTextRoll, mEditTextEmail;
    private String roll, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mEditTextEmail = findViewById(R.id.te_email);
        mEditTextRoll = findViewById(R.id.te_roll);

        Button mButton = findViewById(R.id.bt_other);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll = mEditTextRoll.getText().toString().trim();
                email = mEditTextEmail.getText().toString().trim();

                if (roll.equals("")||email.equals("")){
                    Toast.makeText(ThirdActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ThirdActivity.this, FinalActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
