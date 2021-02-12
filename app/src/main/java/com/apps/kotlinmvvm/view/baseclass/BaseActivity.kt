package com.apps.kotlinmvvm.view.baseclass


import android.app.ProgressDialog
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

open class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null
    var activeNetworkInfo: NetworkInfo? = null

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val connectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        activeNetworkInfo = connectivityManager.activeNetworkInfo
    }

    val isNetworkAvailable: Boolean
        get() = activeNetworkInfo != null && activeNetworkInfo!!.isConnected

    fun showToastMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun snakeBarView(view: View?, msg: String?) {
        Snackbar.make(view!!, msg!!, Snackbar.LENGTH_SHORT).show()
    }

    fun showDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog!!.setMessage("Loading...")
        progressDialog!!.setCancelable(false)
        progressDialog!!.setCanceledOnTouchOutside(false)
        if (!progressDialog!!.isShowing) progressDialog!!.show()
    }

    fun dismissDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }

    val dateTime: String
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = Date()
            return dateFormat.format(date)
        }
    val date: String
        get() {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = Date()
            return dateFormat.format(date)
        }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

   /* fun setPreferLogin(TAG: String?, value: String?) {
        val preferences = this.applicationContext.getSharedPreferences(
            SharedPreferConstant.LOGIN_PREFERENCES,
            MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.putString(TAG, value)
        editor.apply()
    }

    fun setPreference(TAG: String?, value: String?) {
        val preferences = this.applicationContext.getSharedPreferences(
            SharedPreferConstant.MY_PREFERENCES,
            MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.putString(TAG, value)
        editor.apply()
    }

    fun getPreferLogin(TAG: String?): String? {
        val preferences = this.applicationContext.getSharedPreferences(
            SharedPreferConstant.LOGIN_PREFERENCES,
            MODE_PRIVATE
        )
        return preferences.getString(TAG, "")
    }

    fun getPreference(TAG: String?): String? {
        val preferences = this.applicationContext.getSharedPreferences(
            SharedPreferConstant.MY_PREFERENCES,
            MODE_PRIVATE
        )
        return preferences.getString(TAG, "")
    }

    fun clearAllPreferences() {
        val editor = this.applicationContext.getSharedPreferences(
            SharedPreferConstant.MY_PREFERENCES,
            MODE_PRIVATE
        ).edit()
        editor.clear()
        editor.apply()
    }*/

   /* fun clearLoginPreferences() {
        val editor = this.applicationContext.getSharedPreferences(
            SharedPreferConstant.LOGIN_PREFERENCES,
            MODE_PRIVATE
        ).edit()
        editor.clear()
        editor.commit()
    }*/
}