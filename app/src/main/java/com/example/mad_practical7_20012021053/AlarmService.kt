package com.example.mad_practical7_20012021053

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class AlarmService : Service() {
    private var mp: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent != null) {
            mp = MediaPlayer.create(this, R.raw.alarm)
            mp?.start()
            Toast.makeText(this,"Alarm Started !",Toast.LENGTH_LONG).show()
        }
        return START_STICKY
    }
    override fun onDestroy() {
        mp?.stop()
        Toast.makeText(this,"Alarm Stopped !",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
}