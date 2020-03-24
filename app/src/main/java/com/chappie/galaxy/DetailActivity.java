package com.chappie.galaxy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_LIST = "extra_list";
    @BindView(R.id.dtl_imgBack)
    ImageView imgBack;
    @BindView(R.id.dtl_bckDesc)
    ImageView imgBackDesc;
    @BindView(R.id.dtl_planetImg)
    ImageView imgPlanet;
    @BindView(R.id.dtl_Title)
    TextView tv_title;
    @BindView(R.id.dtl_description)
    JustifyTextView tv_desc;
    private TataSurya tataSuryas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        tataSuryas= getIntent().getParcelableExtra(EXTRA_LIST);
        init();
    }

    private void init() {
        tv_title.setText(tataSuryas.getName());
        tv_desc.setText(tataSuryas.getDescribe());
        Glide.with(this)
                .load(R.drawable.urutan)
                .into(imgBack);
        Glide.with(this)
                .load(R.drawable.table)
                .into(imgBackDesc);
        Glide.with(this)
                .load(tataSuryas.getImgPlanet())
                .into(imgPlanet);
    }
}
