package com.g.simplecontactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContactListActivity : AppCompatActivity() {
    private lateinit var contactsOut: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_list)

        val btnSearch = findViewById<ImageButton>(R.id.btn_search)
        val searchIn = findViewById<EditText>(R.id.search_in)
        val fabPrevious = findViewById<FloatingActionButton>(R.id.fabPrevious)

        //Text Output
        contactsOut = findViewById(R.id.contacts_out)
        contactsOut.text = (Contact.printAllContactsSorted())

        btnSearch.setOnClickListener {
            val nameSearched = searchIn.text.toString()

            val result =  Contact.Companion.allContacts.find {
                (it.name).contains(nameSearched)
            }

            if (result != null) {
                Toast.makeText(this,
                    result.toString(),
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,
                    "Não foi possível encontrar esse contato",
                    Toast.LENGTH_SHORT).show()
            }
        }

        fabPrevious.setOnClickListener {
            //analogy: the email address of the destination
            val intent = Intent(this, MainActivity::class.java)

            //send the email
            startActivity(intent)
        }


    }
}