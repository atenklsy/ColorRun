package com.mengshitech.colorrun.fragment.show;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.ChooseImageAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atenklsy on 2016/7/18 14:23.
 * E-address:atenk@qq.com.
 */
public class CreateShowFragment extends BaseFragment implements View.OnClickListener {
    View CreateShowView;
    TextView tvCreateShow_Cancel, tvCreateShow_Send;
    EditText etCreateShow_WordContent;
    GridView gvCreateShow_PicContent;
    FragmentManager fm;
    List<Bitmap> mImageList;
    ChooseImageAdapter mChooseImageAdapter;

    @Override
    public View initView() {
        CreateShowView = View.inflate(mActivity, R.layout.fragment_createshow, null);
        findById();
        initDatas();
        return CreateShowView;
    }


    private void findById() {
        tvCreateShow_Cancel = (TextView) CreateShowView.findViewById(R.id.tvCreateShow_Cancel);
        tvCreateShow_Send = (TextView) CreateShowView.findViewById(R.id.tvCreateShow_Send);
        etCreateShow_WordContent = (EditText) CreateShowView.findViewById(R.id.etCreateShow_WordContent);
        gvCreateShow_PicContent = (GridView) CreateShowView.findViewById(R.id.gvCreateShow_PicContent);
    }

    private void initDatas() {
        initImagList();
        //初始化那张选择选择的图片
        fm = getFragmentManager();
        tvCreateShow_Cancel.setOnClickListener(this);
        tvCreateShow_Send.setOnClickListener(this);
        mChooseImageAdapter = new ChooseImageAdapter(mActivity, mImageList, gvCreateShow_PicContent);
        gvCreateShow_PicContent.setAdapter(mChooseImageAdapter);
    }

    private void initImagList() {
        mImageList = new ArrayList<Bitmap>();
        Bitmap bmCHoosePic = BitmapFactory.decodeResource(getResources(), R.mipmap.choose_img);
        mImageList.add(bmCHoosePic);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("atenklsy","进来这里了");
        if (requestCode == 1) {
            if (data != null) {
                //取得返回的Uri,基本上选择照片的时候返回的是以Uri形式，但是在拍照中有得机子呢Uri是空的，所以要特别注意
                Uri mImageCaptureUri = data.getData();
                //返回的Uri不为空时，那么图片信息数据都会在Uri中获得。如果为空，那么我们就进行下面的方式获取
                if (mImageCaptureUri != null) {
                    Bitmap image;
                    try {
                        //这个方法是根据Uri获取Bitmap图片的静态方法
                        image = MediaStore.Images.Media.getBitmap(mActivity.getContentResolver(), mImageCaptureUri);
                        mImageList.add(image);
                        mChooseImageAdapter.notifyDataSetChanged();
                        gvCreateShow_PicContent.setSelection(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Toast.makeText(mActivity, "您返回的数据为空", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCreateShow_Cancel:

                //1.隐藏软键盘
                //2.取消此次发送
                fm.popBackStack();
                break;
            case R.id.tvCreateShow_Send:
                //发送到朋友圈
                //0.隐藏软键盘

                //1.将数据发送到后台

                //2.返回朋友圈并刷新数据
                Toast.makeText(mActivity, "已经发送到朋友圈了！", Toast.LENGTH_SHORT).show();
                fm.popBackStack();
                //返回到朋友圈自动刷新加载
                break;
            default:
                break;
        }
    }
}
