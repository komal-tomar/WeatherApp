package com.example.sai.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private Context context;
    private User[] data;
    public WeatherAdapter(Context context,User[] data) {
        this.context = context;
        this.data = data;
    }
    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from (viewGroup.getContext());
        View view = inflater.inflate (R.layout.item_user_layout,viewGroup,false);
        return new WeatherViewHolder (view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder weatherViewHolder, int position) {
        User user = data(getItemViewType ((Integer)position));
        weatherViewHolder.txtUser.setText (user.getCnt ());
    }

    private User data(int itemViewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        TextView txtUser;
        public WeatherViewHolder(View itemView) {
            super (itemView);
            txtUser = (TextView)itemView.findViewById (R.id.txtUser);

        }
    }

    }
