package com.galambosrichard.expensetracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.galambosrichard.expensetracker.ExpenseApplication
import kotlinx.android.synthetic.main.expense_list_item.view.*
import com.galambosrichard.expensetracker.R
import com.galambosrichard.expensetracker.data.dto.ExpenseDTO

class ExpenseListAdapter(private val navController: NavController): RecyclerView.Adapter<ExpenseListAdapter.MyViewHolder>() {

    private var list = mutableListOf<ExpenseDTO>()

    class MyViewHolder(unitView: View) : RecyclerView.ViewHolder(unitView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.expense_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]

        holder.itemView.title.text = currentItem.title
        holder.itemView.amount.text = "${currentItem.amount} Ft"
        holder.itemView.date.text = currentItem.date

        holder.itemView.setOnClickListener {
            ExpenseApplication.selectedExpense = currentItem.id
            navController.navigate(R.id.action_homeFragment_to_createExpenseFragment)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(input: List<ExpenseDTO>) {
        list.clear()
        list.addAll(input)
        notifyDataSetChanged()
    }

}