package com.example.jetpackcompose.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Request

suspend fun getDatoPerturbador(): String? = withContext(Dispatchers.IO) {
    val request = Request.Builder()
        .url("https://monsterballgo.com/api/datoperturbador") // <= HTTPS
        .header("Accept", "text/plain, */*")
        .build()

    val response = HttpClient.client.newCall(request).execute()
    if (!response.isSuccessful) return@withContext null
    response.body?.string()?.trim().takeUnless { it.isNullOrBlank() }
}
