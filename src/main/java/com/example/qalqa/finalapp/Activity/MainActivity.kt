package com.example.qalqa.finalapp.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import com.example.qalqa.finalapp.App
import com.example.qalqa.finalapp.ListAdapter
import com.example.qalqa.finalapp.Model.Contact
import com.example.qalqa.finalapp.Model.Group
import com.example.qalqa.finalapp.Presenter.IMainPresenter
import com.example.qalqa.finalapp.Presenter.MainPresenter
import com.example.qalqa.finalapp.R
import com.example.qalqa.finalapp.View.IMainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView {

    lateinit var listAdapter: ListAdapter
    var contactDao = App.database!!.contactDao()

    override fun onActivityLoaded(contacts: ArrayList<Contact>) {
        main_recycler.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter("contactList", contacts as ArrayList<Any>, this)
        main_recycler.adapter = listAdapter

    }

    override fun onContactAdded(contacts: ArrayList<Contact>) {
        listAdapter.dataSet = contacts as ArrayList<Any>
        listAdapter.notifyDataSetChanged()
    }

    lateinit var mainPresenter:IMainPresenter
//    var groupDao = App.database!!.groupDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        groupDao.insertGroup(Group("family",1))
//        groupDao.insertGroup(Group("friends", 2))
//        groupDao.insertGroup(Group("class",3))
//        groupDao.insertGroup(Group("gamers",4))

        mainPresenter = MainPresenter(this)
        mainPresenter.onActivityLoad()

        main_floating_btn.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivityForResult(intent, 22)
        }

        main_edt.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }

    fun filter(filterText:String){
        var contacts = contactDao.getAllContact()
        var filteredList = ArrayList<Contact>()
        for(item in contacts){
            if(item.name.toLowerCase().contains(filterText.toLowerCase())){
                filteredList.add(item)
            }
        }
        if(listAdapter != null){
            listAdapter.filterList(filteredList)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==22 && resultCode==23){
            if(data == null){
                return
            }
            mainPresenter.onContactAdd()
        }
    }

}
