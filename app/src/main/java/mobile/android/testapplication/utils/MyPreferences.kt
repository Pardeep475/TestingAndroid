package mobile.android.testapplication.utils

import android.content.Context
import android.preference.PreferenceManager

class MyPreferences(context: Context?) {

    companion object {
        private const val MY_STORAGE = "MY_STORAGE"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var darkMode = preferences.getInt(MY_STORAGE, 0)
        set(value) = preferences.edit().putInt(MY_STORAGE, value).apply()

}