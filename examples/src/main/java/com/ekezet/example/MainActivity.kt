package com.ekezet.example

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onSimpleExampleClick(view: View) {
        startActivity(Intent(this, SimpleActivity::class.java))
    }

    @Suppress("UNUSED_PARAMETER")
    fun onAnimatedExampleClick(view: View) {
        startActivity(Intent(this, AnimatedActivity::class.java))
    }

    @Suppress("UNUSED_PARAMETER")
    fun onAsyncLoadingExampleClick(view: View) {
        startActivity(Intent(this, AsyncLoadingActivity::class.java))
    }

    @Suppress("UNUSED_PARAMETER")
    fun onCustomClickEventExampleClick(view: View) {
        startActivity(Intent(this, CustomClickEventActivity::class.java))
    }
}
