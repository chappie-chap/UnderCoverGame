package com.chappie.galaxy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Slider> sliderList = new ArrayList();

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView( R.layout.activity_main);
        initData();
        ((HorizontalInfiniteCycleViewPager) findViewById(R.id.view_pager)).setAdapter(new PagerAdapter(this, this.sliderList));
    }

    private void initData() {
        this.sliderList.add(new Slider(R.drawable.slide1, "1"));
        this.sliderList.add(new Slider(R.drawable.slide2, "2"));
        this.sliderList.add(new Slider(R.drawable.slide3, "3"));
        this.sliderList.add(new Slider(R.drawable.slide4, "4"));
        this.sliderList.add(new Slider(R.drawable.slide5, "5"));
        this.sliderList.add(new Slider(R.drawable.slide6, "6"));
        this.sliderList.add(new Slider(R.drawable.slide7, "7"));
        this.sliderList.add(new Slider(R.drawable.slide8, "8"));
        this.sliderList.add(new Slider(R.drawable.slide9, "9"));
        this.sliderList.add(new Slider(R.drawable.slide10, "10"));
        this.sliderList.add(new Slider(R.drawable.slide11, "11"));
        this.sliderList.add(new Slider(R.drawable.slide12, "12"));
    }
}
