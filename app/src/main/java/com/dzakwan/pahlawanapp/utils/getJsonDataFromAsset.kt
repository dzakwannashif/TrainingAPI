package com.dzakwan.pahlawanapp.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            // bufferedReader fungsinya membaca json menjadi string
            it.readText()
        }
    }catch(e: IOException){

        // ketika gagal tidak ada error force close melainkan mengirim pesan error di logcat dengan tag printStackTrace
        e.printStackTrace()
        return null
    }
    return jsonString
}

/**
 * Second Way
 */
//fun getJsonFromAssets(context: Context): String? {
//    val json: String
//    try {
//        val stream = context.assets.open("pahlawanNasional.json")
//        val size = stream.available()
//        val buffer = ByteArray(size)
//        stream.read(buffer)
//        stream.close()
//        json = String(buffer, Charsets.UTF_8)
//
//    } catch (e: IOException){
//        e.printStackTrace()
//        return null
//    }
//
//    return json
//}

