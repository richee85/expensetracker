package com.galambosrichard.expensetracker.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.galambosrichard.expensetracker.data.ExpenseDataBase
import com.galambosrichard.expensetracker.repositories.ExpenseRepository

class CreateExpenseTypeViewModel(application: Application): AndroidViewModel(application) {
    private val expenseRepository: ExpenseRepository


    init {
        val expenseDAO = ExpenseDataBase.getDatabase(application).expenseDao()
        expenseRepository = ExpenseRepository(expenseDAO)
    }
}