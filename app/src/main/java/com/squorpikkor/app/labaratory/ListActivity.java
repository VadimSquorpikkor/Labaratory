package com.squorpikkor.app.labaratory;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListActivity extends android.app.ListActivity {

    final String[] catNamesArray = {
            "Васька",
            "Барсик",
            "Алекс",
            "Лео",
            "Рыжик",
            "Гав"
    };

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catNamesArray);

        setListAdapter(mAdapter);
    }
}
