package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        // 模拟在某个按钮点击时弹出对话框
        findViewById(R.id.showDialogButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        // 加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);

        // 创建 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setView(dialogView);

        // 获取布局中的控件
        EditText usernameEditText = dialogView.findViewById(R.id.username);
        EditText passwordEditText = dialogView.findViewById(R.id.password);

        // 设置按钮
        builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 获取用户输入的内容
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // 显示用户输入
                Toast.makeText(MainActivity2.this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // 显示对话框
        builder.create().show();
    }
}
