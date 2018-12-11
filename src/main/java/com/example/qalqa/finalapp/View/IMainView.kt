package com.example.qalqa.finalapp.View

import com.example.qalqa.finalapp.Model.Contact

interface IMainView {
    fun onActivityLoaded(contacts: ArrayList<Contact>)
    fun onContactAdded(contacts: ArrayList<Contact>)
}