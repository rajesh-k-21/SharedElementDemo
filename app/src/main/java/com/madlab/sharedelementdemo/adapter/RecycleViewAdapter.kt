package com.madlab.sharedelementdemo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.madlab.sharedelementdemo.activity.MainActivity
import com.madlab.sharedelementdemo.R
import com.madlab.sharedelementdemo.activity.SharedElementActivity
import com.madlab.sharedelementdemo.model.TechnologyData

class RecycleViewAdapter(
    private val list: ArrayList<TechnologyData>,
    private val context: Context,
    private val mainActivity: MainActivity
) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewProfile: AppCompatImageView = view.findViewById(R.id.imageViewProfile)
        val textViewTechName: AppCompatTextView = view.findViewById(R.id.textViewTechName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTechName.text = list[position].technologyName
        Glide.with(context).load(list[position].profileImage).into(holder.imageViewProfile)

        holder.imageViewProfile.setOnClickListener {

            val intent = Intent(mainActivity, SharedElementActivity::class.java)
            intent.putExtra("image", list[position].profileImage)
            intent.putExtra("name", list[position].technologyName)
            intent.putExtra("details", list[position].technologyDetails)

            val activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mainActivity,
                    holder.imageViewProfile,
                    "transit"
                )
            ActivityCompat.startActivity(mainActivity, intent, activityOptionsCompat.toBundle())
        }

    }
}