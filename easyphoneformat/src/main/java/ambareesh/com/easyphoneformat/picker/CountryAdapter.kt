package ambareesh.com.easyphoneformat.picker

import ambareesh.com.easyphoneformat.Country
import ambareesh.com.easyphoneformat.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.country_layout.view.*

/**
 * Created by ambareesh on 31/10/17.
 * Adapter class for country.
 */
class CountryAdapter : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
     var countries: List<Country>? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutView = LayoutInflater
                .from(parent?.context).inflate(R.layout.country_layout, parent, false)
        return ViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(countries!![position])
    }

    override fun getItemCount(): Int {
        return countries?.size ?: 0
    }

    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        fun bind(country: Country) {
            item.flagImage.setImageResource(country.flag)
            item.countryName.setText(country.name)
        }

    }
}