package com.example.squirrel_trip.squirreltrip.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.squirrel_trip.squirreltrip.R;
import com.example.squirrel_trip.squirreltrip.model.Picture;
import com.example.squirrel_trip.squirreltrip.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture  = pictures.get(position);
        holder.textToCheckBox.setText(picture.getTextToCheckBox());
        holder.textToRatingBar.setText(picture.getGetTextToRatingBar());
        holder.likeRating.setText(picture.getLike_rating());
        Picasso.with(activity).load(picture.getPictures()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View view){
              Intent intent = new Intent(activity,PictureDetailActivity.class);
              if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                  Explode explode = new Explode();
                  explode.setDuration(1000);
                  activity.getWindow().setExitTransition(explode);
                  activity.startActivity(intent,
                          ActivityOptionsCompat.makeSceneTransitionAnimation (activity,view,activity.getString(R.string.transitionName_Picture)).toBundle());
              }else{
                  activity.startActivity(intent);
              }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView textToCheckBox;
        private TextView textToRatingBar;
        private TextView likeRating;


        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCard);
            textToCheckBox = (TextView) itemView.findViewById(R.id.textToCheckBox);
            textToRatingBar = (TextView) itemView.findViewById(R.id.textToRatingBar);
            likeRating = (TextView) itemView.findViewById(R.id.likeRatingBar);
        }
    }
}
