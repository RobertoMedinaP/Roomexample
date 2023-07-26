package com.example.roomexample

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


//la clase del repositorio
class ContactsRepository(application: Application) {

    //instancia del dao
    private val contactDao: ContactDao? = ContactsDataBase.getInstance(application)?.contactDao()

    fun insert(contact: Contact) {
        if (contactDao != null) InsertAsyncTask(contactDao).execute(contact)
    }

    fun getContacts(): LiveData<List<Contact>> {
        return contactDao?.getOrderedAgenda() ?: MutableLiveData<List<Contact>>()
    }

    private class InsertAsyncTask(private val contactDao: ContactDao) :
        AsyncTask<Contact, Void, Void>() {
        override fun doInBackground(vararg contacts: Contact?): Void? {
            for (contact in contacts) {
                if (contact != null) contactDao.insert(contact)
            }
            return null
        }

    }



}