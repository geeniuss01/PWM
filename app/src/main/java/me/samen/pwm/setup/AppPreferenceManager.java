package me.samen.pwm.setup;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by satyanarayana.avv on 07-09-2016.
 */

public class AppPreferenceManager {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    private static AppPreferenceManager mPreferenceManager;

    // shared mPreferences mode
    private int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "pwd_preferences";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private AppPreferenceManager(Context context) {
        this.mContext = context;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }

    public static AppPreferenceManager getPreference(Context context){
        if(mPreferenceManager == null){
            mPreferenceManager =   new AppPreferenceManager(context);
        }

        return mPreferenceManager;

    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        mEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        mEditor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return mPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
