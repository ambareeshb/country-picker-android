package ambareesh.com.easyphonepicker

import ambareesh.com.easyphoneformat.picker.PickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        easyPhoneText.pickerListener = PickerDialog.newInstance()
//        easyPhoneText.editText = editText

    }
}
