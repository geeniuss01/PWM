package me.samen.pwm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.activity_edit.*
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data
import me.samen.pwm.data.UserAccount

class EditActivity : AppCompatActivity(),View.OnClickListener {
    var appData: Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        appData = (application as PWMApp).appData!!
        buttonAddUpdate.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        finish()
        when (v?.id) {
            R.id.buttonAddUpdate -> {val ua = UserAccount(editTextWebsite.text.toString(), editTextPwd.text.toString(), editTextPwd.text.toString())
                SugarRecord.save(ua)
            }

            R.id.buttonDelete -> {finish()}
        }
    }

}
