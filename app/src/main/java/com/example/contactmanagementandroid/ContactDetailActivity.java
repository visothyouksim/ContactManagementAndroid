package com.example.contactmanagementandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        // Récupération des données passées par l'Intent
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        // Mise à jour des TextViews avec les détails du contact
        TextView fullNameTextView = findViewById(R.id.fullName);
        TextView emailTextView = findViewById(R.id.email);
        TextView phoneTextView = findViewById(R.id.phone);
        TextView addressTextView = findViewById(R.id.address);

        fullNameTextView.setText(fullName);
        emailTextView.setText(email);
        phoneTextView.setText(phone);
        addressTextView.setText(address);
    }
}
