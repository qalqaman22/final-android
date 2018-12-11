package com.example.qalqa.finalapp.View

interface IDetailView {
    fun onActivityLoaded(name:String, mobilePhone:String, homePhone:String,
                         workPhone:String, groupName:String, groupPriority:Int)
}