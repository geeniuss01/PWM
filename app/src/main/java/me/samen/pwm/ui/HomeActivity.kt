package me.samen.pwm.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View

import me.samen.pwm.R

class HomeActivity : AppCompatActivity() {
    var fab: FloatingActionButton = null!!;
    var recyclerView: RecyclerView = null!!;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        fab = (findViewById(R.id.fab) as FloatingActionButton?)!!
        fab!!.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        recyclerView=(findViewById(R.id.list) as RecyclerView?)!!

    }

}
