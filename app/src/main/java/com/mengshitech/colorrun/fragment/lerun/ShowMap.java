package com.mengshitech.colorrun.fragment.lerun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mengshitech.colorrun.R;

/**
 * Created by Administrator on 2016/7/15.
 */
public class ShowMap extends Fragment{
    View showmap_view;
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        showmap_view = View.inflate(getActivity(), R.layout.lerun_into_showmap, null);
        ImageView showmap = (ImageView)showmap_view.findViewById(R.id.into_lerun_showmap);
        showmap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                getFragmentManager().popBackStack();
            }
        });
        return showmap_view;
    }
}
