package com.mengshitech.colorrun.fragment.show;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.ShowAdapter;
import com.mengshitech.colorrun.bean.ShowEntity;
import com.mengshitech.colorrun.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class showFragment extends Fragment implements View.OnClickListener {
    View showView;
    ImageView ivShow_CreateShow;
    ListView lvShowContent;
    List<ShowEntity> mShowList;
    FragmentManager fm;
    private Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        showView = View.inflate(mActivity, R.layout.fragment_show, null);
        findById();
        initDatas();
        return showView;
    }


    /**
     * 初始化控件
     */
    private void findById() {
        initShow();
        lvShowContent = (ListView) showView.findViewById(R.id.lvShowContent);
        ivShow_CreateShow = (ImageView) showView.findViewById(R.id.ivShow_CreateShow);

    }


    /**
     * 加载数据
     */
    private void initDatas() {
        fm = getActivity().getSupportFragmentManager();
        lvShowContent.setAdapter(new ShowAdapter(mActivity, mShowList, lvShowContent, fm));
        ivShow_CreateShow.setOnClickListener(this);
    }

    /**
     * 初始化ShowList
     */
    private void initShow() {
        mShowList = new ArrayList<ShowEntity>();
        ShowEntity mShowEntity1 = new ShowEntity();
        mShowEntity1.setIvUserHead(R.mipmap.image_head);
        mShowEntity1.setTvShow_UserName("我叫小灰灰");
        mShowEntity1.setIvShowPic(R.mipmap.historybackground);
        mShowEntity1.setTvWordContent("#爱上乐跑#本期跑者Vinglu，他完成了“为爱同行”2016南昌乐跑公益活动，感慨道，“跑了就懂，只要坚持，蜗牛也是牛！”。");
        mShowEntity1.setTvSendTime("2016年7月11日15:25");
        mShowEntity1.setTvShow_Heart("129");
        mShowEntity1.setTvShow_Comment("221");
        mShowList.add(mShowEntity1);

        ShowEntity mShowEntity2 = new ShowEntity();
        mShowEntity2.setIvUserHead(R.mipmap.image_head);
        mShowEntity2.setTvShow_UserName("陈永银");
        mShowEntity2.setIvShowPic(R.mipmap.historybackground);
        mShowEntity2.setTvWordContent("#爱上乐跑#本期跑者Vinglu，他完成了“为爱同行”2016南昌乐跑公益活动，感慨道，“跑了就懂，只要坚持，蜗牛也是牛！”。");
        mShowEntity2.setTvSendTime("2016年7月12日11:25");
        mShowEntity2.setTvShow_Heart("12");
        mShowEntity2.setTvShow_Comment("61");
        mShowList.add(mShowEntity2);

        ShowEntity mShowEntity3 = new ShowEntity();
        mShowEntity3.setIvUserHead(R.mipmap.image_head);
        mShowEntity3.setTvShow_UserName("康惠聪");
        mShowEntity3.setIvShowPic(R.mipmap.historybackground);
        mShowEntity3.setTvWordContent("#爱上乐跑#本期跑者Vinglu，他完成了“为爱同行”2016南昌乐跑公益活动，感慨道，“跑了就懂，只要坚持，蜗牛也是牛！”。");
        mShowEntity3.setTvSendTime("2016年7月13日09:25");
        mShowEntity3.setTvShow_Heart("29");
        mShowEntity3.setTvShow_Comment("113");
        mShowList.add(mShowEntity3);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivShow_CreateShow:
                CreateShowFragment mCreateShowFragment = new CreateShowFragment();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("mShowEntity",mShowEntity);
//                mCreateShowFragment.setArguments(bundle);
                Utility.replace2DetailFragment(fm, mCreateShowFragment);
                break;
            default:
                break;
        }
    }
}
