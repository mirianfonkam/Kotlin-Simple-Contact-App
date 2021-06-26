package com.g.simplecontactapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var infoContactType : TextInputLayout
    private lateinit var infoIn : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_registration)
        //Text Input Fields
        val nameIn = findViewById<TextInputEditText>(R.id.etName)
        val phoneIn = findViewById<TextInputEditText>(R.id.etPhoneNum)
        infoIn = findViewById(R.id.etContactInfo)
        //Buttons
        val btnSave = findViewById<Button>(R.id.btnSave)
        val fabNext = findViewById<FloatingActionButton>(R.id.fabNext)
        //Hint Modification Global
        infoContactType = findViewById(R.id.layoutEtContactInfo)
        fabNext.setOnClickListener {
            //analogy: the email address of the destination
            val intent = Intent(this, ContactListActivity::class.java)
            //send the email
            startActivity(intent)
        }
        btnSave.setOnClickListener {
            val name = nameIn.text.toString()
            val phoneNumber = phoneIn.text.toString()
            val additionalInfo = infoIn.text.toString()
            Contact(name, phoneNumber, additionalInfo)
            Toast.makeText(this,
                (Contact.Companion.allContacts.last()).toString(),
                Toast.LENGTH_LONG).show()
        }
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val btnChecked = view.isChecked
            when (view.id) {
                R.id.rbProType ->
                    if (btnChecked) {
                        infoContactType.hint = "Email"
                        infoIn.inputType =  InputType.TYPE_CLASS_TEXT
                    }
                R.id.rbPersonalType -> {
                    if (btnChecked) {
                        infoContactType.hint = "Notes"
                    }
                }
            }
        }
    }
    // TO DO: Create button "Show all contacts" / modify visibilibity to hidden
    // Display found contact or return to show all contacts
}
