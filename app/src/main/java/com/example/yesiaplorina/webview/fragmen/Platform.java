package com.example.yesiaplorina.webview.fragmen;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yesiaplorina.webview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Platform extends Fragment {


    public Platform() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_platform, container, false);
    }

    //1

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //2

        String urlPlatform = "https://developer.android.com/about/";

        //3

        WebView wvPlatform = view.findViewById(R.id.wv_platform);

        //4

        wvPlatform.loadUrl(urlPlatform);
        wvPlatform.getSettings().setJavaScriptEnabled(true);

        //5
        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "", "Loading...");
        wvPlatform.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }
}
