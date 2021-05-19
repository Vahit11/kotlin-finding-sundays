package com.vahitkeskin.kotlinfindingsundays

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemDayAdapter(
    private val dateList: ArrayList<String>,
    private val dayList: ArrayList<String>
) : RecyclerView.Adapter<ItemDayAdapter.ItemDayViewHolder>() {

    class ItemDayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemNo: TextView = view.findViewById(R.id.item_no)
        var itemDate: TextView = view.findViewById(R.id.item_date)
        var itemDay: TextView = view.findViewById(R.id.item_day)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDayViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.sunday_item, parent, false)
        return ItemDayViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemDayViewHolder, position: Int) {
        holder.itemNo.text = "${position + 1}"
        holder.itemDate.text = "${dateList[position]}"
        holder.itemDay.text = "${dayList[position]}"
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

}