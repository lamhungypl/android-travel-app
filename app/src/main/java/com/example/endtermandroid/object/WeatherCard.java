package com.example.endtermandroid.object;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.endtermandroid.R;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.cardview_city)
public class WeatherCard {


    @View(R.id.text_temp)
    public TextView mainTemp;

    @View(R.id.text_main)
    public TextView mainDescription;

    @View(R.id.speed)
    public TextView detailSpeed;
    @View(R.id.feel_like)
    public TextView detailFeelLike;
    @View(R.id.humidity)
    public TextView detailHumidity;
    @View(R.id.pressure)
    public TextView detailPressure;

    @View(R.id.main_image)
    public ImageView mainImage;




    public Weather mWeather;
    public Context mContext;
    public SwipePlaceHolderView mSwipeView;


    public WeatherCard(Weather mWeather, Context mContext, SwipePlaceHolderView mSwipeView) {
        this.mWeather = mWeather;
        this.mContext = mContext;
        this.mSwipeView = mSwipeView;
    }

    @Resolve
    public void onResolved() {
        Glide.with(mContext).load(mWeather.getSrcMainImage()).into(mainImage);
        mainTemp.setText(mWeather.getMainTemp() + "℃");
        mainDescription.setText(mWeather.getMainDescription());
        detailFeelLike.setText(mWeather.getDetailFeelLike());
        detailHumidity.setText(mWeather.getDetailHumidity());
        detailPressure.setText(mWeather.getDetailPressure());
        detailSpeed.setText(mWeather.getDetailSpeed());
    }

    @SwipeOut
    public void onSwipedOut() {
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    public void onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    public void onSwipeIn() {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    public void onSwipeInState() {
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    public void onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState");
    }


}
