package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        testTextView = findViewById(R.id.text_to_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.font_small) {
            testTextView.setTextSize(10);  // 设置小号字体
            return true;
        } else if (itemId == R.id.font_medium) {
            testTextView.setTextSize(16);  // 设置中号字体
            return true;
        } else if (itemId == R.id.font_large) {
            testTextView.setTextSize(20);  // 设置大号字体
            return true;
        } else if (itemId == R.id.normal_item) {
            Toast.makeText(this, "你点击了普通菜单项", Toast.LENGTH_SHORT).show();  // 显示Toast
            return true;
        } else if (itemId == R.id.color_red) {
            testTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));  // 设置字体为红色
            return true;
        } else if (itemId == R.id.color_black) {
            testTextView.setTextColor(getResources().getColor(android.R.color.black));  // 设置字体为黑色
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
