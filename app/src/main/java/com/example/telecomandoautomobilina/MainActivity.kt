package com.example.telecomandoautomobilina

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.chromium.net.CronetEngine
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()
        val myBuilder = CronetEngine.Builder(applicationContext)
        val cronetEngine = myBuilder.build()
        val executor = Executors.newSingleThreadExecutor()
        forwardButton.setOnClickListener {
            val url = "http://192.168.1.1/forward"
            val request = cronetEngine.newUrlRequestBuilder(
                url, MyUrlRequestCallback(), executor
            ).build()
            var statusListener = MyUrlStatusListener()
            request.getStatus(statusListener)
            request.start()
            if(!statusListener.deviceFound){
                Toast.makeText(applicationContext, R.string.ESPNotFound, Toast.LENGTH_SHORT).show()
            }
            statusListener.deviceFound = false
        }
        forwardLeftButton.setOnClickListener {
            val url = "http://192.168.1.1/forwardLeft"
            val request = cronetEngine.newUrlRequestBuilder(
                url, MyUrlRequestCallback(), executor
            ).build()
            var statusListener = MyUrlStatusListener()
            request.getStatus(statusListener)
            request.start()
            if(!statusListener.deviceFound){
                Toast.makeText(applicationContext, R.string.ESPNotFound, Toast.LENGTH_SHORT).show()
            }
            statusListener.deviceFound = false
        }
        forwardRightButton.setOnClickListener {
            val url = "http://192.168.1.1/forwardRight"
            val request = cronetEngine.newUrlRequestBuilder(
                url, MyUrlRequestCallback(), executor
            ).build()
            var statusListener = MyUrlStatusListener()
            request.getStatus(statusListener)
            request.start()
            if(!statusListener.deviceFound){
                Toast.makeText(applicationContext, R.string.ESPNotFound, Toast.LENGTH_SHORT).show()
            }
            statusListener.deviceFound = false
        }
        backLeftButton.setOnClickListener {
            val url = "http://192.168.1.1/backLeft"
            val request = cronetEngine.newUrlRequestBuilder(
                url, MyUrlRequestCallback(), executor
            ).build()
            var statusListener = MyUrlStatusListener()
            request.getStatus(statusListener)
            request.start()
            if(!statusListener.deviceFound){
                Toast.makeText(applicationContext, R.string.ESPNotFound, Toast.LENGTH_SHORT).show()
            }
            statusListener.deviceFound = false
        }
        backRightButton.setOnClickListener{
            val url = "http://192.168.1.1/backRight"
            val request = cronetEngine.newUrlRequestBuilder(
                url, MyUrlRequestCallback(), executor
            ).build()
            var statusListener = MyUrlStatusListener()
            request.getStatus(statusListener)
            request.start()
            if(!statusListener.deviceFound){
                Toast.makeText(applicationContext, R.string.ESPNotFound, Toast.LENGTH_SHORT).show()
            }
            statusListener.deviceFound = false
        }
        backButton.setOnClickListener {
            val url = "http://192.168.1.1/back"
            val request = cronetEngine.newUrlRequestBuilder(
                url, MyUrlRequestCallback(), executor
            ).build()
            var statusListener = MyUrlStatusListener()
            request.getStatus(statusListener)
            request.start()
            if(!statusListener.deviceFound){
                Toast.makeText(applicationContext, R.string.ESPNotFound, Toast.LENGTH_SHORT).show()
            }
            statusListener.deviceFound = false
        }
    }
}
