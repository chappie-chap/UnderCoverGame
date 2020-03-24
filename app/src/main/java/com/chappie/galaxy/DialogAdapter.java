package com.chappie.galaxy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogAdapter extends DialogFragment {
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.sk_text)
    TextView textView;
    @BindView(R.id.btn_Alien)
    Button btn_Alien;
    @BindView(R.id.btn_Astronaut1)
    Button btn_Astronaut1;
    @BindView(R.id.btn_Astronaut2)
    Button btn_Astronaut2;
    @BindView(R.id.btn_start)
    ImageView btn_Start;
    @BindView(R.id.imgBackground)
    ImageView imgBackground;
    @BindView(R.id.checkBoxRole)
    CheckBox chk_role;
    private int CV, UD, WH;

    private int getCV() {
        return CV;
    }

    private void setCV(int CV) {
        this.CV = CV;
    }

    private int getUD() {
        return UD;
    }

    private void setUD(int UD) {
        this.UD = UD;
    }

    private int getWH() {
        return WH;
    }

    private void setWH(int WH) {
        this.WH = WH;
    }

    @SuppressLint("DefaultLocale")
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.custom_dialog, viewGroup,false);
        ButterKnife.bind(this,view);
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Glide.with(view.getContext()).load(R.drawable.table).into(imgBackground);

        getDialog().setCanceledOnTouchOutside(false);
        Glide.with(view.getContext()).load(R.drawable.btn_main).into(btn_Start);
        this.btn_Alien.setText(String.format("%d %s", this.CV, getResources().getString(R.string.Alien)));
        this.btn_Astronaut1.setText(String.format("%d %s", this.UD, getResources().getString(R.string.Astronaut1)));
        this.btn_Astronaut2.setText(String.format("%d %s", this.WH, getResources().getString(R.string.astronaut2)));
        if (Build.VERSION.SDK_INT >= 26) {
            seekBar.setMin(4);
        }
        seekBar.setMax(8);
        seekBar.setProgress(4);
        setCV(3);
        setUD(1);
        setWH(0);
        roleBtn();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int ProgressChanged = 4;
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @SuppressLint("SetTextI18n")
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ProgressChanged = i;
                textView.setText(""+ProgressChanged);
                RuleGame(ProgressChanged);
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    private void RuleGame(Integer num) {
        if (num < 4) {
            Toast.makeText(getContext(), getResources().getString(R.string.kelompok_min), Toast.LENGTH_SHORT).show();
        } else if (num == 4) {
            setCV(3);
            setUD(1);
            setWH(0);
            roleBtn();
        } else if (num == 5 || num == 6) {
            if (num == 5) {
                setCV(3);
                setUD(1);
                setWH(1);
                roleBtn();
            } else {
                setCV(4);
                setUD(1);
                setWH(1);
                roleBtn();
            }
        } else if (num == 7 || num == 8) {
            if (num == 7) {
                setCV(4);
                setUD(2);
                setWH(1);
                roleBtn();
            } else {
                setCV(5);
                setUD(2);
                setWH(1);
                roleBtn();
            }
        }
    }

    @SuppressLint("DefaultLocale")
    private void roleBtn() {
        this.btn_Alien.setText(String.format("%d %s", getCV(), getResources().getString(R.string.Alien)));
        this.btn_Astronaut1.setText(String.format("%d %s", getUD(), getResources().getString(R.string.Astronaut1)));
        this.btn_Astronaut2.setText(String.format("%d %s", getWH(), getResources().getString(R.string.astronaut2)));
    }

    @OnClick(R.id.btn_start)
    void Start() {
        Intent intent = new Intent(getActivity(), GameActivity.class);
        intent.putExtra(GameActivity.EXTRA_ALIEN, getCV());
        intent.putExtra(GameActivity.EXTRA_ASTRONAUT1, getUD());
        intent.putExtra(GameActivity.EXTRA_ASTRONAUT2, getWH());
        intent.putExtra(GameActivity.EXTRA_CHECK, this.chk_role.isChecked());
        getActivity().startActivity(intent);
        dismiss();
    }
}
