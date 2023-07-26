package com.example.roomexample

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*IMPORTANTE: este código está basado en uno de los materiales
    entregados, para que funcione hay que migrarlo a Android x
    y actualizar las dependencias*/


    private lateinit var contactsViewModel: ContactsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        contactsViewModel = run {
            ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        }

        binding.addContactButton.setOnClickListener { addContact() }
        addObserver()
    }

    private fun addObserver() {
        val observer = Observer<List<Contact>> { contacts ->
            if (contacts != null) {
                var text = ""
                for (contact in contacts) {
                    text += contact.lastName + " " + contact.firstName + " - " + contact.phoneNumber + "\n"
                }
                binding.contactsTextView.text = text
            }
        }
        contactsViewModel.contacts.observe(this, observer)
    }

    private fun addContact() {

        val phone = binding.phoneEditText.text.toString()
        val name = binding.fistNameEditText.text.toString()
        val lastName =
            if (binding.lastNameEditText.text.toString() != "") binding.lastNameEditText.text.toString()
            else null

        if (name != "" && phone != "") contactsViewModel.saveContact(Contact(phone, name, lastName))
    }

    }
