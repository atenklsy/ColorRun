package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.Utility;

import java.util.Timer;

/**
 * Created by kanghuicong on 2016/7/18  10:34.
 * 515849594@qq.com
 */
public class MeNickName extends BaseFragment implements View.OnClickListener{
    private String nickname;
    View me_nickname_view;
    ImageView title_back;
    TextView title_bar;
    EditText revise_nickname;
    Button bt_nickname_conservation;
    FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getFragmentManager();
    }

    @Override
    public View initView() {
        me_nickname_view = View.inflate(getActivity(), R.layout.me_revise_nickname,null);
        find();
        click();
        return me_nickname_view;
    }

    private void click() {
        title_back.setOnClickListener(this);
        bt_nickname_conservation.setOnClickListener(this);
    }

    private void find() {
        title_back = (ImageView)me_nickname_view.findViewById(R.id.title_back);
        title_bar = (TextView)me_nickname_view.findViewById(R.id.title_barr);
        title_bar.setText("更改名字");
        revise_nickname = (EditText)me_nickname_view.findViewById(R.id.et_me_revise_nickname);
        bt_nickname_conservation = (Button)me_nickname_view.findViewById(R.id.bt_me_nickname_conservation);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                getFragmentManager().popBackStack();
                MainActivity.rgMainBottom.setVisibility(View.GONE);
                break;
            case R.id.bt_me_nickname_conservation:
                nickname = revise_nickname.getText().toString();
                if (nickname.isEmpty()) {
                    Toast.makeText(getActivity(), "请输入昵称", Toast.LENGTH_SHORT)
                            .show();
                } else {
//                    new Thread(runnable).start();

                    myDetailFragment df = new myDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("nickname",nickname);
                    bundle.putString("type","nickname");
                    df.setArguments(bundle);
                    Utility.replace2DetailFragment(fm,df);
                }
                break;
        }
    }

//    Handler handler = new Handler() {
//
//        public void handleMessage(Message msg) {
//            Bundle bundle = msg.getData();
//            String result = bundle.getString("result");
//            // 判断服务器端修改用户名是否成功，如果成功则关闭当前页面 并更新sqlite数据库
//            if (result.equals("1")) {
//                Intent intent = getIntent();
//                Bundle bundle2 = new Bundle();
//                bundle.putCharSequence("name", name);
//                intent.putExtras(bundle2);
//                setResult(002, intent);
//                Toast.makeText(InputName.this, "修改昵称成功", Toast.LENGTH_SHORT)
//                        .show();
//
//            } else {
//                Toast.makeText(InputName.this, "修改昵称失败", Toast.LENGTH_SHORT)
//                        .show();
//            }
//
//        }
//
//    };
//
//    Runnable runnable = new Runnable() {
//
//        @Override
//        public void run() {
//            String path = ContentConstants.PATH;
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("userid", userid);
//            map.put("type", "username");
//            map.put("index", "3");
//            map.put("values", nickname);
//
//            String result = util.HttpUtils.sendHttpClientPost(path, map,
//                    "utf-8");
//
//            Message msg = new Message();
//            Bundle bundle = new Bundle();
//            bundle.putString("result", result);
//            msg.setData(bundle);
//            handler.sendMessage(msg);
//
//        }
//    };

    public void onDetach() {
        super.onDetach();
        MainActivity.rgMainBottom.setVisibility(View.GONE);
    }
}
