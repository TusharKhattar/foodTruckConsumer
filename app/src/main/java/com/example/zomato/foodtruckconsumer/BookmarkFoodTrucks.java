package com.example.zomato.foodtruckconsumer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BookmarkFoodTrucks extends AppCompatActivity implements BookmarkListAdapter.UnBookmarkButtonClickListener, AdapterView.OnItemClickListener {

    ListView bookmarkList;
    ArrayList<BookmarkedFoodTruckDetails> bookmarkedFoodTruckList;
    BookmarkListAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmarked_food_truck);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        LayoutInflater layoutInflater=getLayoutInflater();
        View v=layoutInflater.inflate(R.layout.toolbar_view,null);

        bookmarkList= (ListView) findViewById(R.id.listView);

        bookmarkedFoodTruckList=new ArrayList<>();
        BookmarkedFoodTruckDetails bookmarkedFoodTruckDetails=new BookmarkedFoodTruckDetails("Dave","Famous Dave's BBQ are ready to serve you the best food around",true);
        BookmarkedFoodTruckDetails bookmarkedFoodTruckDetails2=new BookmarkedFoodTruckDetails("Baba","Famous Dave's BBQ are ready to serve you the best food around",true);
        bookmarkedFoodTruckList.add(bookmarkedFoodTruckDetails);
        bookmarkedFoodTruckList.add(bookmarkedFoodTruckDetails2);
        bookmarkedFoodTruckList.add(bookmarkedFoodTruckDetails);
        bookmarkedFoodTruckList.add(bookmarkedFoodTruckDetails2);
        bookmarkedFoodTruckList.add(bookmarkedFoodTruckDetails);

        adapter=new BookmarkListAdapter(this,0,bookmarkedFoodTruckList,getLayoutInflater());
        adapter.setUnBookmarkButtonClickListener(this);



        bookmarkList.setAdapter(adapter);

        bookmarkList.setOnItemClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.search){
            View searchView=getLayoutInflater().inflate(R.layout.search_view, null);
            getSupportActionBar().setCustomView(searchView);

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void removeItem(int pos) {
        bookmarkedFoodTruckList.remove(pos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(this,FoodTruckPersonalPageActivity.class);
        startActivity(i);
    }
}
