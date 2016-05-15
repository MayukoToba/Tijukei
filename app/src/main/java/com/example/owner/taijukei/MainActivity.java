package com.example.owner.taijukei;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int getHumanWeight;
    private int getHumanHeight;
    Button weightButton;
    ImageView imageView;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightButton = (Button) findViewById(R.id.weightButton);
        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);


        Intent intent = getIntent();
        getHumanWeight = intent.getIntExtra("weight", 30);
        getHumanHeight = intent.getIntExtra("height", 120);

        double BMI = bmi(getHumanHeight, getHumanWeight);
        String after = String.format("%.2f", BMI);

        weightButton.setText(after);

        //宣言
        double height4 = getHumanHeight;
        double weight4 = getHumanWeight;
        textView3 = (TextView)findViewById(R.id.textView3);

        BMI2(BMI);
        Weight(BMI,height4,weight4);

    }

    public double bmi(int height, int weight) {

        double BMI2 = height * height;
        double BMI = weight / BMI2 * 10000;


        return BMI;
    }

    public void BMI2(double bmi2){
        if(bmi2 < 18.5) {
            imageView.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        }else if( bmi2 < 25){
            imageView.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
        }else if (bmi2 < 30){
            imageView.setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);
        }else {
            imageView.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        }
    }

    public double Weight(double bmi,double height,double weight2) {
        if (bmi < 18.5) {
            double weight1 = 18.5 * height * height / 10000;
            double weight3 = weight1 - weight2;
            String before = String.format("%.2f", weight3);
            textView3.setText(before);
            textView3.setTextColor(Color.BLUE);

        } else if (bmi >= 25) {
            double weight1 = 25 * height * height / 10000;
            double weight3 = weight1 - weight2;
            String before = String.format("%.2f", weight3);
            textView3.setText(before);
            textView3.setTextColor(Color.RED);
        }

        return bmi;
    }





    public void weightNum(View v) {

        // インテントのインスタンス生成
        Intent intent = new Intent(MainActivity.this, WeightActivity.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();

    }

    public void document(View v) {

        // インテントのインスタンス生成
        Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();

    }

    public void weight(View v) {

        // インテントのインスタンス生成
        Intent intent = new Intent(MainActivity.this, GrafActivity.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
        finish();

    }

}

