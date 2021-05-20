package com.galambosrichard.expensetracker.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.galambosrichard.expensetracker.data.ExpenseDataBase
import com.galambosrichard.expensetracker.data.entities.Expense
import com.galambosrichard.expensetracker.repositories.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateExpenseViewModel(application: Application): AndroidViewModel(application) {
    private val expenseRepository: ExpenseRepository

    init {
        val expenseDAO = ExpenseDataBase.getDatabase(application).expenseDao()
        expenseRepository = ExpenseRepository(expenseDAO)
    }

    fun insert(title: String, amount: Int, date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRepository.insert(title, amount, date)
        }
    }

    fun update(id: Int, title: String, amount: Int, date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRepository.update(id, title, amount, date)
        }
    }

    fun select(id: Int): LiveData<Expense> {
        return expenseRepository.select(id)
    }
}