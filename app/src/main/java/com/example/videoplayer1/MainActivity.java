package com.example.videoplayer1;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    private WebView webView;
    private Handler handler;
    private int currentVideoIndex = 0;

    private String[] videoUrls = {
            "https://www.youtube.com/embed/gvL3q9o7s0E?autoplay=1", // Video 1
            "https://www.youtube.com/embed/Wv-VlQMD0VY?autoplay=1", // Video 2
            "https://www.youtube.com/embed/U4zZbpGR778?autoplay=1", // Video 3
            "https://www.youtube.com/embed/SvyCxiGam54?autoplay=1", // Video 4
            "https://www.youtube.com/embed/hB_DbjaTLuw?autoplay=1", // Video 5
            "https://www.youtube.com/embed/D5wzWi591U0?autoplay=1", // Video 6
            "https://www.youtube.com/embed/QY0BzJrdb0A?autoplay=1", // Video 7
            "https://www.youtube.com/embed/9XorvhAqIjU?autoplay=1", // Video 8
            "https://www.youtube.com/embed/IEn_IlJqYko?autoplay=1", // Video 9
            "https://www.youtube.com/embed/C9oizHXVEVc?autoplay=1" // Video 10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        handler = new Handler();

        // Set up the WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);

        // Enable autoplay and set up WebView clients
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

        // Start playing the first video
        playVideo();

        // Set up the handler to change videos every 30 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                playNextVideo(); // Play next video
                handler.postDelayed(this, 30000); // Repeat every 30 seconds
            }
        }, 30000); // Start after 30 seconds
    }

    // Method to play the video based on the current index
    private void playVideo() {
        String video = "<iframe width=\"100%\" height=\"100%\" src=\""
                + videoUrls[currentVideoIndex]
                + "\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html", "utf-8");
    }

    // Method to switch to the next video
    private void playNextVideo() {
        currentVideoIndex = (currentVideoIndex + 1) % videoUrls.length; // Loop back to the first video
        playVideo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null); // Clear handler callbacks
    }
}
