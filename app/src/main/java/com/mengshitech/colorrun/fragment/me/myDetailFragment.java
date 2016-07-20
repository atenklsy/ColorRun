package com.mengshitech.colorrun.fragment.me;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.Utility;


/**
 * atenklsy
 */
public class myDetailFragment extends BaseFragment implements View.OnClickListener{
    View mDeatilView;
    FragmentManager fm;
    LinearLayout me_head,me_nickname,me_phone,me_address,me_sex,me_land,me_autograph;
    TextView tv_nickname,tv_phone,tv_sex;
    String nickname;
    private String sex;
    private PopupWindow mPopupWindow;

    @Override
    public View initView() {
        mActivity = getActivity();
        mDeatilView = View.inflate(mActivity, R.layout.fragment_mydetail, null);
        find();
        click();
        data();

//        Bundle bundle = getArguments();
//        nickname = bundle.getString("nickname");
//        tv_nickname.setText(nickname);

        return mDeatilView;
    }

    private void data() {
        Bundle bundle = getArguments();
        if(bundle!=null){
            String type = bundle.getString("type");
            switch (type){
                case "nickname":
                    tv_nickname.setText(bundle.getString("nickname"));
                    break;
                default:
                    break;
            }
        }
    }

    private void click() {
        me_sex.setOnClickListener(this);
        me_phone.setOnClickListener(this);
        me_nickname.setOnClickListener(this);
    }

    private void find() {
        me_head = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_head);
        me_nickname = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_nickname);
        tv_nickname = (TextView)mDeatilView.findViewById(R.id.tv_me_nickname);
        me_phone = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_phone);
        tv_phone = (TextView)mDeatilView.findViewById(R.id.tv_me_phone);
        me_address = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_address);
        me_sex = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_sex);
        tv_sex = (TextView) mDeatilView.findViewById(R.id.tv_me_sex);
        me_land = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_land);
        me_autograph = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_autograph);

    }

    @Override
    public void onClick(View v) {
        fm =getFragmentManager();
        switch (v.getId()){
            case R.id.ll_me_head:

                break;
            case R.id.ll_me_nickname:
                Utility.replace2DetailFragment(fm,new MeNickName());
                break;
            case R.id.ll_me_phone:
                DialogPhone();
                break;
            case R.id.ll_me_address:

                break;
            case R.id.ll_me_sex:
                DialogSex();
                break;
            case R.id.ll_me_land:

                break;
            case R.id.ll_me_autograph:

                break;

            default:
                break;
        }
    }

    //填写电话号码
    private void DialogPhone(){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_revise_phone, null);

        final Dialog dialog = new AlertDialog.Builder(getActivity()).create();
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
                    Toast.makeText(getActivity(), "请输入正确的手机号码", Toast.LENGTH_SHORT)
                            .show();
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
    private void DialogSex() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final Dialog dialog = new AlertDialog.Builder(getActivity()).create();
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.me_choose_sex, null);
        addDialog(dialog,layout);

        RadioGroup radioGroup = (RadioGroup)layout .findViewById(R.id.chosesex_radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {

                int radioButtonId = arg0.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) layout.findViewById(radioButtonId);
                sex = rb.getText().toString();
                tv_sex.setText(sex);
                dialog.dismiss();
            }
        });
    }

    //添加窗口
    private void addDialog(Dialog dialog,LinearLayout layout) {
        dialog.setCancelable(false);
        dialog.show();
        dialog.getWindow().setContentView(layout);
    }
}
