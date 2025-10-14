package com.example.jetpackcompose.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Request
import org.json.JSONObject

suspend fun getCatFact(): String? = withContext(Dispatchers.IO) {
    val request = Request.Builder()
        .url("https://catfact.ninja/fact")
        .build()

    val response = HttpClient.client.newCall(request).execute()
    if (response.isSuccessful) {
        val body = response.body?.string()
        body?.let {
            val json = JSONObject(it)
            json.getString("fact")
        }
    } else null
}
