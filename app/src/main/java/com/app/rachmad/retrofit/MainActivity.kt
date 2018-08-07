package com.app.rachmad.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.rachmad.retrofit.`object`.MovieData

class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: MovieData?) {
        Toast.makeText(this, "Movie : ${item!!.title}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ItemFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}
