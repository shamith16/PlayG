package com.shamith.playground

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.shamith.playground.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var button: Button;

    private lateinit var editText: EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val xmlLayout = binding.root
        button = binding.button;
        editText = binding.editText
        setContentView(xmlLayout)
        button.setOnClickListener { sendMessage(xmlLayout) };
    }

    private fun sendMessage(view: View) {
        val intent = Intent(this, DataActivity::class.java).apply {
            putExtra(
                "message",
                editText.text.toString()
            )
//            intent.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK;

        };

        startActivity(intent)
    }


}