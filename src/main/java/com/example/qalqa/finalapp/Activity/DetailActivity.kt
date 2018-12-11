package com.example.qalqa.finalapp.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.qalqa.finalapp.Presenter.DetailPresenter
import com.example.qalqa.finalapp.Presenter.IDetailPresenter
import com.example.qalqa.finalapp.R
import com.example.qalqa.finalapp.View.IDetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), IDetailView {
    override fun onActivityLoaded(name: String, mobilePhone: String, homePhone: String, workPhone: String, groupName: String, groupPriority: Int) {
        detail_contact_name.text = "Name: " + name
        detail_mobilePhone.text = "Mobile ph: " + mobilePhone
        detail_homePhone.text = "Home ph: " + homePhone
        detail_workPhone.text = "Work ph: " + workPhone
        detail_group_name.text = "Group name: " + groupName
        detail_group_priority.text = "Group priority: " + groupPriority.toString()
    }

    lateinit var detailPresenter:IDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var contactId = intent.getLongExtra("contactId", -1)

        detailPresenter = DetailPresenter(this)
        detailPresenter.onActivityLoad(contactId)
    }
}
