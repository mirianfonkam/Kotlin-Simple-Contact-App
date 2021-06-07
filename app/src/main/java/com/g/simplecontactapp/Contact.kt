package com.g.simplecontactapp


//base class
open class Contact(open var name: String = "", open var phone_number: String = "") {
}

//derived class
class ProfessionalContact(name: String, phone_number: String, var email: String): Contact(name, phone_number) {
    override fun toString(): String {
        return "- $name $phone_number $email"
    }
}

//derived class
class PersonalContact(name: String, phone_number: String, var relationship_notes: String): Contact(name, phone_number) {
    override fun toString(): String {
        return "- $name $phone_number $relationship_notes"
    }
}