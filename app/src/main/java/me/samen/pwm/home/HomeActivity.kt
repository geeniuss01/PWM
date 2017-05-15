package me.samen.pwm.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import me.samen.pwm.R
import me.samen.pwm.common.Data
import me.samen.pwm.common.PWMApp
import me.samen.pwm.edit.EditActivity
import me.samen.pwm.setup.AppIntroActivity
import me.samen.pwm.setup.AppPreferenceManager
import me.samen.pwm.setup.SetupActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    val appData : Data by lazy { (application as PWMApp).appData }
    val listAdapter: AccListAdapter by lazy { AccListAdapter(appData.getSugarAcc(), this, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
        list.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onResume() {
        super.onResume()
        if (AppPreferenceManager.getPreference(this).isFirstTimeLaunch) {
            startActivity(Intent(this, AppIntroActivity::class.java))
        } else if (!appData.authenticated) {
            startActivity(Intent(this, SetupActivity::class.java))
        } else {
            appData.getSugarAcc()
            listAdapter.notifyDataSetChanged()
        }
    }

    override fun onPause() {
        super.onPause()
        appData.authenticated = false
    }

    override fun onClick(v: View?) {
        val pos = v?.tag as Int
        val pwd = appData.getSugarAcc().get(pos).pwd as String
        when (v.id) {
            R.id.textView, R.id.textView2 -> Snackbar.make(v, pwd, Snackbar.LENGTH_SHORT).setAction("ach", null).show()
            R.id.textView3 -> {
                val intnt = Intent(this, EditActivity::class.java)
                intnt.putExtra("pos", pos)
                startActivity(intnt)
            }
        }
    }
}
