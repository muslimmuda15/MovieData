package com.app.rachmad.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ItemFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}
