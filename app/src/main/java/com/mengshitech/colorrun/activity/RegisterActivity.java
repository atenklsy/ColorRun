package com.mengshitech.colorrun.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.mengshitech.colorrun.R;

/**
 * atenklsy
 */
public class RegisterActivity extends Activity implements OnClickListener {
	EditText etPhone, etRegPwd1, etRegPwd2, etVerificCode;
	Button btnVerificCode, btnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		initView();
	}

	private void initView() {

		etPhone = (EditText) findViewById(R.id.etPhone);
		etRegPwd1 = (EditText) findViewById(R.id.etRegPwd1);
		etRegPwd2 = (EditText) findViewById(R.id.etRegPwd2);
		etVerificCode = (EditText) findViewById(R.id.etVerificCode);
		btnVerificCode = (Button) findViewById(R.id.btnVerificCode);
		btnVerificCode.setOnClickListener(this);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		btnRegister.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnVerificCode:
			// 获取验证码的点击事件
			/**
			 * 发送验证码的逻辑
			 */
			break;
		case R.id.btnRegister:
			// 注册的点击事件
			/**
			 * 注册验证的逻辑
			 */
			break;

		default:
			break;
		}
	}
}
