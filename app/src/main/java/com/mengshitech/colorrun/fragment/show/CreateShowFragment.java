package com.mengshitech.colorrun.fragment.show;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.ChooseImageAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;

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
        fm = getFragmentManager();
        tvCreateShow_Cancel.setOnClickListener(this);
        tvCreateShow_Send.setOnClickListener(this);
//        gvCreateShow_PicContent.setAdapter(new ChooseImageAdapter(mActivity, 布局, 数据源，gvCreateShow_PicContent);
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
