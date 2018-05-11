package com.logicchip.blog_14_floatingsearchview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class AdapterForRecycle extends RecyclerView.Adapter<AdapterForRecycle.ViewHolder>  {
    private Activity context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }

    }

    public  AdapterForRecycle(Activity context){
        this.context=context;
    }

    @Override
    public AdapterForRecycle.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycle, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // holder.text_view_for_tittle.setText("Club events : "+String.valueOf(position));

    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
