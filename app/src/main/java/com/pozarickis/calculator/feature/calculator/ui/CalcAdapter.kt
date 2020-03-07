package com.pozarickis.calculator.feature.calculator.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pozarickis.calculator.feature.calculator.model.CalcButton

class CalcAdapter(
    private val itemListener: ItemListener
) : RecyclerView.Adapter<CalcViewHolder>() {

    private val items = mutableListOf<CalcButton>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalcViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CalcViewHolder.build(inflater, parent, itemListener)
    }

    override fun onBindViewHolder(holder: CalcViewHolder, position: Int) {
        holder.init(items[position])
    }

    interface ItemListener {
        fun onItemClicked(button: CalcButton)
    }
}