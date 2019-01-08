package com.haydencampbell.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.haydencampbell.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myName: MyName = MyName("Hayden Campbell")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /* findViewById<Button>(R.id.done_button).setOnClickListener{
             addNickname(it)
         }
 */
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        /* val editText =  findViewById<EditText>(R.id.nickname_edit)
         val nickNameTextView = findViewById<TextView>(R.id.nickname_text)*/
        binding.apply {
           // nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
