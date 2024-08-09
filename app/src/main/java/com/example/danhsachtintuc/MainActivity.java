package com.example.danhsachtintuc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_NEWS = 1;
    ListView listView;
    List<tintuc> newsList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnThem = findViewById(R.id.btnThem);
        listView = findViewById(R.id.listView);
        newsList = new ArrayList<>();

        // Add sample data
        newsList.add(new tintuc("Title 1", "Content 1", "01-01-2024"));
        newsList.add(new tintuc("Title 2", "Content 2", "02-01-2024"));
        newsList.add(new tintuc("Title 3", "Content 3", "03-01-2024"));

        customAdapter = new CustomAdapter(this, R.layout.listview, newsList);
        listView.setAdapter(customAdapter);

        btnThem.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, them.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_NEWS);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_NEWS && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");
            String date = data.getStringExtra("date");

            tintuc news = new tintuc(title, content, date);
            newsList.add(news);
            customAdapter.notifyDataSetChanged();
        }
    }
}
