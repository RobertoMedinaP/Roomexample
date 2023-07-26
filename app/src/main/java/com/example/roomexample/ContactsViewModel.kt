package com.example.roomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel


//el viewmodel

class ContactsViewModel(application: Application): AndroidViewModel (application){


    private val repository = ContactsRepository(application)
    val contacts = repository.getContacts()

    fun saveContact(contact: Contact) {
        repository.insert(contact)
    }
}