package com.pozarickis.calculator.feature.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.pozarickis.calculator.R
import com.pozarickis.calculator.feature.calculator.ui.CalcAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        private const val POSITION_ACTION_ROW_ENDING = 3

        private const val COLUMN_COUNT_ACTION_ROW = 3
        private const val COLUMN_COUNT_DEFAULT = 4
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var computationInput: TextInputEditText
    private lateinit var resultView: MaterialTextView
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupUI()
        initObservers()
    }

    private fun setupUI() {
        findViews()

        setupRecycler()
        setupComputationInput()
    }

    private fun initObservers() {
        // TODO: init observer of ViewModel data and init computation and result views
    }

    private fun setupComputationInput() {
        // TODO: setup computation input, text-watcher
    }

    private fun findViews() {
        computationInput = findViewById(R.id.computationInput)
        resultView = findViewById(R.id.resultView)
        recycler = findViewById(R.id.recycler)
    }

    private fun setupRecycler() {
        recycler.let {
            it.adapter = CalcAdapter(viewModel.itemClickListener)
            it.layoutManager = getGridLayoutManager()
        }
    }

    private fun getGridLayoutManager(): GridLayoutManager {
        return GridLayoutManager(this, COLUMN_COUNT_DEFAULT).apply {
            // make first row contain 3 columns for: function, backspace, clear
            // 4 columns for other
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when {
                        position < POSITION_ACTION_ROW_ENDING -> COLUMN_COUNT_ACTION_ROW
                        else -> COLUMN_COUNT_DEFAULT
                    }
                }
            }
        }
    }
}