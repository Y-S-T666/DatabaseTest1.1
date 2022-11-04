package com.example.databasetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                //查询数据
                Uri uri = Uri.parse("content://com.example.sy7_1/book");
//                Log.d("运行：",getContentResolver().toString());
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//                Log.d("运行：","cursor:"+cursor);
                if (cursor != null) {
                    Log.d("运行：","cursor不为空");
//                    Log.d("运行：",cursor.moveToNext()+"");
                    while (cursor.moveToNext()) {
                        Log.d("运行：","开始查找");
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));
                        Log.d("运行","人名："+name);
                        Log.d("运行","电话："+phone);
                        Log.d(".MainActivity", "book name is" + name);
                        Log.d(".MainActivity", "book author is" + phone);
                    }
                    Log.d("运行：","结束查找");
                    cursor.close();
                }else{
                    Log.d("运行：","cursor为空");
                }
            }
        });
    }
}