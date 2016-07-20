package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mengshitech.colorrun.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kanghuicong on 2016/7/18  8:47.
 * 515849594@qq.com
 */
public class MeChooseSex extends Activity {
    private RadioGroup radioGroup;
    private String sex;
    private String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO �Զ���ɵķ������
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.me_choose_sex);

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        userid = bundle.getString("userid");

        radioGroup = (RadioGroup) findViewById(R.id.chosesex_radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {

                int radioButtonId = arg0.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(radioButtonId);
                sex = rb.getText().toString();

//                new Thread(runnable).start();

            }
        });

    }
//
//    Handler handler = new Handler() {
//
//        public void handleMessage(Message msg) {
//            Bundle bundle = msg.getData();
//            String result = bundle.getString("result");
//            // 判断服务器端修改密码是否成功，如果成功则关闭当前页面 并更新sqlite数据库
//            if (result.equals("1")) {
//                Intent intent2 = getIntent();
//                Bundle bundle2 = new Bundle();
//                bundle.putCharSequence("sex", sex);
//                intent2.putExtras(bundle2);
//                setResult(003, intent2);
//                Toast.makeText(MeChooseSex.this, "修改性别成功", Toast.LENGTH_SHORT)
//                        .show();
//                finish();
//
//            } else {
//                Toast.makeText(MeChooseSex.this, "修改性别失败", Toast.LENGTH_SHORT)
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
//            map.put("type", "sex");
//            map.put("index", "3");
//            map.put("values", sex);
//
//            String result = util.HttpUtils.sendHttpClientPost(path, map,
//                    "utf-8");
//
//            Message msg = new Message();
//            Bundle bundle = new Bundle();
//            bundle.putString("result", result);
//            msg.setData(bundle);
//
//            handler.sendMessage(msg);
//
//        }
//    };

}