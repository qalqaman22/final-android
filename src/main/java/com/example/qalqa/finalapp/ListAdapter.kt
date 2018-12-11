package com.example.qalqa.finalapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qalqa.finalapp.Activity.DetailActivity
import com.example.qalqa.finalapp.Model.Contact
import com.example.qalqa.finalapp.Model.Group
import kotlinx.android.synthetic.main.item_contact.view.*
import kotlinx.android.synthetic.main.item_group.view.*

class ListAdapter(var viewType:String, var dataSet:ArrayList<Any>, var context:Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var groupDao = App.database!!.groupDao()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        when(viewType){
            "contactList" -> return ContactViewHolder(LayoutInflater.from(p0.context).
                    inflate(R.layout.item_contact, p0, false))
            else -> return GroupViewHolder(LayoutInflater.from(p0.context).
                    inflate(R.layout.item_group, p0, false))
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        when(p0){
            is ContactViewHolder -> {
                var contacts = dataSet as ArrayList<Contact>
                var groupName = groupDao.getGroupById(contacts[p1].group).name
                p0.itemView.item_contact_name.text = contacts[p1].name
                p0.itemView.item_contact_group_name.text = groupName
                p0.itemView.item_contact_image.setImageResource(contacts[p1].image)
                p0.itemView.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("contactId", contacts[p1].id)
                    context.startActivity(intent)
                }

            }
            else -> {
                var groups = dataSet as ArrayList<Group>
                p0.itemView.item_group_id.text = "ID: " + groups[p1].id.toString()
                p0.itemView.item_group_name.text = "Group name: " + groups[p1].name
                p0.itemView.item_group_priority.text = "Priority: " + groups[p1].priority.toString()
            }
        }
    }

    fun filterList(filteredList:ArrayList<Contact>){
        dataSet = filteredList as ArrayList<Any>
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(view:View):RecyclerView.ViewHolder(view)
    inner class GroupViewHolder(view:View):RecyclerView.ViewHolder(view)
}