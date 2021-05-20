package com.galambosrichard.expensetracker.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.galambosrichard.expensetracker.ExpenseApplication
import com.galambosrichard.expensetracker.R
import com.galambosrichard.expensetracker.data.entities.Expense
import com.galambosrichard.expensetracker.models.CreateExpenseViewModel
import kotlinx.android.synthetic.main. create_expense_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class CreateExpenseFragment : Fragment() {

    private lateinit var viewModel: CreateExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_expense_fragment, container, false)

        viewModel = ViewModelProvider(this).get(CreateExpenseViewModel::class.java)

        if (ExpenseApplication.selectedExpense != null) {
            viewModel.select(ExpenseApplication.selectedExpense!!).observe(requireActivity(), {
                view.edit_text_title.setText(it.title)
                view.edit_text_amount.setText(it.amount.toString())
                view.text_date.text = it.date
            })
        } else {
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val dateString = dateFormat.format(calendar.time)
            view.text_date.text = dateString
        }

        view.button.setOnClickListener {
            if (ExpenseApplication.selectedExpense != null) {
                val id = ExpenseApplication.selectedExpense!!
                val title = view.edit_text_title.text.toString()
                val amount = view.edit_text_amount.text.toString().toInt()
                val date = view.text_date.text.toString()
                update(id, title, amount, date)
            } else {
                val title = view.edit_text_title.text.toString()
                val amount = view.edit_text_amount.text.toString().toInt()
                val date = view.text_date.text.toString()
                insert(title, amount, date)
            }
        }

        return view
    }

    private fun insert(title: String, amount: Int, date: String) {
        viewModel.insert(title, amount, date)
        findNavController().navigate(R.id.action_createExpenseFragment_to_homeFragment)
    }

    private fun update(id: Int, title: String, amount: Int, date: String) {
        viewModel.update(id, title, amount, date)
        findNavController().navigate(R.id.action_createExpenseFragment_to_homeFragment)
    }
}