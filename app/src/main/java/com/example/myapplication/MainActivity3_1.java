package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity3_1 extends AppCompatActivity {

    // 动物名称
    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    // 图片资源，注意：替换为你自己的图片路径
    private int[] images = {
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // 绑定 ListView 和 TextView
        ListView listView = findViewById(R.id.listView);
        TextView selectedItem = findViewById(R.id.selectedItem);

        // 准备数据
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("image", images[i]);
            data.add(map);
        }

        // 设置 SimpleAdapter
        String[] from = {"name", "image"};
        int[] to = {R.id.item_name, R.id.item_image};
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);
        listView.setAdapter(adapter);

        // 设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = names[position];
                // 显示 Toast
                Toast.makeText(MainActivity3_1.this, name, Toast.LENGTH_SHORT).show();
                // 更新选中的项目
                selectedItem.setText(name);
            }
        });
    }
}
