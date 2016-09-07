package me.samen.pwm.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import me.samen.pwm.R
import me.samen.pwm.common.Data
import me.samen.pwm.common.PWMApp
import me.samen.pwm.edit.EditActivity
import me.samen.pwm.setup.AppIntroActivity
import me.samen.pwm.setup.SetupActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    var fab: FloatingActionButton? = null
    var recyclerView: RecyclerView? = null
    var appData: Data? = null
    var adapter: AccListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolBar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)

        appData = (application as PWMApp).appData

        fab = (findViewById(R.id.fab) as FloatingActionButton?)!!
        fab?.setOnClickListener { view ->
            startActivity(Intent(this, EditActivity::class.java))
        }
        adapter = AccListAdapter(appData?.getSugarAcc()!!, this, this)
        recyclerView = (findViewById(R.id.list) as RecyclerView?)!!
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        if (!appData?.authenticated!!) {
            startActivity(Intent(this, SetupActivity::class.java))
        } else {
            appData?.getSugarAcc()
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onPause() {
        super.onPause()
        appData?.authenticated = false
    }

    override fun onClick(v: View?) {
        val pos = v?.tag as Int
        val pwd = appData?.getSugarAcc()!!.get(pos).pwd as String
        when (v?.id) {
            R.id.textView, R.id.textView2 -> Snackbar.make(v!!, pwd, Snackbar.LENGTH_SHORT).setAction("ach", null).show()
            R.id.textView3 -> {
                val intnt = Intent(this, EditActivity::class.java)
                intnt.putExtra("pos", pos)
                startActivity(intnt)
            }
        }
    }

    private fun gotoSetUpActivity() {
        startActivity(Intent(this, AppIntroActivity::class.java))
        finish()
    }
}
