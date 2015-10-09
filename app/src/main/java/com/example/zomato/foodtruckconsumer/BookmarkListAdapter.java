package com.example.zomato.foodtruckconsumer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zomato on 08/10/15.
 */
public class BookmarkListAdapter extends ArrayAdapter<BookmarkedFoodTruckDetails> {

    LayoutInflater layoutInflater;
    ArrayList<BookmarkedFoodTruckDetails> mObjects;
    UnBookmarkButtonClickListener mUnBookmarkButtonClickListener;

    public interface UnBookmarkButtonClickListener{
        void removeItem(int pos);
    }

    public void setUnBookmarkButtonClickListener(UnBookmarkButtonClickListener mUnBookmarkButtonClickListener) {
        this.mUnBookmarkButtonClickListener = mUnBookmarkButtonClickListener;
    }

    public BookmarkListAdapter(Context context, int resource, ArrayList<BookmarkedFoodTruckDetails> objects,LayoutInflater layoutInflater) {
        super(context, resource, objects);
        this.layoutInflater=layoutInflater;
        mObjects=objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(convertView==null){
            v=layoutInflater.inflate(R.layout.bookmark_list_item_view,null);
        }
        BookmarkedFoodTruckDetails bookmarkedFoodTruckDetails=mObjects.get(position);
        TextView name= (TextView) v.findViewById(R.id.name);
        TextView description= (TextView) v.findViewById(R.id.description);
        ImageButton unBookmark= (ImageButton) v.findViewById(R.id.unBookmark);
        name.setText(bookmarkedFoodTruckDetails.mName);
        description.setText(bookmarkedFoodTruckDetails.mDescription);

        unBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUnBookmarkButtonClickListener.removeItem(position);
            }
        });
        return v;
    }
}
