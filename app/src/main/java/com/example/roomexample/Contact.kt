package com.example.roomexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


//La data class será la entidad
@Entity(tableName = Contact.TABLE_NAME)
data class Contact(
    //los nombres de las columnas y sus valores
    @ColumnInfo(name = "phone_number") @NotNull val phoneNumber: String,
    @ColumnInfo(name = "first_name") @NotNull val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String? = null


){
    // para instanciar la tabla
    companion object {
        const val TABLE_NAME = "contact"
    }

    //la llave primaria
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    var contactId: Int = 0
}


