package com.example.sisters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import java.net.URL

class FoundersFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_founders, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<WebView>(R.id.founders).apply {
            loadUrl("https://ihmrsistersggogonya.org/ihrm-history/#")
            settings.allowContentAccess = true
            settings.javaScriptEnabled = true
            settings.useWideViewPort = true
            settings.domStorageEnabled = true

        }
        super.onViewCreated(view, savedInstanceState)

    }
}