package com.galambosrichard.expensetracker.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
class ExpenseType(
    @PrimaryKey
    var id: Int?,
    var type: String
)