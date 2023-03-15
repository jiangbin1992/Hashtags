package com.tito.megahashtagsinsta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.best.now.myad.utils.PublicHelperKt;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
   public static Context mContext;
   List<Hashtags> hashtagsList;



    public RecyclerViewAdapter(Context mContext, List<Hashtags> hashtagsList) {
        this.mContext = mContext;
        this.hashtagsList = hashtagsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        final int num=i;
        view=layoutInflater.inflate(R.layout.card_view_hashtag_item,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        myViewHolder.textViewHashtagCategory.setText(hashtagsList.get(i).getmSubCategory().toString());
        myViewHolder.textViewHashtagSubCategory.setText(hashtagsList.get(i).getmCategory().toString());
        myViewHolder.imageViewHashtagThumbnail.setImageResource(hashtagsList.get(i).getmThumbnail());

      final   int num=i;
      myViewHolder.itemView.setTag(hashtagsList.get(i));




    }

    @Override
    public int getItemCount() {
        return hashtagsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewHashtagCategory;
        TextView textViewHashtagSubCategory;
        ImageView imageViewHashtagThumbnail;
        Button buttonSeeMore;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            textViewHashtagCategory=(TextView)itemView.findViewById(R.id.textViewCategoryHashtagItem);
            textViewHashtagSubCategory=(TextView)itemView.findViewById(R.id.textViewSubCategoryHashtagItem);
            imageViewHashtagThumbnail=(ImageView)itemView.findViewById(R.id.imageViewHashtagItem);
            buttonSeeMore=(Button)itemView.findViewById(R.id.button_see_more_game_item);

            buttonSeeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (PublicHelperKt.isRewarded((Activity) mContext)) {
                        PublicHelperKt.showInterstitialAd((Activity) mContext, new Function0<Unit>() {
                            @Override
                            public Unit invoke() {
                                Hashtags mHashtags=((Hashtags) itemView.getTag());
                                FragmentContent fragmentContent =new FragmentContent();
                                Bundle bundle=new Bundle();
                                bundle.putString(Hashtags.HASHTAGS_TO_SHOW,mHashtags.getmHashtags());
                                bundle.putString(Hashtags.CONTENT_CATEGORY,mHashtags.getmSubCategory());
                                bundle.putInt(Hashtags.THUMBNAIL_CONTENT,mHashtags.getmThumbnail());
                                fragmentContent.setArguments(bundle);
                                ((FragmentActivity)RecyclerViewAdapter.mContext).getSupportFragmentManager().beginTransaction().replace(R.id.Container_FrameLayout, fragmentContent).addToBackStack(null).commit();
                                return null;
                            }
                        });
                    }

                  // Toast.makeText(MainActivity.mContext,game.getGameTitle().toString(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }

}

