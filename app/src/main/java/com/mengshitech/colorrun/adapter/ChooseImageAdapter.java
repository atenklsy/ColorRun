package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.mengshitech.colorrun.R;

import java.util.List;

/**
 * Created by atenklsy on 2016/7/18 15:14.
 * E-address:atenk@qq.com.
 */
public class ChooseImageAdapter extends BaseAdapter {
    Context mActivity;
    List<ImageView> mImageList;
    GridView gvChooseImage;

    ChooseImageAdapter(Activity activity, List<ImageView> imgList, GridView gridView) {
        mActivity = activity;
        mImageList = imgList;
        gvChooseImage = gridView;
    }

    @Override
    public int getCount() {
        return mImageList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView mImageView = mImageList.get(position);
        convertView = View.inflate(mActivity, R.layout.item_chooseimage, null);
        ImageView ivChooseImg = (ImageView) convertView.findViewById(R.id.ivChooseImg);
//        ivChooseImg.setImageResource(mImageView);
        return convertView;

    }


}
