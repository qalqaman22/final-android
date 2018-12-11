package com.example.qalqa.finalapp

import android.app.Application
import android.arch.persistence.room.Room
import com.example.qalqa.finalapp.Database.AppDatabase

class App:Application() {

    companion object {
        var database:AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "contactDb").
                allowMainThreadQueries().build()
    }

}