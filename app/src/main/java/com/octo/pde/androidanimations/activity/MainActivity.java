package com.octo.pde.androidanimations.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.octo.pde.androidanimations.R;
import com.octo.pde.androidanimations.structure.Menu;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private MenusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);
        adapter = new MenusAdapter(this, Arrays.asList(Menu.values()));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu item = adapter.getItem(position);
                startActivity(new Intent(MainActivity.this, item.getClassToStart()));
            }
        });

    }


    private class MenusAdapter extends ArrayAdapter<Menu>{

        MenusAdapter(Context context, List<Menu> objects) {
            super(context, R.layout.cell_menu, R.id.textview_title, objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            Menu item = getItem(position);
            View view = super.getView(position, convertView, parent);
            view.setBackgroundColor(
                    getContext().getResources().getColor(item.getApiLevel().getColorResource()));
            TextView apiLevelTextView = view.findViewById(R.id.textview_api_level);
            apiLevelTextView.setText(
                    getString(R.string.api_level, item.getApiLevel().getSdkInt()));
            return view;
        }
    }
}
