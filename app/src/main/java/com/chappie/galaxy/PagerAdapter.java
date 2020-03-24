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

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private Context context;
    private List<Slider> sliderList;

    PagerAdapter(Context context2, List<Slider> list) {
        this.context = context2;
        this.sliderList = list;
    }

    PagerAdapter() {
    }

    public int getCount() {
        return this.sliderList.size();
    }

    public boolean isViewFromObject(View view, @NonNull Object obj) {
        return view.equals(obj);
    }

    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_help, viewGroup, false);
        Glide.with(inflate.getContext()).load(this.sliderList.get(i).getImage()).into((ImageView) inflate.findViewById(R.id.image_movie));
        ((TextView) inflate.findViewById(R.id.number)).setText(this.sliderList.get(i).getNumber());
        viewGroup.addView(inflate);
        return inflate;
    }
}
