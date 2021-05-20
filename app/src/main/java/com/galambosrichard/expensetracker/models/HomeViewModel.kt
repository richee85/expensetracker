package com.galambosrichard.expensetracker.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.galambosrichard.expensetracker.data.ExpenseDataBase
import com.galambosrichard.expensetracker.data.dto.ExpenseDTO
import com.galambosrichard.expensetracker.repositories.ExpenseRepository

class HomeViewModel(application: Application): AndroidViewModel(application) {
    private val expenseRepository: ExpenseRepository

    init {
        val expenseDAO = ExpenseDataBase.getDatabase(application).expenseDao()
        expenseRepository = ExpenseRepository(expenseDAO)
    }

    fun getExpenses(): LiveData<List<ExpenseDTO>> {
        return expenseRepository.readAllData
    }

    fun getTotal(): LiveData<Int> {
        return expenseRepository.totalAmount
    }
}