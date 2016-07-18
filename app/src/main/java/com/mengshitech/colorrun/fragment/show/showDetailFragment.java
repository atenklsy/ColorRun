package com.mengshitech.colorrun.fragment.show;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.ShowDetailCommentAdpter;
import com.mengshitech.colorrun.bean.CommentEntity;
import com.mengshitech.colorrun.bean.ShowEntity;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.Utility;
import com.mengshitech.colorrun.view.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atenklsy on 2016/7/14 22:03.
 * E-address:atenk@qq.com.
 */
public class showDetailFragment extends BaseFragment {
    View showDetailView;
    //整体布局
    View mBottomView;
    //底部点赞、评论、时间，在这里隐藏
    TextView tvShow_UserName, tvWordContent, ivSendComment;
    ImageView ivShow_UserHead, ivShowPic;
    MyListView lvShowDetail_Comment;//展示评论的ListView
    List<CommentEntity> mCommentList;//评论列表
    EditText etSendComment;//评论的编辑
    ShowEntity mShowEntity;//show的实体内容
    RelativeLayout rlShowDetail;

    @Override
    public View initView() {
        showDetailView = View.inflate(getActivity(), R.layout.fragment_showdetail, null);
        findById();
        initDatas();
        return showDetailView;
    }


    private void findById() {
        mBottomView = showDetailView.findViewById(R.id.rlShowBottom);
        ivShow_UserHead = (ImageView) showDetailView.findViewById(R.id.ivShow_UserHead);//头像
        tvShow_UserName = (TextView) showDetailView.findViewById(R.id.tvShow_UserName);//昵称
        ivShowPic = (ImageView) showDetailView.findViewById(R.id.ivShowPic);//图片内容
        tvWordContent = (TextView) showDetailView.findViewById(R.id.tvWordContent);//文字内容
        lvShowDetail_Comment = (MyListView) showDetailView.findViewById(R.id.lvShowDetail_Comment);
        etSendComment = (EditText) showDetailView.findViewById(R.id.etSendComment);//
        ivSendComment = (TextView) showDetailView.findViewById(R.id.ivSendComment);
        rlShowDetail = (RelativeLayout) showDetailView.findViewById(R.id.rlShowDetail);
    }

    private void initDatas() {
        initComment();
        mShowEntity = (ShowEntity) getArguments().getSerializable("mShowEntity");
        Log.d("atenklsy", "mShowEntity的数据" + mShowEntity.getTvShow_UserName());
        mBottomView.setVisibility(View.GONE);//将底部的点赞、评论、分享隐藏
        ivShow_UserHead.setImageResource(mShowEntity.getIvUserHead());
        tvShow_UserName.setText(mShowEntity.getTvShow_UserName());
        ivShowPic.setImageResource(mShowEntity.getIvShowPic());
        tvWordContent.setText(mShowEntity.getTvWordContent());
        lvShowDetail_Comment.setAdapter(new ShowDetailCommentAdpter(mActivity, mCommentList, lvShowDetail_Comment));
        Utility.changeDrawableDirection(ivSendComment, R.mipmap.comment_send, 3);
        Utility.back2Father(rlShowDetail, mActivity);
    }


    /**
     * 模拟评论数据，暂时用
     */
    private void initComment() {
        mCommentList = new ArrayList<CommentEntity>();
        CommentEntity mCommentEntity1 = new CommentEntity();
        mCommentEntity1
                .setIvUserHead(R.mipmap.image_head);
        mCommentEntity1.setTvUserName("小灰灰");
        mCommentEntity1.setTvCommentContent("干得漂亮！");
        mCommentEntity1.setTvSendTime("2016-07-12 09:12");
        mCommentList.add(mCommentEntity1);
        CommentEntity mCommentEntity2 = new CommentEntity();
        mCommentEntity2
                .setIvUserHead(R.mipmap.image_head);
        mCommentEntity2.setTvUserName("陈永银");
        mCommentEntity2.setTvCommentContent("就知道你这么厉害！");
        mCommentEntity2.setTvSendTime("2016-07-12 09:19");
        mCommentList.add(mCommentEntity2);
        CommentEntity mCommentEntity3 = new CommentEntity();
        mCommentEntity3
                .setIvUserHead(R.mipmap.image_head);
        mCommentEntity3.setTvUserName("康惠聪");
        mCommentEntity3.setTvCommentContent("哎哟不错哦！");
        mCommentEntity3.setTvSendTime("2016-07-12 11:42");
        mCommentList.add(mCommentEntity3);
    }
}
