package com.galambosrichard.expensetracker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Expense(
    @PrimaryKey
    var id: Int?,
    var title: String,
    var amount: Int,
    var date: String
)