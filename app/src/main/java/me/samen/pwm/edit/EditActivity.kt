package me.samen.pwm.edit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.activity_edit.*
import me.samen.pwm.R
import me.samen.pwm.common.Data
import me.samen.pwm.common.EncryptionUtil
import me.samen.pwm.common.PWMApp
import me.samen.pwm.common.UserAccount

class EditActivity : AppCompatActivity(), View.OnClickListener {
    public var appData: Data? = null
    public var encUtil: EncryptionUtil? = null
    var selectedAcc: UserAccount? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_edit)
        (application as PWMApp).appComponent!!.injectA(this)

        val toolBar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)
        supportActionBar!!.title = "Edit Account"

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
            supportActionBar!!.title = "New Account"
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
