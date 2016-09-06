package me.samen.pwm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.activity_edit.*
import me.samen.pwm.EncryptionUtil
import me.samen.pwm.PWMApp
import me.samen.pwm.R
import me.samen.pwm.data.Data
import me.samen.pwm.data.UserAccount

class EditActivity : AppCompatActivity(), View.OnClickListener {
    var appData: Data? = null
    var encUtil: EncryptionUtil? = null
    var selectedAcc: UserAccount? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        appData = (application as PWMApp).appData!!
        encUtil = (application as PWMApp).encUtil
        buttonAddUpdate.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        var pos = intent.getIntExtra("pos", -1)
        if (pos != -1) {
            selectedAcc = appData?.getSugarAcc()!!.get(pos!!)
            editTextWebsite.setText(selectedAcc?.website)
            editTextId.setText(selectedAcc?.username)
            editTextPwd.setText(selectedAcc?.pwd)
            buttonAddUpdate.setText(resources.getString(R.string.Edit))
        } else {
            buttonDelete.visibility = View.GONE
            editTextWebsite.isEnabled = true
            editTextId.isEnabled = true
        }
    }

    fun checkAndSetError(editText: EditText): Boolean {
        if (editText.text.toString().isEmpty()) {
            editText.setError(resources.getString(R.string.error_empty))
            return true
        }
        return  false
    }

    override fun onClick(v: View?) {
        if (checkAndSetError(editTextWebsite) || checkAndSetError(editTextId) || checkAndSetError(editTextPwd)) {
            return
        }
        when (v?.id) {
            R.id.buttonAddUpdate -> {
                if (selectedAcc == null) {
                    val ua = UserAccount(editTextWebsite.text.toString(), editTextId.text.toString(),
                            editTextPwd.text.toString())
                    appData?.encrpt(ua!!)
                    SugarRecord.save(ua)
                } else {
                    encUtil?.encryptMsg(editTextId.text.toString(), encUtil?.generateKey()!!)
                    //selectedAcc!!.username = editTextId.text.toString()
                    selectedAcc!!.pwd = editTextPwd.text.toString()
                    appData!!.encrpt(selectedAcc!!)
                    SugarRecord.save(selectedAcc)
                }
                finish()
            }
            R.id.buttonDelete -> {
                if (selectedAcc != null) SugarRecord.delete(selectedAcc)
                finish()
            }
        }
    }

}
