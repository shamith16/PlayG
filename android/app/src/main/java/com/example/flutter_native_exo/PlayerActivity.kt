package com.example.flutter_native_exo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flutter_native_exo.databinding.ActivityPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private lateinit var root: View
    private lateinit var player: ExoPlayer
    private lateinit var playerView: StyledPlayerView
    private lateinit var mediaLink: String
    private lateinit var mediaItem: MediaItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        root = binding.root
        setContentView(root)
        mediaLink = intent.extras?.get("medialink") as String
        mediaItem =
            MediaItem.fromUri(mediaLink)
        player = ExoPlayer.Builder(this).build()

        playerView = binding.playView

        playerView.player = player

        player.setMediaItem(mediaItem)

        player.prepare()

        player.play()
    }

    override fun onStop() {
        super.onStop()
        player.pause()
    }

    override fun onRestart() {
        super.onRestart()
        player.play()
    }

    override fun onResume() {
        super.onResume()
        player.play()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        player.release()
        Log.e("qwertyuiop",player.playbackState.toString())
        finish()
    }
}