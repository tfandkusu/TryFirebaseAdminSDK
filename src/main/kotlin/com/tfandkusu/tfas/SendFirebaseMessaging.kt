package com.tfandkusu.tfas

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message


@Suppress("SpellCheckingInspection")
fun main(args: Array<String>) {
    // GOOGLE_APPLICATION_CREDENTIALS 環境変数のサービスキーファイル(json)を使う設定
    val options = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.getApplicationDefault())
        .setDatabaseUrl("https://quick-echo.firebaseio.com/")
        .build()

    val firebaseApp = FirebaseApp.initializeApp(options)
    val fcm = FirebaseMessaging.getInstance(firebaseApp)
    val message = Message.builder()
        .setToken("Token for test device")
        .putData("message", "メッセージです").putData("type", "開く画面の名前です")
        .build()
    val messageId = fcm.send(message)
    println("messageId = $messageId")
}