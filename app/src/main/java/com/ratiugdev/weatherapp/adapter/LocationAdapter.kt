package com.ratiugdev.weatherapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ratiugdev.weatherapp.R
import com.ratiugdev.weatherapp.data.model.Location

class LocationAdapter(resultLocationList: List<Location>) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "DBG | LocationAdapter"
    }

    private val locations = mutableListOf<Location>()

    init {
        locations.addAll(resultLocationList)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCityName: TextView = itemView.findViewById(R.id.tv_city_name)
        private val tvCityType: TextView = itemView.findViewById(R.id.tv_city_type)
        private val tvDistanceToCity: TextView = itemView.findViewById(R.id.tv_distance_to_City)

        fun bind(location: Location) {
            tvCityName.text = location.titleLocation
            tvCityType.text = location.typeLocation

            if (location.distanceToLocation != null){
                tvDistanceToCity.text = location.titleLocation
                tvDistanceToCity.visibility = View.VISIBLE
            } else {
                tvDistanceToCity.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_locatin, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(locations[position])

    override fun getItemCount(): Int = locations.size

    fun swap(locations: List<Location>) {
        val diffCallback = LocationDiffCallback(this.locations, locations)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.locations.clear()
        this.locations.addAll(locations)
        diffResult.dispatchUpdatesTo(this)
    }
}

class LocationDiffCallback(
    private val oldList: List<Location>,
    private val newList: List<Location>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].woeidLocation == newList[newItemPosition].woeidLocation
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                oldList[oldItemPosition].titleLocation == newList[newItemPosition].titleLocation
                        &&  oldList[oldItemPosition].typeLocation == newList[newItemPosition].typeLocation
                        &&  oldList[oldItemPosition].coordinateLocation == newList[newItemPosition].coordinateLocation
                        &&  oldList[oldItemPosition].distanceToLocation == newList[newItemPosition].distanceToLocation
                )
    }

}