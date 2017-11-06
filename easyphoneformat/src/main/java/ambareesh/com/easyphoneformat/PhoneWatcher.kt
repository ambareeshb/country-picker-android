package ambareesh.com.easyphoneformat

import android.content.Context
import android.telephony.PhoneNumberUtils
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher
import io.michaelrocks.libphonenumber.android.AsYouTypeFormatter
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil


/**
 * Created by ambareesh on 23/10/17.
 */

class PhoneWatcher
/**
 * The formatting is based on the given `countryCode`.
 *
 * @param countryNameCode the ISO 3166-1 two-letter country code that indicates the country/region
 * where the phone number is being entered.
 * @hide
 */
(context: Context, countryNameCode: String, private val countryCode: String) : TextWatcher {
    /**
     * Indicates the change was caused by ourselves.
     */
    private var mSelfChange = false
    /**
     * Indicates the formatting has been stopped.
     */
    private var mStopFormatting: Boolean = false
    private val mFormatter: AsYouTypeFormatter


    init {
        if (countryNameCode == null) throw IllegalArgumentException()
        mFormatter = PhoneNumberUtil.createInstance(context).getAsYouTypeFormatter(countryNameCode)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int,
                                   after: Int) {

        if (mSelfChange || mStopFormatting) {
            return
        }

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        if (mSelfChange || mStopFormatting) {
            return
        }
        // If the user inserted any non-dialable characters, stop formatting
        if (count > 0 && hasSeparator(s, start, count)) {
            stopFormatting()
        }
    }

    @Synchronized override fun afterTextChanged(numberEditable: Editable) {
        val reg = Regex("\\+.[^+]*")
        val numberString = numberEditable.toString()

        if (numberString.length < countryCode.length && numberEditable.trim().isNotEmpty()) {
            numberEditable.clear()
            numberEditable.append(countryCode)
            return
        }
        else if(numberEditable.trim().isNotEmpty() && !reg.matches(numberString)){//Remove any "+" signs other than starting one.
            numberEditable.append(numberString.replace("+",""),1,
                    numberEditable.length)
        }

        if (mStopFormatting) {
            // Restart the formatting when all texts were clear.
            mStopFormatting = numberEditable.length != 0
            return
        }
        if (mSelfChange) {
            // Ignore the change caused by numberEditable.replace().
            return
        }
        val formatted = reformat(numberEditable, Selection.getSelectionEnd(numberEditable))
        if (formatted != null) {
            val rememberedPos = mFormatter.rememberedPosition
            mSelfChange = true
            numberEditable.replace(0, numberEditable.length, formatted, 0, formatted.length)
            // The text could be changed by other TextWatcher after we changed it. If we found the
            // text is not the one we were expecting, just give up calling setSelection().
            if (formatted == numberEditable.toString()) {
                Selection.setSelection(numberEditable, rememberedPos)
            }
            mSelfChange = false
        }
    }

    /**
     * Generate the formatted number by ignoring all non-dialable chars and stick the cursor to the
     * nearest dialable char to the left. For instance, if the number is  (650) 123-45678 and '4' is
     * removed then the cursor should be behind '3' instead of '-'.
     */
    private fun reformat(s: CharSequence, cursor: Int): String? {
        // The index of char to the leftward of the cursor.
        val curIndex = cursor - 1
        var formatted: String? = null
        mFormatter.clear()
        var lastNonSeparator: Char = 0.toChar()
        var hasCursor = false
        val len = s.length
        for (i in 0 until len) {
            val c = s[i]
            if (PhoneNumberUtils.isNonSeparator(c)) {
                if (lastNonSeparator.toInt() != 0) {
                    formatted = getFormattedNumber(lastNonSeparator, hasCursor)
                    hasCursor = false
                }
                lastNonSeparator = c
            }
            if (i == curIndex) {
                hasCursor = true
            }
        }
        if (lastNonSeparator.toInt() != 0) {
            formatted = getFormattedNumber(lastNonSeparator, hasCursor)
        }
        return formatted
    }

    private fun getFormattedNumber(lastNonSeparator: Char, hasCursor: Boolean): String {
        return if (hasCursor)
            mFormatter.inputDigitAndRememberPosition(lastNonSeparator)
        else
            mFormatter.inputDigit(lastNonSeparator)
    }

    private fun stopFormatting() {
        mStopFormatting = true
        mFormatter.clear()
    }

    private fun hasSeparator(s: CharSequence, start: Int, count: Int): Boolean {
        for (i in start until start + count) {
            val c = s[i]
            if (!PhoneNumberUtils.isNonSeparator(c)) {
                return true
            }
        }
        return false
    }
}



