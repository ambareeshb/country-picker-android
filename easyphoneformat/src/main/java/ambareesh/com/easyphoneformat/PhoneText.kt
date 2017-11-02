package ambareesh.com.easyphoneformat

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet

/**
 * Created by ambareesh on 25/10/17.
 */

class PhoneText : android.support.v7.widget.AppCompatEditText {
    private val PLUS = "+"

    private var countryPrefix: String? = null
    private var countryCode: String? = null
    private var phoneFormatter: TextWatcher? = null

    constructor(context: Context) : super(context)


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)
        val offset = 2// for + and <Space>

        if (countryPrefix != null && selStart < countryPrefix!!.length + offset) {
            this.setSelection(text.toString().length)
        }
    }

    fun setCountryCode(countryCode: String, countryPrefix: String) {
        this.countryPrefix = countryPrefix
        this.countryCode = countryCode
//        removeTextChangedListener(phoneFormatter)

        val displayText = PLUS + countryPrefix
        setText(displayText)
        setSelection(text.length)


        phoneFormatter = PhoneWatcher(context,countryCode, countryPrefix)
        addTextChangedListener(phoneFormatter)
    }


}
