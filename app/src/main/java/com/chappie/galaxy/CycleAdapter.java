package com.chappie.galaxy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.List;

public class CycleAdapter extends PagerAdapter{
    private Context context;
    private List<Slider> sliderList;
    CycleAdapter(Context context, List<Slider> sliderList) {
        this.context=context;
        this.sliderList = sliderList;
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);

        ImageView movieImage = view.findViewById(R.id.image_movie);
        TextView number = view.findViewById(R.id.number);

        Glide.with(view.getContext())
                .load(sliderList.get(position).getImage())
                .into(movieImage);
        number.setText(sliderList.get(position).getNumber());

        container.addView(view);
        return view;
    }
}
