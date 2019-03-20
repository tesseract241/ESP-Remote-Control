package com.example.telecomandoautomobilina

import org.chromium.net.UrlRequest

internal class MyUrlStatusListener : UrlRequest.StatusListener() {
    var deviceFound = false
    override fun onStatus(status: Int) {
        if(status==UrlRequest.Status.READING_RESPONSE){
            deviceFound = true
        }
    }
}
