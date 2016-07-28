package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.utils.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atenklsy on 2016/7/18 15:14.
 * E-address:atenk@qq.com.
 */
public class ChooseImageAdapter extends BaseAdapter implements View.OnClickListener {
    Activity mActivity, mmActivity;
    List<Bitmap> mImageList;
    GridView gvChooseImage;
    ImageView ivChooseImg;
    List<ImageView> imgList;
    AlertDialog.Builder builder;
    ImageView clickImg;
    onRecallAdapterWidget mWidget;


    public ChooseImageAdapter(Activity activity, List<Bitmap> imgList, GridView gridView) {
        mActivity = activity;
        mImageList = imgList;
        gvChooseImage = gridView;
    }

    @Override
    public int getCount() {
        return mImageList.size() ;
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
        Bitmap mBitmap = mImageList.get(position);
        convertView = View.inflate(mActivity, R.layout.item_chooseimage, null);
        ivChooseImg = (ImageView) convertView.findViewById(R.id.ivChooseImg);
        ivChooseImg.setImageBitmap(mBitmap);
        ivChooseImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ivChooseImg.setTag(position);
        gvClick(position);
        return convertView;

    }

    /**
     * GridView中每一个子控件的点击响应事件
     *
     * @param clickPostion
     */

    private void gvClick(int clickPostion) {
        imgList = new ArrayList<ImageView>();
        for (int i = 0; i <= getItemId(clickPostion); i++) {
            imgList.add(ivChooseImg);
        }
        clickImg = imgList.get(mImageList.size());
        clickImg.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        //在这个地方，选择图片并更新List，用到线程
        builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("选择相片")
                .setMessage("您确定要从相册选择相片吗？")
                .setNegativeButton("取消"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                .setPositiveButton("确定"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mWidget.solve();

                            }
                        }).create().show();

    }

    public void setmActivity(onRecallAdapterWidget widget) {
        mWidget = widget;
    }

    public interface onRecallAdapterWidget {
        void solve();
    }


}
