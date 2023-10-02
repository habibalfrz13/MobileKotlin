package coding.kotlinbaru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputWidth: EditText
    private lateinit var inputHeight: EditText
    private lateinit var inputLength: EditText
    private lateinit var result: TextView
    private lateinit var btn: Button
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputWidth = findViewById(R.id.edt_width)
        inputHeight = findViewById(R.id.edt_height)
        inputLength = findViewById(R.id.edt_length)
        btn = findViewById(R.id.btn_result)
        result = findViewById(R.id.result)

        btn.setOnClickListener(this)

//        menampilkan value yg ada di bundle
        if (savedInstanceState != null) {
            val textResult = savedInstanceState.getString(STATE_RESULT)
            result.text = textResult
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_result) {
            val width = inputWidth.text.toString().trim()
            val height = inputHeight.text.toString().trim()
            val length = inputLength.text.toString().trim()

            var isEmpty = false

            if (width.isEmpty()) {
                isEmpty = true
                inputWidth.error = "Wajib diisi"
            }

            if (height.isEmpty()) {
                isEmpty = true
                inputHeight.error = "Wajib diisi"
            }

            if (length.isEmpty()) {
                isEmpty = true
                inputLength.error = "Wajib diisi"
            }

            if (!isEmpty) {
                val volume = height.toDouble() * width.toDouble() * length.toDouble()
                result.text = volume.toString()
            }
        }
    }
}