package com.example.zomato.foodtruckconsumer;

/**
 * Created by zomato on 08/10/15.
 */
public class BookmarkedFoodTruckDetails {
    String mName;
    String mDescription;
    boolean mBookmarked;

    public BookmarkedFoodTruckDetails(String name,String description,boolean bookmarked){
        mName=name;
        mDescription =description;
        mBookmarked=bookmarked;
    }
}
