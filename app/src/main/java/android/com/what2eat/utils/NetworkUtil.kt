package android.com.what2eat.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Klasse voor network functionaliteit in de applicatie
 */
class NetworkUtil {
    /**
     * Met deze functie kan er nagegaan worden of er Internet verbinding beschikbaar is
     * @param context Context
     * @return Boolean
     */
    fun isInternetAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val netInfo = cm!!.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}