package com.example.greenwizard.repository

import androidx.lifecycle.LiveData
import com.example.greenwizard.News
import com.example.greenwizard.data.ReportDao
import com.example.greenwizard.model.Report

class ReportRepository (private val ReportDao: ReportDao){

    val readAllData: LiveData<List<Report>> = ReportDao.readAllReportData()

    suspend fun addReport(report: Report){
        ReportDao.addReport(report)
    }

    suspend fun updateReport(report: Report) {
        ReportDao.updateReport(report)
    }

    suspend fun deleteReport(report: Report) {
        ReportDao.deleteReport(report)
    }
}

