package com.example.owner.taijukei;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by owner on 16/01/31.
 */
public class GrafActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf);
        createBarChart();

    }
    private void createBarChart() {
        BarChart barChart = (BarChart) findViewById(R.id.bar_chart);
        barChart.setDescription("BarChart 説明");

        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setEnabled(true);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(false);
        barChart.setEnabled(true);

        barChart.setTouchEnabled(true);
        barChart.setPinchZoom(true);
        barChart.setDoubleTapToZoomEnabled(true);

        barChart.setHighlightEnabled(true);
        barChart.setDrawHighlightArrow(true);
        barChart.setHighlightEnabled(true);

        barChart.setScaleEnabled(true);

        barChart.getLegend().setEnabled(true);

        //X軸周り
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setSpaceBetweenLabels(0);

        barChart.setData(createBarChartData());

        barChart.invalidate();
        // アニメーション
        barChart.animateY(2000, Easing.EasingOption.EaseInBack);
    }

    // BarChartの設定
    private BarData createBarChartData() {
        ArrayList<BarDataSet> barDataSets = new ArrayList<>();

        // X軸
        ArrayList<String> xValues = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;// 0 - 11
        int day = cal.get(Calendar.DAY_OF_MONTH);


        xValues.add(month + "/" + day);


        //データを取り出す
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        int Level = data.getInt(WeightActivity.date1, 1);
        Log.d("date1",WeightActivity.date1);

        // valueA
        ArrayList<BarEntry> valuesA = new ArrayList<>();
        valuesA.add(new BarEntry(Level,0));


        BarDataSet valuesADataSet = new BarDataSet(valuesA, "A");
        valuesADataSet.setColor(ColorTemplate.COLORFUL_COLORS[3]);

        barDataSets.add(valuesADataSet);


        BarData barData = new BarData(xValues, barDataSets);
        return barData;
    }


    public void docuDocu(View v){
        // インテントのインスタンス生成
        Intent intent = new Intent(GrafActivity.this, CalendarActivity.class);

        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }

    public void docuHome(View v){
        // インテントのインスタンス生成
        Intent intent = new Intent(GrafActivity.this, MainActivity.class);

        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();
    }
}
