package com.shamith.playground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shamith.playground.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val message = intent.getStringExtra("message") as String
        binding.textView2.text = message;
    }
}