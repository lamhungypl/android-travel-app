package com.example.endtermandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.endtermandroid.R;
import com.example.endtermandroid.object.CardCityModel;

import java.util.List;

public class CityCardViewAdapter  extends  RecyclerView.Adapter{
    private Context context;
    private List<CardCityModel> itemModels;

    private class ItemHolder extends RecyclerView.ViewHolder {
        TextView mainTemp, mainDescription,detailSpeed,detailFeelLike,detailHumidity,detailPressure;

        ItemHolder(View view) {
            super(view);
            mainTemp = view.findViewById(R.id.text_temp);
            mainDescription = view.findViewById(R.id.text_main);
            detailSpeed = view.findViewById(R.id.speed);
            detailFeelLike = view.findViewById(R.id.feel_like);
            detailHumidity = view.findViewById(R.id.humidity);
            detailPressure = view.findViewById(R.id.pressure);



        }
    }
    public CityCardViewAdapter(Context context , List<CardCityModel> itemModels){
        this.context = context;
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View items = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_city, parent, false);


        return new ItemHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //create model for storing data , pass the list of data in recycler view
        CardCityModel itemModel = this.itemModels.get(position);
        final ItemHolder itemHolder = (ItemHolder) holder;

        itemHolder.mainTemp.setText(itemModel.getMainTemp());
        itemHolder.mainDescription.setText(itemModel.getMainDescription());
        itemHolder.detailSpeed.setText(itemModel.getDetailSpeed());
        itemHolder.detailFeelLike.setText(itemModel.getDetailFeelLike());
        itemHolder.detailHumidity.setText(itemModel.getDetailHumidity());
        itemHolder.detailPressure.setText(itemModel.getDetailPressure());

    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
