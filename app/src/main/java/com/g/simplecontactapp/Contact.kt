package com.g.simplecontactapp

//base class
open class Contact(open var name: String = "", open var phoneNumber: String = "", open var additionalInfo: String) {
    //a class variable that creates a list all info of the subclasses on Contact
    companion object {
        //Array with all contacts
        var allContacts : MutableList<Contact> = mutableListOf() //the call is Contact.Companion.allContacts
//        fun printAllContactsSorted() : String {
//            //the called with Contact.Companion.allContactsStr
//            //Sorts all contacts and for each contact concatenate, it in a single string joinToString("\n")
//            return allContacts.sortedBy {it.name}.joinToString("\n")
//        }
    }
    //init is called every time an object is instantiated
    init {
        allContacts.add(this)
    }
}