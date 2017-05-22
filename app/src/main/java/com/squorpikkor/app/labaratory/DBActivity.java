package com.squorpikkor.app.labaratory;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.squorpikkor.app.labaratory.DBHelper.DESCRIPTION;
import static com.squorpikkor.app.labaratory.DBHelper.IMAGE_RESOURCE_ID;
import static com.squorpikkor.app.labaratory.DBHelper.NAME;
import static com.squorpikkor.app.labaratory.DBHelper.TAB1_NAME;

public class DBActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText1, editText2, editText3;
    TextView textView1, textView2, textView3;
    Button button;

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);

        button = (Button) findViewById(R.id.butt);

        dbHelper = new DBHelper(this);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butt:
                insertData();
                break;
        }
    }

    void insertData() {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cv.put(NAME, editText1.getText().toString());
        cv.put(DESCRIPTION, editText2.getText().toString());
        cv.put(IMAGE_RESOURCE_ID, Integer.parseInt(editText3.getText().toString()));
        db.insert(TAB1_NAME, null, cv);

        Toast.makeText(this, "Added to DB", Toast.LENGTH_LONG).show();
    }

}
