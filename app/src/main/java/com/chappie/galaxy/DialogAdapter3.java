package com.chappie.galaxy;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogAdapter3 extends DialogFragment {
    @BindView(R.id.imgBackgroundadapter)
    ImageView background;
    @BindView(R.id.imgRole3)
    ImageView imgRole;
    @BindView(R.id.tvWinner)
    TextView tvWinner;
    @BindView(R.id.btn_hukuman)
    Button btn_hukuman;
    @BindView(R.id.btn_kembali)
    Button btn_kembali;
    @BindView(R.id.rv_progress)
    RecyclerView rv_progress;
    private ProgressAdapter adapter;
    private List<Game> gameList;
    private int index;

    void setEXTRA(List<Game> list, int i) {
        this.gameList = list;
        this.index = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.custom_dialog3, viewGroup, false);
        ButterKnife.bind(this, view);
        int i;
        int i2;
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Glide.with(view.getContext())
                .load(R.drawable.table)
                .into(this.background);
        /*if (Build.VERSION.SDK_INT >= 21) {
        } else {
            getDialog().getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.table));
        }*/
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        int i3 = this.index;
        if (i3 == 1) {
            ((RequestBuilder) Glide.with(view.getContext())
                    .load(R.drawable.alien)
                    .override(140, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION))
                    .into(this.imgRole);
            this.tvWinner.setText("Alien Win");
        } else if (i3 == 2) {
            Glide.with(view.getContext())
                    .load(R.drawable.astronot)
                    .into(this.imgRole);
            this.tvWinner.setText("Astronot 1 Win");
        }
        int i4 = this.index;
        if (i4 == 3) {
            Glide.with(view.getContext()).load(R.drawable.astronot3).into(this.imgRole);
            this.tvWinner.setText("Astronot 2 Win");
        } else if (i4 == 4) {
            Glide.with(view.getContext()).load(R.drawable.alien).into(this.imgRole);
            this.tvWinner.setText("Alien kalah");
        }
        for (int i5 = 0; i5 < this.gameList.size(); i5++) {
            if (!this.gameList.get(i5).getRole().trim().equals("Alien") || this.index != 1) {
                if (!this.gameList.get(i5).getRole().trim().equals("Astronot 1") || !((i2 = this.index) == 2 || i2 == 4)) {
                    if (this.gameList.get(i5).getRole().trim().equals("Astronot 2") && (((i = this.index) == 3 || i == 4) && !this.gameList.get(i5).isEliminate())) {
                        this.gameList.get(i5).setPoint(this.gameList.get(i5).getPoint() + 10);
                    }
                } else if (!this.gameList.get(i5).isEliminate()) {
                    this.gameList.get(i5).setPoint(this.gameList.get(i5).getPoint() + 6);
                }
            } else if (!this.gameList.get(i5).isEliminate()) {
                this.gameList.get(i5).setPoint(this.gameList.get(i5).getPoint() + 2);
            }
        }
        this.rv_progress.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.adapter = new ProgressAdapter(view.getContext(), this.gameList);
        this.rv_progress.setAdapter(this.adapter);
        return view;
    }
}
