package com.squorpikkor.app.labaratory;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, catNamesArray);

        setListAdapter(mAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
