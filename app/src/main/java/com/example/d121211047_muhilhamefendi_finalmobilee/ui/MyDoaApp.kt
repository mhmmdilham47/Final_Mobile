package com.example.d121211047_muhilhamefendi_finalmobilee.ui

import android.app.Application
import com.example.d121211047_muhilhamefendi_finalmobilee.data.AppContainer
import com.example.d121211047_muhilhamefendi_finalmobilee.data.DefaultAppContainer

class MyDoaApp: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}