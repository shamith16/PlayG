package com.example.flutter_native_exo

import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister
import io.flutter.plugin.common.MethodChannel



class MainActivity : FlutterActivity() {

    private val CHANNEL = "player.flutter.app/player"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegister.registerGeneratedPlugins(FlutterEngine(this@MainActivity))
        flutterEngine?.dartExecutor?.let {
            MethodChannel(it, CHANNEL).setMethodCallHandler { call, result ->
                if (call.method.equals("playVideo")) {
                    val hashMap = call.arguments as HashMap<*,*>
                    val mediaLink: String = hashMap["link"] as String
                    openPlayerActivity(mediaLink)
                    result.success("true")
                }

            }
        }
    }

    private fun openPlayerActivity(l: String) {
        val intent = Intent(this@MainActivity, PlayerActivity::class.java)
        intent.putExtra("medialink", l)
        println("This is intent extra from Main: " + intent.getStringExtra("medialink"))
        startActivity(intent)
    }

}
