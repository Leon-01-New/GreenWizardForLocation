package com.example.greenwizard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.greenwizard.model.Report

@Dao
interface ReportDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReport(report: Report)

    @Update
    suspend fun updateReport(report: Report)

    @Delete
    suspend fun deleteReport(report: Report)

    @Query(value = "Select * FROM report_table ORDER BY id ASC")
    fun readAllReportData(): LiveData<List<Report>>

}