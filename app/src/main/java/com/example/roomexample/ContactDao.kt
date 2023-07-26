package com.example.roomexample


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.lifecycle.LiveData

//el dao siempre es una interfaz, debemos poner la anotacion @Dao para indicar que es el dao

@Dao
interface ContactDao {

    //en el dao van todas las consultas

    @Insert
    fun insert(contact: Contact)

    @Update
    fun update(vararg contact: Contact)

    @Delete
    fun delete(vararg contact: Contact)

    @Query("SELECT * FROM " + Contact.TABLE_NAME + " ORDER BY last_name, first_name")
    fun getOrderedAgenda(): LiveData<List<Contact>>
}

