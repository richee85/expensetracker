package com.galambosrichard.expensetracker.data.dto

data class ExpenseDTO(
    var id: Int?,
    var title: String,
    var amount: Int,
    var date: String
)