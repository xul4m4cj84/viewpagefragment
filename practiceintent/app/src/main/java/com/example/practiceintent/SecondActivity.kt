package com.example.practiceintent

import android.app.Activity
import android.content.Intent

class SecondActivity {
    binding.button2.setOnClickListener {
        val intent = Intent()
        intent.putExtra("Message", "No problem")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun finish() {
        TODO("Not yet implemented")
    }

}