package com.example.qalqa.finalapp.Presenter

import com.example.qalqa.finalapp.App
import com.example.qalqa.finalapp.View.IDetailView

class DetailPresenter(internal var iDetailView:IDetailView):IDetailPresenter {

    var contactDao = App.database!!.contactDao()
    var groupDao = App.database!!.groupDao()

    override fun onActivityLoad(contactId: Long) {
        var contact = contactDao.getContactById(contactId)
        var group = groupDao.getGroupById(contact.group)
        iDetailView.onActivityLoaded(contact.name, contact.mobilePhone, contact.homePhone,
                contact.workPhone, group.name, group.priority)
    }
}