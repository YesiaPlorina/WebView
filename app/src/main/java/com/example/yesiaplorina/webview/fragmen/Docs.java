package com.example.yesiaplorina.webview.fragmen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yesiaplorina.webview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Docs extends Fragment {


    public Docs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_docs, container, false);
    }

}
