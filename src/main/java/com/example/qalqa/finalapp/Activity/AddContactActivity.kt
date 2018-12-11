package com.example.qalqa.finalapp.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.qalqa.finalapp.ListAdapter
import com.example.qalqa.finalapp.Model.Group
import com.example.qalqa.finalapp.Presenter.AddContactPresenter
import com.example.qalqa.finalapp.Presenter.IAddContactPresenter
import com.example.qalqa.finalapp.R
import com.example.qalqa.finalapp.View.IAddContactView
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity(), IAddContactView {

    lateinit var listAdapter: ListAdapter

    override fun onActivityLoaded(groups: ArrayList<Group>) {
        add_recycler.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter("groupList", groups as ArrayList<Any>, this)
        add_recycler.adapter = listAdapter
    }

    override fun onButtonClicked() {
        val intent = Intent()
        setResult(23, intent)
        finish()
    }

    override fun onButtonError() {
        Toast.makeText(this, "There is empty fields", Toast.LENGTH_LONG).show()
    }

    lateinit var addContactPresenter:IAddContactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        addContactPresenter = AddContactPresenter(this)
        addContactPresenter.onActivityLoad()

        add_btn.setOnClickListener {
            addContactPresenter.onButtonClick(add_name_edt.text.toString(), add_mobilePhone_edt.text.toString(),
                    add_homePhone_edt.text.toString(), add_workPhone_edt.text.toString(), add_group.text.toString())
        }
    }
}
