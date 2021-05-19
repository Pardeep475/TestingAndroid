package mobile.android.testapplication.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ShowToast")
    fun showToast(msg: String) {
        try {
            if (toast == null) {
                toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
            } else {
                toast?.view?.isShown     // true if visible
                toast?.setText(msg)
            }
        } catch (e: Exception) {         // invisible if exception
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        }

        toast?.show()  //finally display it

    }


    fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()

    }



    fun isInternetIsAvailable(mContext: Context): Boolean {
        val connectivity = mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivity.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            return true
        }
        return false
    }


}