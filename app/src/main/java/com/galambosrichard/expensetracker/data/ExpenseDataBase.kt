package com.galambosrichard.expensetracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.galambosrichard.expensetracker.data.entities.Expense
import com.galambosrichard.expensetracker.data.dao.ExpenseDAO
import com.galambosrichard.expensetracker.data.entities.ExpenseType
import com.galambosrichard.expensetracker.data.dao.ExpenseTypeDAO

@Database(entities = [
    Expense::class,
    ExpenseType::class
 ], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ExpenseDataBase: RoomDatabase() {

    abstract fun expenseDao(): ExpenseDAO
    abstract fun expenseTypeDao(): ExpenseTypeDAO

    companion object {
        @Volatile
        private var INSTANCE: ExpenseDataBase? = null

        fun getDatabase(context: Context): ExpenseDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        ExpenseDataBase::class.java,
                        "expense_database"
                    )
                    .addCallback(callback)
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private val callback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // amikor app első indulásnál létrehozzuk az adatbázist
            }
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // amikor app indulásnál megnyitjuk az adatbázist
            }
        }
    }
}