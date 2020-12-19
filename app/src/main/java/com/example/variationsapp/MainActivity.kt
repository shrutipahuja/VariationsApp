package com.example.variationsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.variationsapp.Variations.VariationsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navigateToVariations(view: View) {
        val intent = Intent(this, VariationsActivity::class.java)
        startActivity(intent)
    }
}