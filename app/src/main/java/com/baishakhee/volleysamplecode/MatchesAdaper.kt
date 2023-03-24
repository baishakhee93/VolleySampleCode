package com.baishakhee.volleysamplecode

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MatchesAdaper(
    private val context1: Context?,
    private val matchModel: ArrayList<MatchModel.NameValuePairs.Data.DataValues>?
) : RecyclerView.Adapter<ViewHolder>() {
    val context: Context? = context1;

    // Constants to represent the view types
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_AD = 1

    class ItemViewHolder(itemView: View) : ViewHolder(itemView) {
        var matchType: TextView = itemView.findViewById(R.id.matchType)
        var startDate: TextView = itemView.findViewById(R.id.startDate)
        var endDate: TextView = itemView.findViewById(R.id.endDate)
        var name: TextView = itemView.findViewById(R.id.name)
        // Bind the regular item data here
        @SuppressLint("SetTextI18n")
        fun bind(matchModel: MatchModel.NameValuePairs.Data.DataValues) {
            // Bind the data to the view components
            startDate.text = matchModel.dataValues?.startDate
            endDate.text = matchModel.dataValues?.endDate
           name.text = matchModel.dataValues?.name
           matchType.text =
                " T20 " + matchModel.dataValues?.t20.toString() + "\n  test " + matchModel.dataValues?.test.toString() + " \n  odi " + matchModel.dataValues?.odi.toString()

        }
    }

    // ViewHolder for the ad view
    class AdViewHolder(itemView: View) : ViewHolder(itemView) {
        private  var adView: AdView=itemView.findViewById(R.id.addView)
        // Bind the ad data here
        fun bind() {
            val adRequest = AdRequest.Builder().build()

            adView.loadAd(adRequest)
            // Bind the data to the view components
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        return if (viewType == VIEW_TYPE_AD) {
            val adView =
                LayoutInflater.from(parent.context).inflate(R.layout.ad_layout, parent, false)
            AdViewHolder(adView)
        } else {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.matches_list, parent, false)
            ItemViewHolder(itemView)
        }
    }


    override fun getItemCount(): Int {
        return matchModel?.size?.plus((matchModel.size?.div(3)!!)) ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        // Return a different view type for the ad item view
        return if ((position + 1) % 3 == 0) {
            VIEW_TYPE_AD
        } else {
            VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            val itemViewHolder = holder as ItemViewHolder
            val data = matchModel?.get(position - (position / 3))

            if (data != null) {
                itemViewHolder.bind(data)
            }
        } else {
            val adViewHolder = holder as AdViewHolder
            adViewHolder.bind()
        }

    }




}