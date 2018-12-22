package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String json;
    Toolbar toolbar;
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        ArrayList<Sandwich> sandwiches = JsonUtils.parseSandwichJson(json);

        final ArrayList<String> sandwichList = new ArrayList<>();
        Sandwich sandwich0 = sandwiches.get(0);
        sandwichList.add(sandwich0.getMainName());

        Sandwich sandwich1 = sandwiches.get(1);
        sandwichList.add(sandwich1.getMainName());

        Sandwich sandwich2 = sandwiches.get(2);
        sandwichList.add(sandwich2.getMainName());

        Sandwich sandwich3 = sandwiches.get(3);
        sandwichList.add(sandwich3.getMainName());

        Sandwich sandwich4 = sandwiches.get(4);
        sandwichList.add(sandwich4.getMainName());

        Sandwich sandwich5 = sandwiches.get(5);
        sandwichList.add(sandwich5.getMainName());

        Sandwich sandwich6 = sandwiches.get(6);
        sandwichList.add(sandwich6.getMainName());

        Sandwich sandwich7 = sandwiches.get(7);
        sandwichList.add(sandwich7.getMainName());

        Sandwich sandwich8 = sandwiches.get(8);
        sandwichList.add(sandwich8.getMainName());

        Sandwich sandwich9 = sandwiches.get(9);
        sandwichList.add(sandwich9.getMainName());

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sandwichList);

        final ListView lv = findViewById(R.id.sandwiches_list);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_POSITION, position);
                intent.putExtra("Title", lv.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
}
