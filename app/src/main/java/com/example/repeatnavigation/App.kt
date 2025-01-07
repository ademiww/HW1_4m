package com.example.repeatnavigation

import android.app.Application
import android.os.Parcel
import android.os.Parcelable

class App() : Application(){

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
    }
}