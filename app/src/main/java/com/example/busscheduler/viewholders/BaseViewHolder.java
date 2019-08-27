package com.example.busscheduler.viewholders;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    int currentPosition;

    public BaseViewHolder(View view){
        super(view);
    }

    public void bind(int position){
        currentPosition = position;
    }
}
