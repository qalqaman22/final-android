package com.example.qalqa.finalapp.Database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.qalqa.finalapp.Model.Group

@Dao
interface GroupDao {

    @Query("select * from `Group`")
    fun getAllGroup():List<Group>

    @Query("select * from `Group` where id = :id")
    fun getGroupById(id:Long):Group

    @Insert
    fun insertGroup(group: Group)

}