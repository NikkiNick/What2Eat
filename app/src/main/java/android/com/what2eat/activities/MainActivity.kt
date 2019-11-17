package android.com.what2eat.activities

import android.com.what2eat.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 *  MainActivity
 */
class MainActivity : AppCompatActivity() {

    /**
     * ======= onCreate() =======
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
