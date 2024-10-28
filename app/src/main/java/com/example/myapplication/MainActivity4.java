package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter adapter;
    private String[] items = {"One", "Two", "Three", "Four", "Five"};
    private ArrayList<Boolean> checkedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        listView = findViewById(R.id.listView);

        // 初始化检查状态
        checkedItems = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            checkedItems.add(false);
        }

        // 设置自定义适配器
        adapter = new CustomAdapter();
        listView.setAdapter(adapter);

        // 设置多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                checkedItems.set(position, checked);  // 更新选中状态
                adapter.notifyDataSetChanged();  // 刷新背景颜色
                int checkedCount = listView.getCheckedItemCount();
                mode.setTitle(checkedCount + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // 加载上下文菜单
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_delete) {
                    // 删除选中的项
                    for (int i = adapter.getCount() - 1; i >= 0; i--) {
                        if (listView.isItemChecked(i)) {
                            adapter.remove(i);
                            checkedItems.remove(i);
                        }
                    }
                    mode.finish(); // 退出上下文操作模式
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // 清空选择状态
            }
        });
    }

    // 自定义适配器类
    private class CustomAdapter extends ArrayAdapter<String> {

        CustomAdapter() {
            super(MainActivity4.this, R.layout.list_item2, items);
        }

        @Override
        public View getView(int position, View convertView, android.view.ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item2, parent, false);
            }

            // 设置图标
            ImageView icon = convertView.findViewById(R.id.item_icon);
            icon.setImageResource(R.drawable.ic_launcher_foreground);

            // 设置文本
            TextView text = convertView.findViewById(R.id.item_text);
            text.setText(items[position]);

            // 根据选中状态设置背景颜色
            if (checkedItems.get(position)) {
                convertView.setBackgroundColor(Color.LTGRAY);  // 设置选中项背景颜色
            } else {
                convertView.setBackgroundColor(Color.TRANSPARENT);  // 未选中的项背景
            }

            return convertView;
        }

        // 删除列表项的方法
        void remove(int position) {
            ArrayList<String> tempList = new ArrayList<>();
            for (String item : items) {
                tempList.add(item);
            }
            tempList.remove(position);
            items = tempList.toArray(new String[0]);
            notifyDataSetChanged();
        }
    }
}
