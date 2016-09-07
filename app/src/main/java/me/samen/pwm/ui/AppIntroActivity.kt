package me.samen.pwm.ui

import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment

import me.samen.pwm.R

class AppIntroActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(AppIntroFragment.newInstance("OFFLINE", "Works offline, No need internet", R.mipmap.ic_launcher, R.color.primary))
        addSlide(AppIntroFragment.newInstance("SECURE", "Data stored locally in your device. The Passwords stored using AES encryption", R.mipmap.ic_launcher, R.color.primary))
        addSlide(AppIntroFragment.newInstance("SIMPLE", "Simple UI and and easy to use.", R.mipmap.ic_launcher, R.color.primary))

        setBarColor(getColor(R.color.accent))
        setSeparatorColor(getColor(android.R.color.white))

        showSkipButton(true)
        isProgressButtonEnabled = true

        setVibrateIntensity(30)
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Do something when users tap on Skip button.
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Do something when users tap on Done button.
    }

    override fun onSlideChanged(oldFragment: Fragment?, newFragment: Fragment?) {
        super.onSlideChanged(oldFragment, newFragment)
        // Do something when the slide changes.
    }
}
