package com.example.myapp

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startService(Intent(this, NotificationService::class.java))
        startService(Intent(this, CameraService::class.java))
        startService(Intent(this, FlashlightService::class.java))
        startService(Intent(this, ContactsService::class.java))
        startService(Intent(this, WallpaperService::class.java))
    }
}
