package android.com.what2eat.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {
    fun isInternetAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val netInfo = cm!!.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}