package com.example.qalqa.finalapp.Presenter

interface IAddContactPresenter {
    fun onActivityLoad()
    fun onButtonClick(name:String,mobilePhone:String,homePhone:String,workPhone:String, group: String)
}