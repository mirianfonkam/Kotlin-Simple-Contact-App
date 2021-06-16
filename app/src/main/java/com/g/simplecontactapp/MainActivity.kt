package com.g.simplecontactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var typeSelected : Int = 0
    private lateinit var infoContactType : TextInputLayout
    private lateinit var infoIn : TextInputEditText
    private lateinit var contactsOut: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Text Input Fields
        val nameIn = findViewById<TextInputEditText>(R.id.name_in)
        val phoneIn = findViewById<TextInputEditText>(R.id.phonenum_in)
        val searchIn = findViewById<EditText>(R.id.search_in)
        infoIn = findViewById(R.id.info_in)

        //Buttons
        val btnSave = findViewById<Button>(R.id.btn_save)
        val btnSearch = findViewById<ImageButton>(R.id.btn_search)

        //Hint Modification Global
        infoContactType = findViewById(R.id.info_hint)

        //Text Output
        contactsOut = findViewById(R.id.contacts_out)

        btnSave.setOnClickListener {
            val name = nameIn.text.toString()
            val phone_number = phoneIn.text.toString()
            val info = infoIn.text.toString()


            if (typeSelected != 0) {
                if (typeSelected == 1) {
                    ProfessionalContact(name, phone_number, info)
                }

                if (typeSelected == 2) {
                    PersonalContact(name, phone_number, info)
                }
            }

            Toast.makeText(this,
                (Contact.Companion.allContacts.last()).toString(),
                Toast.LENGTH_LONG).show()

            contactsOut.text = (Contact.printAllContactsSorted())

        }

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


    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {

            val btnChecked = view.isChecked

            when (view.id) {
                R.id.cPro ->
                    if (btnChecked) {
                        typeSelected = 1
                        infoContactType.hint = "Email"
                        infoIn.inputType =  InputType.TYPE_CLASS_TEXT
                    }
                R.id.cPersonal -> {
                    if (btnChecked) {
                        typeSelected = 2
                        infoContactType.hint = "Notes"
                    }
                }
            }

        }
    }

    // TO DO: Create button "Show all contacts" / modify visibilibity to hidden
    // Display found contact or return to show all contacts
}