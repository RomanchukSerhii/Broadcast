package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            ACTION_CLICKED -> {
                val clickedCount = intent.getIntExtra(CLICKED_COUNT, 0)
                Toast.makeText(context, "Clicked $clickedCount times", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "Battery is low", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "Airplane mode is changed, Turned on: $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        const val ACTION_CLICKED = "clicked"
        private const val CLICKED_COUNT = "clicked count"
        fun getIntent(count: Int): Intent {
            return Intent().apply {
                action = ACTION_CLICKED
                putExtra(CLICKED_COUNT, count)
            }
        }
    }
}