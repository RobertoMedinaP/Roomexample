package com.example.roomexample

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context


// Esta clase será la database, debemos poner la anotacion para indicarlo
//indicamos de donde vienen las entidades, en este caso es la clase Contact
//e indicamos la version de la base de datos

@Database(entities = [Contact::class], version = 1)

// la clase de la base de datos siempre debe ser abstracta
//e implementar RoomDatabase()
abstract class ContactsDataBase: RoomDatabase () {

    //funcion para llamar al dao, también abstracta no se porqué
    abstract fun contactDao(): ContactDao

    companion object {
        private const val DATABASE_NAME = "score_database"
        @Volatile
        private var INSTANCE: ContactsDataBase?=null

        fun getInstance(context: Context): ContactsDataBase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsDataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}