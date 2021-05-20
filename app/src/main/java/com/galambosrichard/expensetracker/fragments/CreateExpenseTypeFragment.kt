package com.galambosrichard.expensetracker.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.galambosrichard.expensetracker.models.CreateExpenseTypeViewModel
import com.galambosrichard.expensetracker.R

class CreateExpenseTypeFragment : Fragment() {

    private lateinit var viewModel: CreateExpenseTypeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_expense_type_fragment, container, false)

        viewModel = ViewModelProvider(this).get(CreateExpenseTypeViewModel::class.java)

        return view
    }
}