package com.example.qalqa.finalapp.View

import com.example.qalqa.finalapp.Model.Group

interface IAddContactView {
    fun onActivityLoaded(groups:ArrayList<Group>)
    fun onButtonClicked()
    fun onButtonError()
}