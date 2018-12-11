package com.example.qalqa.finalapp.Database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.qalqa.finalapp.Model.Contact

@Dao
interface ContactDao {

    @Query("select * from Contact")
    fun getAllContact():List<Contact>

    @Query("select * from Contact where id = :id")
    fun getContactById(id:Long):Contact

    @Insert
    fun insertContact(contact:Contact)

}