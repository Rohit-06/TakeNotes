package com.example.takenotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView


@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
//    lateinit var logo :ImageView
//    lateinit var appname:TextView
//    lateinit var lottieanimation: LottieAnimationView

    lateinit var handler :Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
//
//         logo = findViewById(R.id.logo)
//        appname = findViewById(R.id.app_name)
//       lottieanimation = findViewById(R.id.lottie)
//
//        logo.animate().translationY(20000f).setDuration(5000).setStartDelay(4000)
//        lottieanimation.animate().translationY(1400f).setDuration(5000).setStartDelay(4000)
//        appname.animate().translationY(1400f).setDuration(5000).setStartDelay(4000)

        handler = Handler()
        handler.postDelayed({val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()

        }, 4000) //  delaying 3 seconds to open main activity
    }
}


