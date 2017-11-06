package ambareesh.com.easyphoneformat

import ambareesh.com.easyphoneformat.picker.PickerDialog
import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.easy_phone_text.view.*

/**
 * Created by ambareesh on 26/10/17.
 */

class EasyPhoneText : LinearLayout, Country.CountryListener {

    override fun countrySelected(country: Country) {
        selectedCountry = country

    }

    private var fragmentManger: FragmentManager? = null
    private var flagWeight = 2
    private var numberWeight = 10
    private var noEditText = false
    private var isCountryVisible = true

    private var selectedCountry: Country? = null
        set(value) {
            field = value
            field?.let {
                imageFlag.setImageResource(it.flag)
                textPhoneNumber.setCountryCode(countryCode = it.code, countryPrefix = it.dialCode)
            }
        }

    // Listener for country picker opening.
    var pickerListener: CountryPicker? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        init()
        val attrArray = context.theme.obtainStyledAttributes(attrs, R.styleable.EasyPhoneText, 0, 0)
        flagWeight = attrArray.getInteger(R.styleable.EasyPhoneText_flag_width_ratio, 1)
        numberWeight = attrArray.getInt(R.styleable.EasyPhoneText_number_width_ratio, 30)
        isCountryVisible = attrArray.getBoolean(R.styleable.EasyPhoneText_country_visible, true)
        noEditText = attrArray.getBoolean(R.styleable.EasyPhoneText_no_edit_text, false)
        selectedCountry = if (attrArray.hasValue(R.styleable.EasyPhoneText_selected_country)) {
            Country.getCountryByISO(attrArray
                    .getString(R.styleable.EasyPhoneText_selected_country))
        } else {
            Country.getCountryByISO("IN")
        }

        //Visibility and weight  change accordingly.
        if (!isCountryVisible) {
            imageFlag.visibility = GONE; numberWeight = 10
        }
        if (noEditText) {
            textPhoneNumber.visibility = GONE;flagWeight = 10
        }
        val flagParams = imageFlag.layoutParams as LinearLayout.LayoutParams
        flagParams.weight = flagWeight.toFloat()
        val phoneParams = textPhoneNumber?.layoutParams as LinearLayout.LayoutParams
        phoneParams.weight = numberWeight.toFloat()

        when (context) {
            is AppCompatActivity -> fragmentManger = context.supportFragmentManager
            is android.support.v4.app.Fragment -> fragmentManger = context.fragmentManager
        }
        //View initialise
        attrArray.recycle()
    }

    private fun init() {
        inflate(context, R.layout.easy_phone_text, this)

        imageFlag.setOnClickListener {
            pickerListener?.
                    showPicker(fragmentManger!!, Country.COUNTRIES, this@EasyPhoneText)
        }
    }


    /**
     * open a picker to choose country
     */
    interface CountryPicker {
        fun showPicker(manager: FragmentManager, list: Array<Country>, listener: Country.CountryListener)
    }


}
