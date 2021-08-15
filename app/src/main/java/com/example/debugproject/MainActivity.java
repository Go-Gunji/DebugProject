package com.example.debugproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int result;
        result = calc(3);
        Log.d("result", "結果は " + result);

        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);

        String test = "テスト";
        Log.d("error", test);

        // 配列の変数を通って中身を初期化する
        String[] arrayString = {"Android", "Java", "こんにちは"};

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                leaks();
            }
        });
    }

    private void leaks() {
        for (int i = 0; i < 100000; i++) {
            list.add(new String("メモリーリークしています！！！！"));
        }
    }

    private int calc(int x) {
        int result = 0;
        for (int i = 1; i <= x; i++) {
            result += i;
            Log.v("calc", "iは" + i + ",resultは" + result);
        }
        Log.v("calc", "計算結果は" + result);
        return  result;
    }
}