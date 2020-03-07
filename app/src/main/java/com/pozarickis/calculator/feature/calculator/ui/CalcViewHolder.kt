package com.pozarickis.calculator.feature.calculator.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.pozarickis.calculator.R
import com.pozarickis.calculator.feature.calculator.model.CalcButton

class CalcViewHolder(
    itemView: View,
    private val itemListener: CalcAdapter.ItemListener
) : RecyclerView.ViewHolder(itemView) {

    private val titleView = itemView.findViewById<MaterialButton>(R.id.actionButton)

    companion object {
        fun build(
            inflater: LayoutInflater, parent: ViewGroup, itemListener: CalcAdapter.ItemListener
        ): CalcViewHolder {
            val itemView = inflater.inflate(R.layout.activity_calc_li, parent, false)

            return CalcViewHolder(itemView, itemListener)
        }
    }

    fun init(button: CalcButton) {
        itemView.setOnClickListener { itemListener.onItemClicked(button) }

        initTitle(button)
    }

    private fun initTitle(button: CalcButton) {
        val title = when (button) {
            is CalcButton.Number -> button.value.toString()
            is CalcButton.Action -> button.title
        }

        titleView.text = title
    }
}