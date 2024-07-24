package com.example.contactmanagementandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter: ContactAdapter
    private val contactList = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameEditText = findViewById<EditText>(R.id.firstName)
        val lastNameEditText = findViewById<EditText>(R.id.lastName)
        val emailEditText = findViewById<EditText>(R.id.email)
        val phoneEditText = findViewById<EditText>(R.id.phone)
        val addressEditText = findViewById<EditText>(R.id.address)
        val addButton = findViewById<Button>(R.id.addButton)
Vi
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        contactAdapter = ContactAdapter(contactList)
        recyclerView.adapter = contactAdapter

        addButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                val contact = Contact(firstName, lastName, email, phone, address)
                contactList.add(contact)
                contactAdapter.notifyDataSetChanged()
            }
        }
    }
}