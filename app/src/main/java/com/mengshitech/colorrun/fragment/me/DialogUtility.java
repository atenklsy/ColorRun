package com.mengshitech.colorrun.fragment.me;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.UserEntiy;
import com.mengshitech.colorrun.dao.UserDao;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.HttpUtils;
import com.mengshitech.colorrun.utils.IPAddress;
import com.mengshitech.colorrun.utils.JsonTools;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kanghuicong on 2016/7/21  9:36.
 * 515849594@qq.com
 */
public class DialogUtility {
    static String userid;
    static String update_type;
    static String update_values;
    static Context Context;
    static Pattern number = Pattern.compile("[0-9]*");

    //修改电话号码
    public static void DialogPhone(final Context context, final TextView tv_phone, final String user_id) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_phone, null);
        final EditText et_inputnumber = (EditText) layout.findViewById(R.id.et_inputnumber);
        Button inputnumber_cancel = (Button) layout.findViewById(R.id.btn_inputnumber_cancel);
        Button inputnumner_ok = (Button) layout.findViewById(R.id.btn_inputnumner_ok);
        Button inputnumber_clear = (Button) layout.findViewById(R.id.btn_inputnumber_clear);

        addDialog(dialog, layout);

        //取消退出对话框
        inputnumber_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //确认输入的号码
        inputnumner_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = et_inputnumber.getText().toString();
                userid = user_id;
                update_type = "user_phone";
                update_values = phone;
                Context = context;
                Matcher m = number.matcher(phone);
                if (phone.trim().length() == 11 && m.matches()) {
                    tv_phone.setText(phone);
                    new Thread(runnable).start();
//                    UserDao dao = new UserDao(context);
//                    dao.update_data("user_phone",phone,user_id);

                    dialog.dismiss();
                } else {
                    Toast.makeText(context, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                }
            }

        });
        //清除输入的号码
        inputnumber_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_inputnumber.setText("");
            }
        });
    }

    //选择性别
    public static void DialogSex(final Context context, final TextView tv_sex, final String user_id) {

        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();

        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_sex, null);
        RadioGroup radioGroup = (RadioGroup) layout.findViewById(R.id.chosesex_radiogroup);

        addDialog(dialog, layout);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {

                int radioButtonId = arg0.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) layout.findViewById(radioButtonId);
                String sex = rb.getText().toString();
                userid = user_id;
                update_type = "user_sex";
                update_values = sex;
                Context = context;
                new Thread(runnable).start();
                tv_sex.setText(sex);

