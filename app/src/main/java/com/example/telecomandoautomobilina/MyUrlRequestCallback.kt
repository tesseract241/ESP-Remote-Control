package com.example.telecomandoautomobilina

import android.widget.Toast
import org.chromium.net.CronetException
import org.chromium.net.UrlResponseInfo
import org.chromium.net.UrlRequest
import java.nio.ByteBuffer


internal class MyUrlRequestCallback : UrlRequest.Callback() {

    var myBuffer: ByteBuffer = ByteBuffer.allocate(102400)

    override fun onRedirectReceived(request: UrlRequest, info: UrlResponseInfo, newLocationUrl: String) {
        android.util.Log.i(TAG, "onRedirectReceived method called.")
        // You should call the request.followRedirect() method to continue
        // processing the request.
        request.followRedirect()
    }

    override fun onResponseStarted(request: UrlRequest, info: UrlResponseInfo) {
        val httpStatusCode = info.httpStatusCode

        if (httpStatusCode == 200) {
            // The request was fulfilled. Start reading the response.
            request.read(myBuffer)
        } else
            // The service is unavailable. You should still check if the request
            // contains some data.
            request.read(myBuffer)
    }

    override fun onReadCompleted(request: UrlRequest, info: UrlResponseInfo, byteBuffer: ByteBuffer) {
        android.util.Log.i(TAG, "onReadCompleted method called.")
        // You should keep reading the request until there's no more data.
        byteBuffer.clear()
        request.read(myBuffer)
    }

    override fun onSucceeded(request: UrlRequest, info: UrlResponseInfo) {
        android.util.Log.i(TAG, "onSucceeded method called.")
    }

    override fun onFailed(request: UrlRequest?, info: UrlResponseInfo?, error: CronetException?) {
        android.util.Log.i(TAG, "onFailed method called.")
    }

    override fun onCanceled(request : UrlRequest, info : UrlResponseInfo){
        myBuffer.clear()
    }

    companion object {
        private val TAG = "MyUrlRequestCallback"
    }
}