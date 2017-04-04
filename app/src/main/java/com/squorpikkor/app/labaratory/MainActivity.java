package com.squorpikkor.app.labaratory;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Button button1, button2;

    long startTime;
    long endTime;


    Thread thread = new Thread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        displayTime(getTime());
                        break;
                    case R.id.button2:
                        openActivity();
                        break;
                }
            }
        };

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
    }

    void displayVar() {
        text1.setText(String.valueOf(startTime));
        text2.setText(String.valueOf(endTime));
    }

    void openActivity() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("value", "Message!!!");
        startActivity(intent);

    }

    long getTime() {
        return System.currentTimeMillis();
    }

    void displayTime(long t) {
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }

            text1.setText(String.valueOf(t));
        }
    }


    void displayVar(long k) {
        text1.setText(String.valueOf(k));
    }

    void displayVar(Class<?> t) {
        text1.setText(String.valueOf(t));
    }
}
