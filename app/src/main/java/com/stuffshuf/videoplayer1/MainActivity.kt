package com.stuffshuf.videoplayer1

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val path = "/Users/bobbysingh/AndroidStudioProjects/VideoPlayer1/app/src/main/res/raw/videos7.m4a"
        videoView?.setVideoURI(Uri.parse(path))

        val button = findViewById<Button>(R.id.button)
        button?.setOnClickListener({
            val isPlaying = videoView.isPlaying
            button.setText(if (isPlaying) R.string.play else R.string.pause)

            val msg = getString(if (isPlaying) R.string.paused else R.string.playing)
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            if (isPlaying) {
                videoView.pause()
            } else {
                videoView.start()
            }
        })
    }
}
