package com.mr.datastoredemo

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

//extension for Create data store
val Context.myDataStore by preferencesDataStore(
    name = "settings"
)
