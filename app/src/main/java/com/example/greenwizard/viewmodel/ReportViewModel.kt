package com.example.greenwizard.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.greenwizard.data.ReportDatabase
import com.example.greenwizard.repository.ReportRepository
import com.example.greenwizard.model.Report
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReportViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Report>> // Change visibility to public
    private val repository: ReportRepository

    init {
        val reportDao = ReportDatabase.getDatabase(application).ReportDao()
        repository = ReportRepository(reportDao)
        readAllData = repository.readAllData
    }

    fun addReport(report: Report) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addReport(report)
        }
    }

    fun updateReport(report: Report) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateReport(report)
        }
    }

    fun deleteReport(report: Report) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteReport(report)
        }
    }
}
