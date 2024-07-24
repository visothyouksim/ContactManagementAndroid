package com.example.contactmanagementandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, phoneEditText, addressEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        saveButton = findViewById(R.id.saveButton);

        firstNameEditText.setText(firstName);
        lastNameEditText.setText(lastName);
        emailEditText.setText(email);
        phoneEditText.setText(phone);
        addressEditText.setText(address);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
