package com.g.simplecontactapp


//base class
open class Contact(open var name: String = "", open var phone_number: String = "") {
    //a class variable that creates a list all info of the subclasses on Contact
    companion object {
        //Array with all contacts
        var allContacts : MutableList<Contact> = mutableListOf() //the call is Contact.Companion.allContacts

        fun printAllContactsSorted() : String {
            //the called with Contact.Companion.allContactsStr
            //Sorts all contacts and for each contact concatenate, it in a single string jointoString("\n")
            return allContacts.sortedBy {it.name}.joinToString("\n")
        }
    }

}

//derived class
class ProfessionalContact(name: String, phone_number: String, var email: String): Contact(name, phone_number) {
    override fun toString(): String {
        return "- $name $phone_number $email"
    }

    //init is called every time an object is instatiated
    init {
        allContacts.add(this)
    }
}

//derived class
class PersonalContact(name: String, phone_number: String, var relationship_notes: String): Contact(name, phone_number) {
    override fun toString(): String {
        return "- $name $phone_number $relationship_notes"
    }

    //init is called every time an object is instatiated
    init {
        allContacts.add(this)
    }
}