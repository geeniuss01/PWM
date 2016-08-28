package me.samen.pwm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_edit.*
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data
import me.samen.pwm.data.UserAccount

class EditActivity : AppCompatActivity(),View.OnClickListener {
    var appData: Data? = null
    var selectedAcc : UserAccount? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        appData = (application as PWMApp).appData!!
        buttonAddUpdate.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        var pos = intent.getIntExtra("pos", -1)
        if (pos != -1) {
            selectedAcc = appData?.getUAccounts()!!.get(pos!!)
            editTextWebsite.setText(selectedAcc?.website)
            editTextId.setText(selectedAcc?.username)
            editTextPwd.setText(selectedAcc?.pwd)
            buttonAddUpdate.setText(resources.getString(R.string.Edit))
        } else {
            buttonDelete.visibility = View.GONE
            editTextWebsite.isEnabled=true
        }
}
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonAddUpdate -> {
                //SugarRecord.save(ua)
                if (selectedAcc == null) {
                    val ua = UserAccount(editTextWebsite.text.toString(), editTextPwd.text.toString(), editTextPwd.text.toString())
                    appData?.addAccount(ua)
                } else {
                    selectedAcc!!.username = editTextId.text.toString()
                    selectedAcc!!.pwd = editTextId.text.toString()
                    appData?.editAccount(selectedAcc!!)
                }
                finish()
            }
            R.id.buttonDelete -> {
                if (selectedAcc != null) appData?.deleteAccount(selectedAcc!!)
                finish()}
        }
    }

}
