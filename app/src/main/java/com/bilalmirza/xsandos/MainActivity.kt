package com.bilalmirza.xsandos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bilalmirza.xsandos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Base_Theme_XsAndOs)
        setContentView(binding.root)
    }
}