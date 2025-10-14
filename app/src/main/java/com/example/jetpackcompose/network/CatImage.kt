package com.example.jetpackcompose.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Request
import java.io.IOException

suspend fun getCatImage(): Bitmap? = withContext(Dispatchers.IO) {
    try {
        val request = Request.Builder()
            // fuerza nueva imagen cada vez con timestamp
            .url("https://cataas.com/cat?timestamp=${System.currentTimeMillis()}")
            .build()

        val response = HttpClient.client.newCall(request).execute()
        if (response.isSuccessful) {
            response.body?.byteStream()?.use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }
        } else {
            null
        }
    } catch (e: IOException) {
        null
    }
}
