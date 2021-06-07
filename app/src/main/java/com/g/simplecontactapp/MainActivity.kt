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

    //Array with all contacts
    var allContacts : MutableList<Contact> = mutableListOf()

    var typeSelected : Int = 0
    private lateinit var infoContactType : TextInputLayout
    private lateinit var infoIn : TextInputEditText


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

        btnSave.setOnClickListener {
            val name = nameIn.text.toString()
            val phone_number = phoneIn.text.toString()
            val info = infoIn.text.toString()


            if (typeSelected != 0) {
                if (typeSelected == 1) {
                    allContacts.add(ProfessionalContact(name, phone_number, info))
                }

                if (typeSelected == 2) {
                    allContacts.add(PersonalContact(name, phone_number, info))
                }
            }

            Toast.makeText(this,
                (allContacts.last()).toString(),
                Toast.LENGTH_LONG).show()
        }

        btnSearch.setOnClickListener {
            val nameSearched = searchIn.text.toString()

            val result = allContacts.find {
                it.name == nameSearched
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

            //Caso especial pra Radio B(urro)utton
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

    // TO DO: Display Contacts in alphabetical order as a Text View

    //   contacts.sortedBy { it.name }

    // TO DO: Create button "Show all contacts" / modify visibilibity



}