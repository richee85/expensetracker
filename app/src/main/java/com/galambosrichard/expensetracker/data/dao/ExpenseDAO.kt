package com.galambosrichard.expensetracker.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.galambosrichard.expensetracker.data.dto.ExpenseDTO
import com.galambosrichard.expensetracker.data.entities.Expense

@Dao
interface ExpenseDAO {
    @Query("SELECT * FROM Expense ORDER BY id ASC")
    fun readAllData(): LiveData<List<ExpenseDTO>>

    @Query("SELECT COUNT(*) FROM Expense")
    fun getCount(): LiveData<Int>

    @Query("SELECT SUM(amount) FROM Expense")
    fun totalAmount(): LiveData<Int>

    @Query("SELECT * FROM Expense WHERE id = :id")
    fun select(id: Int): LiveData<Expense>

    @Insert
    fun insert(expense: Expense)

    @Update
    fun update(expense: Expense)
}