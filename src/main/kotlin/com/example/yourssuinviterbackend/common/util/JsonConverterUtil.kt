package com.example.yourssuinviterbackend.common.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonConverterUtil {
    fun jsonToMap(json: String?): Map<String, String>? {
        if(json == null) return null
        val mapType = object : TypeToken<Map<String, String>>() {}.type
        return Gson().fromJson(json, mapType)
    }
}