//                UserDao dao = new UserDao(context);
//                dao.update_data("user_sex",sex,user_id);

                dialog.dismiss();
            }
        });
    }

    //修改昵称
    public static void DialogNickname(final Context context, final TextView tv_nickname, final String user_id) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();

        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_nickname, null);
        final EditText revise_nickname = (EditText) layout.findViewById(R.id.et_me_revise_nickname);
        Button bt_nickname_conservation = (Button) layout.findViewById(R.id.bt_me_nickname_conservation);

        addDialog(dialog, layout);
        revise_nickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        bt_nickname_conservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = revise_nickname.getText().toString();
                userid = user_id;
                update_type = "user_name";
                update_values = nickname;
                Context = context;
                if (nickname.isEmpty()) {
                    Toast.makeText(context, "请输入昵称", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    tv_nickname.setText(nickname);
                    new Thread(runnable).start();
//                    UserDao dao = new UserDao(context);
//                    dao.update_data("user_name",nickname,user_id);

                    dialog.dismiss();
                }
            }
        });

    }

    //修改个性签名和邮箱
    public static void DialogAutograph(String type, final Context context, final TextView tv_conent, final String user_id) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();

        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_autograph, null);
        final EditText revise_content = (EditText) layout.findViewById(R.id.et_autograph);
        TextView title_content = (TextView) layout.findViewById(R.id.title_autograph);
        Button bt_content_conservation = (Button) layout.findViewById(R.id.bt_autograph_conservation);

        addDialog(dialog, layout);

        switch (type) {
            case ("sign"):
                revise_content.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                bt_content_conservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sign = revise_content.getText().toString();
                        userid = user_id;
                        update_type = "user_sign";
                        update_values = sign;
                        Context = context;
                        if (sign.isEmpty()) {
                            Toast.makeText(context, "请输入个性签名", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            tv_conent.setText(sign);
                            new Thread(runnable).start();
//                            UserDao dao = new UserDao(context);
//                            dao.update_data("uesr_sign",autograph,user_id);
                            dialog.dismiss();
                        }
                    }
                });
                break;
            case ("email"):
                title_content.setText("邮箱");
                bt_content_conservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = revise_content.getText().toString();
                        userid = user_id;
                        update_type = "user_email";
                        update_values = email;
                        Context = context;
                        if (email.isEmpty()) {
                            Toast.makeText(context, "请输入邮箱", Toast.LENGTH_SHORT)
                                    .show();
                        } else if (email == "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$") {
                            tv_conent.setText(email);
                            new Thread(runnable).start();
//                            UserDao dao = new UserDao(context);
//                            dao.update_data("uesr_email", email, user_id);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(context, "请输入正确的邮箱", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
                break;

        }

    }

    //修改体重和身高
    public static void DialogPhysique(String type, final Context context, final TextView tv_physique, final String user_id) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();

        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_physique, null);
        TextView title = (TextView) layout.findViewById(R.id.tv_physique_title);
        final EditText et_physique = (EditText) layout.findViewById(R.id.et_physique);
        TextView tv_physique_bar = (TextView) layout.findViewById(R.id.tv_physique_bar);
        Button bt_conservation = (Button) layout.findViewById(R.id.bt_physique_conservation);

        addDialog(dialog, layout);
        et_physique.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});

        switch (type) {
            case ("height"):
                title.setText("身高");
                tv_physique_bar.setText("cm");
                bt_conservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String physique = et_physique.getText().toString();
                        userid = user_id;
                        update_type = "user_height";
                        update_values = physique;
                        Context = context;
                        Matcher m = number.matcher(physique);
                        if (m.matches()) {
                            tv_physique.setText(physique + "cm");
                            new Thread(runnable).start();
//                            UserDao dao = new UserDao(context);
//                            dao.update_data("user_height",physique+"cm",user_id);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(context, "请输入身高", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
                break;
            case ("weight"):
                bt_conservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String physique = et_physique.getText().toString();
                        userid = user_id;
                        update_type = "user_weight";
                        update_values = physique;
                        Context = context;
                        Matcher m = number.matcher(physique);
                        if (m.matches()) {
                            tv_physique.setText(physique + "kg");
                            new Thread(runnable).start();
//                            UserDao dao = new UserDao(context);
//                            dao.update_data("user_weight",physique+"kg",user_id);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(context, "请输入体重", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
                break;
        }
    }

    //添加窗口
    private static void addDialog(Dialog dialog, LinearLayout layout) {
        dialog.setCancelable(false);
        dialog.show();
        dialog.getWindow().setContentView(layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
    }

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String path = IPAddress.PATH;
            Map<String, String> map = new HashMap<String, String>();
            map.put("flag", "user");
            map.put("user_id", userid);
            map.put("update_type", update_type);
            map.put("update_values", update_values);
            map.put("index", "3");

            String result = HttpUtils.sendHttpClientPost(path, map,
                    "utf-8");

            Log.i("result", result);
            Message msg = new Message();
            msg.obj = result;
            handler.sendMessage(msg);
        }
    };
    static Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            String result = (String) msg.obj;

            Log.i("result", result);
            if (result.equals("timeout")) {
                Toast.makeText(Context, "连接服务器超时", Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(Context, "修改成功！", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };
}
