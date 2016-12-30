package com.luck.custom;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.luck.custom.dialog.SweetAlertDialog;
import com.luck.custom.toast.T;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_ios_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SweetAlertDialog dialog = new SweetAlertDialog(MainActivity.this);
                dialog.setTitleText("请稍候...");
                dialog.show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.cancel();
                    }
                }, 2000);
            }
        });

        findViewById(R.id.btn_ios_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.showAnimToast(MainActivity.this, "恭喜您，注册成功了！");
            }
        });

        findViewById(R.id.btn_ios_toast_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.showAnimSuccessToast(MainActivity.this, "保存成功");
            }
        });

        findViewById(R.id.btn_ios_toast_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.showAnimErrorToast(MainActivity.this, "修改失败");
            }
        });
    }
}
