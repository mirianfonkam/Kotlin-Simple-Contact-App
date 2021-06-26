package com.g.simplecontactapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
/*
 * The Adapter Class is the link btw the dataset and the viewholder
 */
class ContactRecyclerAdapter(val context: Context, var dataSet: MutableList<Contact>) : RecyclerView.Adapter<ContactRecyclerAdapter.ContactViewHolder>(){
    // ViewHolder Class : link btw xml attributes and code
    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cName = view.findViewById<TextView>(R.id.tvContactName)
        val cPhoneNumber = view.findViewById<TextView>(R.id.tvPhoneNumber)
        val cNotes = view.findViewById<TextView>(R.id.tvNotes)
    }
    //creates new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_contact_list_item, parent, false)
        return ContactViewHolder(view)
    }
    // binds the list items to a view
    //Replaces items in the layout with items in the dataset
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.cName.text = dataSet[position].name
        holder.cPhoneNumber.text = dataSet[position].phoneNumber
        holder.cNotes.text = dataSet[position].additionalInfo
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "O item está na posicao $position", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return dataSet.size
    }
}
