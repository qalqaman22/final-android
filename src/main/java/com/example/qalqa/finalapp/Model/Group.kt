package com.example.qalqa.finalapp.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Group(
        @ColumnInfo(name = "name") var name:String,
        @ColumnInfo(name = "priority") var priority:Int) {
    @PrimaryKey(autoGenerate = true) var id:Long? = null
}