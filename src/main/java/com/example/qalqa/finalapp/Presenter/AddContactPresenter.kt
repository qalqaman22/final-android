package com.example.qalqa.finalapp.Presenter

import com.example.qalqa.finalapp.App
import com.example.qalqa.finalapp.Model.Contact
import com.example.qalqa.finalapp.Model.Group
import com.example.qalqa.finalapp.R
import com.example.qalqa.finalapp.View.IAddContactView

class AddContactPresenter(internal var iAddContactView:IAddContactView):IAddContactPresenter {

    var groupDao = App.database!!.groupDao()
    var contactDao = App.database!!.contactDao()

    override fun onActivityLoad() {
        var groups = groupDao.getAllGroup() as ArrayList<Group>
        iAddContactView.onActivityLoaded(groups)
    }

    override fun onButtonClick(name: String, mobilePhone: String, homePhone: String, workPhone: String, group: String) {
        if(name!="" && mobilePhone!="" && homePhone!="" && workPhone!="" && group!="") {
            var groupLong = group.toLong()
            var contact = Contact(name, mobilePhone, homePhone, workPhone, R.drawable.ic_account_box_black_24dp, groupLong)
            contactDao.insertContact(contact)
            iAddContactView.onButtonClicked()
        } else {
            iAddContactView.onButtonError()
        }
    }

}