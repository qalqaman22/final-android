package com.example.qalqa.finalapp.Presenter

import com.example.qalqa.finalapp.App
import com.example.qalqa.finalapp.Model.Contact
import com.example.qalqa.finalapp.View.IMainView

class MainPresenter(internal var iMainView:IMainView):IMainPresenter {

    var contactDao = App.database!!.contactDao()

    override fun onActivityLoad() {
        var contacts = contactDao.getAllContact() as ArrayList<Contact>
        iMainView.onActivityLoaded(contacts)
    }

    override fun onContactAdd() {
        var contacts = contactDao.getAllContact() as ArrayList<Contact>
        iMainView.onContactAdded(contacts)
    }
}