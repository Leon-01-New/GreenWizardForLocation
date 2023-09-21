package com.example.greenwizard.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.greenwizard.R
import com.example.greenwizard.model.Report
import java.text.SimpleDateFormat
import java.util.Date

class ReportAdapter : RecyclerView.Adapter<ReportAdapter.MyViewHolder>() {

    private var reportList = emptyList<Report>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define your TextViews here
        val idView: TextView = itemView.findViewById(R.id.idView)
        val titleView: TextView = itemView.findViewById(R.id.descriptionView)
        val dateView: TextView = itemView.findViewById(R.id.dateView)

        val rowLayout: ConstraintLayout = itemView.findViewById(R.id.rowLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return reportList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = reportList[position]
        holder.idView.text = currentItem.id.toString()
        holder.titleView.text = currentItem.description

        // Format the timestamp to a readable date string
        val formattedDate = SimpleDateFormat("yyyy-MM-dd").format(Date(currentItem.date))
        holder.dateView.text = formattedDate

        holder.rowLayout.setOnClickListener{
            val action = listReportDirections.actionListNewsToUpdateNews(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData(report: List<Report>) {
        this.reportList = report
        notifyDataSetChanged()
    }
}