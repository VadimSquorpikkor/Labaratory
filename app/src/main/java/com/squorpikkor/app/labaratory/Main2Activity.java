package com.squorpikkor.app.labaratory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView text = (TextView) findViewById(R.id.text);

//        Intent intent = getIntent();

        text.setText(getIntent().getStringExtra("value"));

    }
}
