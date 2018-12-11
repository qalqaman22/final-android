package com.example.qalqa.finalapp.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Contact(
        @ColumnInfo(name = "name") var name:String,
        @ColumnInfo(name = "mobilePhone") var mobilePhone:String,
        @ColumnInfo(name = "homePhone") var homePhone:String,
        @ColumnInfo(name = "workPhone") var workPhone:String,
        @ColumnInfo(name = "image") var image:Int,
        @ColumnInfo(name = "group") var group:Long) {
    @PrimaryKey(autoGenerate = true) var id:Long ?= null
}