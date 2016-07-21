package com.mengshitech.colorrun.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * Created by kanghuicong on 2016/7/21  9:36.
 * 515849594@qq.com
 */
public class DialogUtility {


    //修改电话号码
    public static void DialogPhone(final Context context, final TextView tv_phone){
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_phone, null);
        final Dialog dialog = new AlertDialog.Builder(context).create();

        addDialog(dialog,layout);

        final EditText et_inputnumber = (EditText)layout.findViewById(R.id.et_inputnumber);
        Button inputnumber_cancel = (Button)layout.findViewById(R.id.btn_inputnumber_cancel);
        Button inputnumner_ok = (Button)layout.findViewById(R.id.btn_inputnumner_ok);
        Button inputnumber_clear = (Button)layout.findViewById(R.id.btn_inputnumber_clear);

        //取消退出对话框
        inputnumber_cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { dialog.dismiss(); }
        });
        //确认输入的号码
        inputnumner_ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String phone = et_inputnumber.getText().toString();
                if (phone.trim().length() == 11){
                    tv_phone.setText(phone);
                    dialog.dismiss();
                }
                else {
                    Toast.makeText(context, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                }
            }

        });
        //清除输入的号码
        inputnumber_clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { et_inputnumber.setText(""); }
        });
    }

    //选择性别
    public static void DialogSex(final Context context, final TextView tv_sex){

        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_sex, null);
        addDialog(dialog,layout);

        RadioGroup radioGroup = (RadioGroup)layout .findViewById(R.id.chosesex_radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {

                int radioButtonId = arg0.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) layout.findViewById(radioButtonId);
                String sex = rb.getText().toString();
                tv_sex.setText(sex);
                dialog.dismiss();
            }
        });
    }

    //修改昵称
    public static void DialogNickname(final Context context, final TextView tv_nickname){
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_nickname, null);
        addDialog(dialog,layout);

        final EditText revise_nickname = (EditText)layout.findViewById(R.id.et_me_revise_nickname);
        Button bt_nickname_conservation = (Button)layout.findViewById(R.id.bt_me_nickname_conservation);

        bt_nickname_conservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = revise_nickname.getText().toString();
                if (nickname.isEmpty()) {
                    Toast.makeText(context, "请输入昵称", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    tv_nickname.setText(nickname);
                    dialog.dismiss();
                }
            }
        });

    }

    //修改个性签名
    public static void DialogAutograph(final Context context, final TextView tv_autograph){
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_autograph, null);
        addDialog(dialog,layout);

        final EditText revise_autograph = (EditText)layout.findViewById(R.id.et_autograph);
        Button bt_autograph_conservation = (Button)layout.findViewById(R.id.bt_autograph_conservation);

        bt_autograph_conservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autograph = revise_autograph.getText().toString();
                if (autograph.isEmpty()) {
                    Toast.makeText(context, "请输入个性签名", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    tv_autograph.setText(autograph);
                    dialog.dismiss();
                }
            }
        });
    }

    //修改体重和身高
    public static void DialogPhysique(String type,final Context context,final TextView tv_physique){
        LayoutInflater inflater = LayoutInflater.from(context);
        final Dialog dialog = new AlertDialog.Builder(context).create();
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_detail_physique, null);
        addDialog(dialog,layout);

        TextView title = (TextView)layout.findViewById(R.id.tv_physique_title);
        final EditText et_physique = (EditText)layout.findViewById(R.id.et_physique);
        TextView tv_physique_bar = (TextView)layout.findViewById(R.id.tv_physique_bar);
        Button bt_conservation = (Button)layout.findViewById(R.id.bt_physique_conservation);

        switch (type){
            case ("height"):
                title.setText("身高");
                tv_physique_bar.setText("cm");
                bt_conservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String physique = et_physique.getText().toString();
                        if (physique.isEmpty()) {
                            Toast.makeText(context, "请输入身高", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            tv_physique.setText(physique+"cm");
                            dialog.dismiss();
                        }
                    }
                });
                break;
            case ("weight"):
                bt_conservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String physique = et_physique.getText().toString();
                        if (physique.isEmpty()) {
                            Toast.makeText(context, "请输入体重", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            tv_physique.setText(physique+"kg");
                            dialog.dismiss();
                        }
                    }
                });
                break;


        }
    }

    //添加窗口
    private static void addDialog(Dialog dialog,LinearLayout layout) {
        dialog.setCancelable(false);
        dialog.show();
        dialog.getWindow().setContentView(layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
    }
}
