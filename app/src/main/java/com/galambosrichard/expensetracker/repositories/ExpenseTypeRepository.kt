package com.galambosrichard.expensetracker.repositories

import androidx.lifecycle.LiveData
import com.galambosrichard.expensetracker.data.dao.ExpenseTypeDAO
import com.galambosrichard.expensetracker.data.dto.ExpenseTypeDTO

class ExpenseTypeRepository(private val dao: ExpenseTypeDAO) {
    val readAllData: LiveData<List<ExpenseTypeDTO>> = dao.readAllData()
    val count: LiveData<Int> = dao.getCount()
}