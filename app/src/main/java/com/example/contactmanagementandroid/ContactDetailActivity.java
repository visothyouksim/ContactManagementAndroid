package com.example.contactmanagementandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        TextView fullNameTextView = findViewById(R.id.fullName);
        TextView emailTextView = findViewById(R.id.email);
        TextView phoneTextView = findViewById(R.id.phone);
        TextView addressTextView = findViewById(R.id.address);

        fullNameTextView.setText(fullName);
        emailTextView.setText(email);
        phoneTextView.setText(phone);
        addressTextView.setText(address);

        Button editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(ContactDetailActivity.this, EditContactActivity.class);
                editIntent.putExtra("firstName", fullName.split(" ")[0]); // Si le prénom est en premier
                editIntent.putExtra("lastName", fullName.split(" ")[1]);  // Si le nom est en deuxième
                editIntent.putExtra("email", email);
                editIntent.putExtra("phone", phone);
                editIntent.putExtra("address", address);
                startActivity(editIntent);
            }
        });
    }
}
