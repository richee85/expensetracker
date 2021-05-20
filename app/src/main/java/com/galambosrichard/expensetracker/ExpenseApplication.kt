package com.galambosrichard.expensetracker

import android.app.Application
import android.content.Context

class ExpenseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        var appContext: Context? = null
            private set
        var selectedExpense: Int? = null
    }
}