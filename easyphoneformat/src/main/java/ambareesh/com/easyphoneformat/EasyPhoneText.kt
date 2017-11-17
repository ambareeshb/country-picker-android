package ambareesh.com.easyphoneformat

import ambareesh.com.easyphoneformat.picker.PickerDialog
import android.content.Context
import android.content.res.TypedArray
import android.support.annotation.StyleableRes
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.easy_phone_text.view.*

/**
 * Created by ambareesh on 26/10/17.
 * Layout for country selection and number input.
 */

class EasyPhoneText : LinearLayout, Country.CountryListener {

    override fun countrySelected(country: Country) {
        selectedCountry = country
    }

    private var fragmentManger: FragmentManager? = null
    private var noEditText = false
    private var isCountryVisible = true
    private var editText: PhoneText? = null
        set(value) {
            value?.let {
                textPhoneNumber.visibility = GONE
                value.inputType = InputType.TYPE_CLASS_PHONE
                selectedCountry?.let { value.setCountryCode(it.code, it.dialCode) }
                field = value
            }
        }
    get() = field ?: textPhoneNumber


    private var selectedCountry: Country? = null
        set(value) {
            field = value
            field?.let {
                imageFlag.setImageResource(it.flag)
                editText?.setCountryCode(countryCode = it.code, countryPrefix = it.dialCode)
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

    /**
     * Initialise custom XML Tags.
     */
    private fun init(context: Context, attrs: AttributeSet?) {
        init()
        val attrArray = context.theme.obtainStyledAttributes(attrs, R.styleable.EasyPhoneText, 0, 0)
        initAttributes(attrArray)

        // Initialise fragment manager from context.
        when (context) {
            is AppCompatActivity -> fragmentManger = context.supportFragmentManager
            is android.support.v4.app.Fragment -> fragmentManger = context.fragmentManager
        }

        //View initialise
        attrArray.recycle()
    }

    /**
     * Basic init.
     */
    private fun init() {
        inflate(context, R.layout.easy_phone_text, this)
        imageFlag.setOnClickListener {
            pickerListener?.showPicker(fragmentManger!!,
                    Country.COUNTRIES, this@EasyPhoneText)
        }
    }

    /**
     * The XML  tag values are initialised.
     */
    private fun initAttributes(attrArray: TypedArray) {
        isCountryVisible = attrArray.getBoolean(R.styleable.EasyPhoneText_country_visible, true)
        noEditText = attrArray.getBoolean(R.styleable.EasyPhoneText_no_edit_text, false)

        selectedCountry = if (attrArray.hasValue(R.styleable.EasyPhoneText_selected_country)) {
            Country.getCountryByISO(attrArray.getString(R.styleable.EasyPhoneText_selected_country))
        } else {
            Country.getCountryByISO("IN")//Default
        }

    }


    /**
     * open a picker to choose country
     */
    interface CountryPicker {
        fun showPicker(manager: FragmentManager, list: Array<Country>, listener: Country.CountryListener)
    }


}
