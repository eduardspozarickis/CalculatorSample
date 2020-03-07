package com.pozarickis.calculator.feature.calculator

import androidx.lifecycle.ViewModel
import com.pozarickis.calculator.feature.calculator.model.CalcButton
import com.pozarickis.calculator.feature.calculator.ui.CalcAdapter

class MainViewModel : ViewModel() {

    init {
        initialize()
    }

    private fun initialize() {
        // TODO: initialize list of buttons to provide to the UI
    }

    private fun executeAction(button: CalcButton.Action) {
        // TODO: react depending on action
    }

    private fun computeResult(value: Int) {
        // TODO: compute and persist new result and give command to update UI
    }

    val itemClickListener = object : CalcAdapter.ItemListener {
        override fun onItemClicked(button: CalcButton) {
            when (button) {
                is CalcButton.Number -> computeResult(button.value)
                is CalcButton.Action -> executeAction(button)
            }
        }
    }
}