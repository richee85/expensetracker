package com.galambosrichard.expensetracker.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.galambosrichard.expensetracker.data.dto.ExpenseTypeDTO

@Dao
interface ExpenseTypeDAO {
    @Query("SELECT * FROM ExpenseType ORDER BY id ASC")
    fun readAllData(): LiveData<List<ExpenseTypeDTO>>

    @Query("SELECT COUNT(*) FROM ExpenseType")
    fun getCount(): LiveData<Int>
}