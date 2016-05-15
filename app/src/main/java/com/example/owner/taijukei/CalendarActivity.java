package com.example.owner.taijukei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by owner on 16/01/31.
 */
public class CalendarActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

    }



    public void weightHome(View v){
        // インテントのインスタンス生成
        Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }

    public void calendarDocu(View v){
        // インテントのインスタンス生成
        Intent intent = new Intent(CalendarActivity.this, GrafActivity.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }


}
