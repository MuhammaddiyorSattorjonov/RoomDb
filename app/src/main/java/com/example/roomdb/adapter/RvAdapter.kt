package com.example.roomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.databinding.ItemRvBinding
import com.example.roomdb.models.MyPerson

class RvAdapter(val list:ArrayList<MyPerson>): RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(val itemRvBinding:ItemRvBinding): RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(myPerson: MyPerson,position: Int){
            itemRvBinding.name.text = myPerson.name
            itemRvBinding.number.text = myPerson.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}