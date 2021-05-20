package com.galambosrichard.expensetracker.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.galambosrichard.expensetracker.ExpenseApplication
import com.galambosrichard.expensetracker.R
import com.galambosrichard.expensetracker.adapters.ExpenseListAdapter
import com.galambosrichard.expensetracker.models.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var mAdapter: ExpenseListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        ExpenseApplication.selectedExpense = null

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.getTotal().observe(requireActivity(), {
            if (it == null) {
                view.home_amount.text = "0 Ft"
            } else {
                view.home_amount.text = "$it Ft"
            }
        })

        mAdapter = ExpenseListAdapter(findNavController())

        val recyclerView = view.home_list
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        view.floatingActionButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_createExpenseFragment) }

        return view
    }

    override fun onResume() {
        super.onResume()

        viewModel.getExpenses().observe(requireActivity(), {
            mAdapter.setData(it)
        })
    }
}