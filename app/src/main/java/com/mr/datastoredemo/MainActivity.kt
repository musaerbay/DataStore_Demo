package com.mr.datastoredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.mr.datastoredemo.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

/*
    private lateinit var dataStore: DataStore<Preferences>  // Create DataStore object
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*
        dataStore = createDataStore(name = "settings") // DataStore initializing
*/

        //  Get key and value from user  When the btnSave is clicked
        binding.btnSave.setOnClickListener {
            lifecycleScope.launch {
                save(
                    binding.etSaveKey.text.toString(),
                    binding.etSaveValue.text.toString()
                )
            }
        }

        // Value checks null or full When the btnRead is clicked
        binding.btnRead.setOnClickListener {
            lifecycleScope.launch {
                val value = read(binding.etReadkey.text.toString())
                binding.tvReadValue.text = value ?: "No value found"
            }
        }
    }

    // Save a value for key in DataStore
    private suspend fun save(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        myDataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    // return value corresponding to key
    private suspend fun read(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = myDataStore.data.first()
        return preferences[dataStoreKey]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}