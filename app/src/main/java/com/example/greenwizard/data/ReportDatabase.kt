package com.example.greenwizard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.greenwizard.model.Report

@Database(entities = [Report::class], version=2, exportSchema = false)
abstract class ReportDatabase: RoomDatabase() {

    abstract fun ReportDao(): ReportDao

    companion object{
        @Volatile
        private var INSTANCE: ReportDatabase? = null

        fun getDatabase(context: Context): ReportDatabase {
            val tempInstances = INSTANCE
            if (tempInstances != null) {
                return tempInstances
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReportDatabase::class.java,
                    "report_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}