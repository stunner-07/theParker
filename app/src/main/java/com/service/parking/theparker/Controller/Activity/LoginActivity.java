package com.service.parking.theparker.Controller.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.service.parking.theparker.ActivityAnimator;
import com.service.parking.theparker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {

    @BindView(R.id.btn_sign_up)
    Button mLogin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        try {
            ActivityAnimator.fadeAnimation(this);
        } catch (Exception ignore) {}

        mLogin_btn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, MobileVerifyActivity.class)));
    }
}
