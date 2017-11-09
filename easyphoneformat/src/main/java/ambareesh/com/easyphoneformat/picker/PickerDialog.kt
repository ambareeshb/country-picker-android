package ambareesh.com.easyphoneformat.picker

import ambareesh.com.easyphoneformat.Country
import ambareesh.com.easyphoneformat.EasyPhoneText
import ambareesh.com.easyphoneformat.R
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.country_picker.*

/**
 * Created by ambareesh on 31/10/17.
 * Demo Custom picker.
 */
class PickerDialog : android.support.v4.app.DialogFragment(), EasyPhoneText.CountryPicker, Country.CountryListener {
    private val TAG = "PICKER_DIALOG"
    private var countryListener: Country.CountryListener? = null


    override fun countrySelected(country: Country) {
        dismiss()
        countryListener?.countrySelected(country)
    }


    override fun showPicker(manager: FragmentManager, list: Array<Country>,listener:Country.CountryListener) {
        show(manager, TAG)
        countryListener = listener
    }

    companion object {
        fun newInstance(): PickerDialog = PickerDialog()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.country_picker, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view?.context)
    }

    /**
     * Initialises all UI components.
     */
    private fun init(context: Context?) {
        countryRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        countryRecycler.adapter = CountryAdapter(this@PickerDialog)
        (countryRecycler.adapter as CountryAdapter).countries = Country.COUNTRIES.asList()
        searchText.addTextChangedListener(watcher())
    }

    /**
     * Text search.
     */
    private fun watcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                (countryRecycler.adapter as CountryAdapter).countries =
                        Country.COUNTRIES.filter { it.name.capitalize().contains(s.toString().capitalize()) }
            }
        }
    }
}