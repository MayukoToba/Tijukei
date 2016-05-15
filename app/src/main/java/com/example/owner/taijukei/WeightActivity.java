package com.example.owner.taijukei;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import java.util.Calendar;

/**
 * Created by owner on 16/01/31.
 */
public class WeightActivity extends Activity {
    NumberPicker numberPicker;
    NumberPicker numberPicker2;
    int weightNumber;
    int heightNumber;

   public static String date1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //体重
        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);

        numberPicker.setMaxValue(200);
        numberPicker.setMinValue(30);

        Intent intent = getIntent();
        weightNumber = intent.getIntExtra("weight",50);
        numberPicker.setValue(weightNumber);

        //身長
        numberPicker2 = (NumberPicker)findViewById(R.id.numberPicker2);

        numberPicker2.setMaxValue(200);
        numberPicker2.setMinValue(120);

        heightNumber = intent.getIntExtra("height",140);
        numberPicker2.setValue(heightNumber);


    }

    public void weightWeight(View v){
        // インテントのインスタンス生成
        Intent intent = new Intent(WeightActivity.this,GrafActivity.class);

        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }

    public void weightCalendar(View v){
        // インテントのインスタンス生成
        Intent intent = new Intent(WeightActivity.this,CalendarActivity.class);

        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }

    public void weightHome(View v){
        weightNumber = numberPicker.getValue();
        heightNumber = numberPicker2.getValue();

        // インテントのインスタンス生成
        Intent intent = new Intent(WeightActivity.this, MainActivity.class);
        intent.putExtra("weight", weightNumber);
        intent.putExtra("height",heightNumber);


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;// 0 - 11
        int day = cal.get(Calendar.DAY_OF_MONTH);

        date1 =String.valueOf(10000*year + 100*month + day);

        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();
        editor.putInt(date1, weightNumber);
        editor.apply();



        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }


}
