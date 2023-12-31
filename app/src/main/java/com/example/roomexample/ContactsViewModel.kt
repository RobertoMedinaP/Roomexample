package com.example.roomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel


//el viewmodel, que se comunica con el repositorio

class ContactsViewModel(application: Application): AndroidViewModel (application){


    //instancia del repositorio
    private val repository = ContactsRepository(application)
    val contacts = repository.getContacts()

    fun saveContact(contact: Contact) {
        repository.insert(contact)
    }
}