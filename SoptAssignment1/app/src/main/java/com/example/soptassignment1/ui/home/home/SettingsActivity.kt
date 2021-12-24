package com.example.soptassignment1.ui.home.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.example.soptassignment1.R
import com.example.soptassignment1.SOPTSharedPreferences
import com.example.soptassignment1.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toggleAutoLogin()
        setContentView(binding.root)
    }

    private fun toggleAutoLogin() {
        binding = ActivitySettingsBinding.inflate(layoutInflater)

        if(SOPTSharedPreferences.getAutoLogin(this)) {
            binding.swLoginSetting.isChecked = true
        }

        binding.swLoginSetting.setOnCheckedChangeListener { _, check ->
            if (check) {
                SOPTSharedPreferences.setAutoLogin(this, binding.swLoginSetting.isChecked)
            } else {
                SOPTSharedPreferences.removeAutoLogin(this)
            }
        }
    }

}
