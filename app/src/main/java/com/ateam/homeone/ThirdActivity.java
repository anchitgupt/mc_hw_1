package com.ateam.homeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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

        if (savedInstanceState != null) {
            roll = savedInstanceState.getString("roll");
            email = savedInstanceState.getString("email");
            mEditTextRoll.setText(roll);
            mEditTextEmail.setText(email);
        }

        Button mButton = findViewById(R.id.bt_other);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll = mEditTextRoll.getText().toString().trim();
                email = mEditTextEmail.getText().toString().trim();

                if (roll.equals("")||email.equals("")){
                    Toast.makeText(ThirdActivity.this, "Enter All Details", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mEditTextEmail.setError("Enter Valid Email");
                    Toast.makeText(ThirdActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ThirdActivity.this, FinalActivity.class);
                    intent.putExtra("firstName", getIntent().getStringExtra("firstName"));
                    intent.putExtra("lastName", getIntent().getStringExtra("lastName"));
                    intent.putExtra("house", getIntent().getStringExtra("house"));
                    intent.putExtra("street", getIntent().getStringExtra("street"));
                    intent.putExtra("city", getIntent().getStringExtra("city"));
                    intent.putExtra("email",email);
                    intent.putExtra("roll",roll);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("roll", roll);
        savedInstanceState.putString("email", email);
        super.onSaveInstanceState(savedInstanceState);
    }

}
