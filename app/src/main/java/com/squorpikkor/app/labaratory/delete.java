package com.squorpikkor.app.labaratory;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class delete extends AppCompatActivity {

    ArrayList<String> stringList = new ArrayList<>();
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        layout = (LinearLayout) findViewById(R.id.layout);

        stringList.add("first");
        stringList.add("second");
        stringList.add("third");

        createTextViewFromArray(stringList);
    }

    void createTextViewFromArray(ArrayList<String> list) {
        for (String s : list) {
            TextView textView = new TextView(this);
            textView.setText(s);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textView.setTextAppearance(R.style.some_text_style);
            }
            layout.addView(textView);
        }
    }

}
