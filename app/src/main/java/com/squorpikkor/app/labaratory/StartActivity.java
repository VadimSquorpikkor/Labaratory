package com.squorpikkor.app.labaratory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button mButton1 = (Button) findViewById(R.id.butt01);
        Button mButton2 = (Button) findViewById(R.id.butt02);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.butt01:
                        clickActivity(MainActivity.class);
                        break;
                    case R.id.butt02:
                        clickActivity(Main2Activity.class);
                        break;
                }
            }
        };

        mButton1.setOnClickListener(listener);
        mButton2.setOnClickListener(listener);

        View.OnLongClickListener longlistener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                switch (v.getId()) {
                    case R.id.butt01:
                        doToast("Долгое нажатие 1");
                    case R.id.butt02:
                        doToast("Долгое нажатие 2");
                        break;
                }
                return false;
            }
        };


        mButton1.setOnLongClickListener(longlistener);
        mButton2.setOnLongClickListener(longlistener);
    }

    private void clickActivity(Class activityName) {
        Intent intent = new Intent(this, activityName);
        startActivity(intent);
    }

    private void doToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
