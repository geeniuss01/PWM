package me.samen.pwm.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    var fab: FloatingActionButton? = null
    var recyclerView: RecyclerView? = null
    var appData: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)
        appData = (application as PWMApp).appData

        fab = (findViewById(R.id.fab) as FloatingActionButton?)!!
        fab?.setOnClickListener { view ->
            startActivity(Intent(this, EditActivity::class.java))
        }
        recyclerView = (findViewById(R.id.list) as RecyclerView?)!!
        recyclerView?.adapter = AccListAdapter(appData?.getAccounts()!!, this, this)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        if (!appData?.authenticated!!) {
            startActivity(Intent(this, SetupActivity::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        appData?.authenticated = false
    }

    override fun onClick(v: View?) {
        val pos = v?.tag as Int
        val pwd = appData?.getAccounts()!!.get(pos).pwd as String
        when (v?.id) {
            R.id.textView, R.id.textView2 -> Snackbar.make(v!!, pwd, Snackbar.LENGTH_SHORT).setAction("ach", null).show()
            R.id.textView3 -> {
                val intnt = Intent(this, EditActivity::class.java)
                intnt.putExtra("pos", pos)
                startActivity(intnt)
            }
        }
    }
}
