package com.baishakhee.volleysamplecode

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchesAdaper(private val context1: Context?, matchModel: MatchModel) : RecyclerView.Adapter<MatchesAdaper.ViewHolder>(){
     val context: Context? =context1;
   val matchModel: MatchModel=matchModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.matches_list, parent, false)



        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.startDate.text=matchModel.nameValuePairs?.data?.values?.get(position)?.dataValues?.startDate
        holder.endDate.text=matchModel.nameValuePairs?.data?.values?.get(position)?.dataValues?.endDate
        holder.name.text=matchModel.nameValuePairs?.data?.values?.get(position)?.dataValues?.name
        holder.matchType.text=" T20 "+matchModel.nameValuePairs?.data?.values?.get(position)?.dataValues?.t20.toString()+"\n  test "+matchModel.nameValuePairs?.data?.values?.get(position)?.dataValues?.test.toString()+" \n  odi "+matchModel.nameValuePairs?.data?.values?.get(position)?.dataValues?.odi.toString()
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var matchType:TextView=itemView.findViewById(R.id.matchType)
        var startDate:TextView=itemView.findViewById(R.id.startDate)
        var endDate:TextView=itemView.findViewById(R.id.endDate)
        var name:TextView=itemView.findViewById(R.id.name)
    }



    override fun getItemCount(): Int {
        return matchModel.nameValuePairs?.data?.values?.size
            ?: 0
    }
}