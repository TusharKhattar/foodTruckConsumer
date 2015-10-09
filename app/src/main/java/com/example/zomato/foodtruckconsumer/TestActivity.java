package com.example.zomato.foodtruckconsumer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] items;
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        items=new String[7];
        items[0]="Monday";
        items[1]="Tuesday";
        items[2]="Wednesday";
        items[3]="Thursday";
        items[4]="Friday";
        items[5]="Saturday";
        items[6]="Sunday";

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList= (ListView) findViewById(R.id.left_drawer);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
