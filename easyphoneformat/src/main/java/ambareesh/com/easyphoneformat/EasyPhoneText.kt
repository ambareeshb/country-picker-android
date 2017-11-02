package ambareesh.com.easyphoneformat

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.easy_phone_text.view.*

/**
 * Created by ambareesh on 26/10/17.
 */

class EasyPhoneText : LinearLayout, Country.CountryListener {
    override fun countrySelected(country: Country) {
        selectedCountry = country
        textPhoneNumber.setCountryCode(countryCode = country.code, countryPrefix = country.dialCode)
    }

    private var flagWeight = 2
    private var numberWeight = 8
    private var noEditText = false
    private var isCountryVisible = true

    var selectedCountry: Country? = null
        get() = Country.getCountryByISO("IN")
        set(value) {
            field = value
            field?.flag?.let { imageFlag.setImageResource(it) }
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
        flagWeight = attrArray.getInteger(R.styleable.EasyPhoneText_flag_width_ratio, 2)
        numberWeight = attrArray.getInt(R.styleable.EasyPhoneText_number_width_ratio, 8)
        isCountryVisible = attrArray.getBoolean(R.styleable.EasyPhoneText_country_visible, true)
        noEditText = attrArray.getBoolean(R.styleable.EasyPhoneText_no_edit_text, false)

        //View initialise
        attrArray.recycle()
    }

    private fun init() {
        View.inflate(context, R.layout.easy_phone_text, null)
        val flagParams = imageFlag.layoutParams as LinearLayout.LayoutParams
        flagParams.weight = flagWeight.toFloat()
        val phoneParams = textPhoneNumber.layoutParams as LinearLayout.LayoutParams
        phoneParams.weight = numberWeight.toFloat()

        //Visibility change accordingly.
        if (!isCountryVisible) imageFlag.visibility = GONE
        if (noEditText) textPhoneNumber.visibility = GONE

        selectedCountry = Country.getCountryByISO("IN")
        imageFlag.setOnClickListener { pickerListener?.showPicker(Country.COUNTRIES) }
    }



    /**
     * open a picker to choose country
     */
    interface CountryPicker {
        fun initPicker( phoneText: EasyPhoneText)
        fun showPicker(list: Array<Country>)
    }


}
