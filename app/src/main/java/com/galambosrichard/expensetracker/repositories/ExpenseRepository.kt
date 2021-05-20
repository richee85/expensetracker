package com.galambosrichard.expensetracker.repositories

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.galambosrichard.expensetracker.data.dao.ExpenseDAO
import com.galambosrichard.expensetracker.data.dto.ExpenseDTO
import com.galambosrichard.expensetracker.data.entities.Expense

class ExpenseRepository(private val dao: ExpenseDAO) {
    val readAllData: LiveData<List<ExpenseDTO>> = dao.readAllData()
    val count: LiveData<Int> = dao.getCount()
    val totalAmount: LiveData<Int> = dao.totalAmount()

    @SuppressLint("SimpleDateFormat")
    fun insert(title: String, amount: Int, date: String) {
        dao.insert(Expense(null, title, amount, date))
    }

    fun update(id: Int, title: String, amount: Int, date: String) {
        dao.update(Expense(id, title, amount, date))
    }

    fun select(id: Int): LiveData<Expense> {
        return dao.select(id)
    }
}