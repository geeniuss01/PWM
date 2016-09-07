package me.samen.pwm.setup

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.paolorotolo.appintro.AppIntro2
import me.samen.pwm.R

class AppIntroActivity : AppIntro2() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(IntroSlide.newInstance(R.layout.intro_layout_one))
        addSlide(IntroSlide.newInstance(R.layout.intro_layout_two))
        addSlide(IntroSlide.newInstance(R.layout.intro_layout_three))
        setImageSkipButton(null)

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        AppPreferenceManager.getPreference(this).isFirstTimeLaunch = false
        gotoSetUpActivity()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        AppPreferenceManager.getPreference(this).isFirstTimeLaunch = false
        gotoSetUpActivity()
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        // Do something when the slide changes.
    }

    private fun gotoSetUpActivity(){
        startActivity(Intent(this, SetupActivity::class.java))
        finish()
    }
    
}
