package com.example.qalqa.finalapp.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.qalqa.finalapp.Model.Contact
import com.example.qalqa.finalapp.Model.Group

@Database(entities = [Contact::class, Group::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun contactDao():ContactDao
    abstract fun groupDao():GroupDao
}