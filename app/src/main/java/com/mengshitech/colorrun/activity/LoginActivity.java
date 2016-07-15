package com.mengshitech.colorrun.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;

/**
 * atenklsy
 */
public class LoginActivity extends Activity implements OnClickListener {
    EditText etUserId, etUserPwd;
    Button btnLogin, btnRegister;
    SharedPreferences spAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {

        spAccount = getSharedPreferences("sp_account", MODE_PRIVATE);
        // sharedpreferences
        etUserId = (EditText) findViewById(R.id.etUserId);
        // 用户名输入框
        etUserPwd = (EditText) findViewById(R.id.etUserpwd);
        // 密码输入框
        btnLogin = (Button) findViewById(R.id.btnLogin);
        // 登录按钮
        btnLogin.setOnClickListener(this);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        // 注册按钮
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                // 登录按钮的点击事件
                String userId = etUserId.getText().toString();
                String userPwd = etUserPwd.getText().toString();
                setAccount2SP(userId, userPwd);
                // 将账号密码存入sharedpreferences
                if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(userPwd)) {
                    // 账号或密码为空
                    Toast.makeText(LoginActivity.this, "请输入正确的账号和密码",
                            Toast.LENGTH_SHORT);
                    etUserId.setText("");
                    etUserPwd.setText("");
                    etUserId.setFocusable(true);
                } else {
                    // 否则跳转到主页面，并且将用户名传入
                    Intent turn2mainIntent = new Intent(LoginActivity.this,
                            MainActivity.class);
                    turn2mainIntent.putExtra("userId", userId);
                    // turn2mainIntent.putExtra("userPwd", userPwd);
                    startActivity(turn2mainIntent);
                    finish();
                }

                break;
            case R.id.btnRegister:
                // 注册按钮的点击事件
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

            default:
                break;
        }
    }

    @SuppressLint("CommitPrefEdits")
    private void setAccount2SP(String userId, String userPwd) {
        SharedPreferences.Editor editor = spAccount.edit();
        editor.putString("userId", userId);
        editor.putString("userPwd", userPwd);
        editor.commit();
    }

}
