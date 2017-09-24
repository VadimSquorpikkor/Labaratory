package com.squorpikkor.app.labaratory;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DynamicActivity extends AppCompatActivity {

    ArrayList<TextView> textList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        layout = (LinearLayout) findViewById(R.id.layout);

        stringList.add("first");
        stringList.add("second");
        stringList.add("third");

        textList.add(new TextView(this));
        textList.add(new TextView(this));
        textList.add(new TextView(this));

        layout.addView(textList.get(0));
        layout.addView(textList.get(1));
        layout.addView(textList.get(2));

        textList.get(0).setText(stringList.get(0));
        textList.get(1).setText(stringList.get(1));
        textList.get(2).setText(stringList.get(2));

        ViewConstructor viewConstructor = new ViewConstructor(this,  layout);
        viewConstructor.createTextViewList("LIST", 10);
        viewConstructor.setTextViewText("LIST", 5, "new text");

        viewConstructor.createTextViewFromArray(stringList);

    }

    class ViewConstructor {
        private LinearLayout layout;
        private Context context;

        public HashMap<String, ArrayList<TextView>> getViewController() {
            return viewController;
        }

        /**Hash map is needed just for store lists of views,
         * Without HashMap, I do not know, how many lists I will create, 1 or 100,
         * so I can't just declare this 100 lists in class. And i will not have to.
         * Just put new ones to HashMap! And no matter 1 or 1000 list i should create.
         */
        private HashMap<String, ArrayList<TextView>> viewController = new HashMap<>();
//        private HashMap<String, Layout> layoutMap = new HashMap<>();

        public ViewConstructor(Context context, LinearLayout layout) {
            this.layout = layout;
            this.context = context;

        }

//        void create

        void createTextViewList(String name, int count) {//version for HashMap
            ArrayList<TextView> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TextView textView = new TextView(context);
                textView.setText("someText");
                list.add(textView);
                layout.addView(textView);
            }
            viewController.put(name, list);//
        }

        /**
         *
         * That is it!!!
         */
        void createTextViewFromArray(ArrayList<String> list) {
            for (String s : list) {
                TextView textView = new TextView(context);
                textView.setText(s);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    textView.setTextAppearance(R.style.some_text_style);
                }
                layout.addView(textView);
            }
        }

        /*void createTextViewLayout(String name, int count) {//version for HashMap
            Layout layout = new Layout() {};
            for (int i = 0; i < count; i++) {
                TextView textView = new TextView(context);
                textView.setText("someText");
                list.add(textView);
                layout.addView(textView);
            }
            viewController.put(name, list);//
        }*/

        void setTextViewText(String listName, int number, String text) {
            viewController.get(listName).get(number).setText(text);
        }


    }
}
