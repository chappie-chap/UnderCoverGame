package com.chappie.galaxy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;
import java.util.Objects;

public class DialogAdapter2 extends DialogFragment {
    @BindView(R.id.imgRole)
    CircleImageView imgRole;
    @BindView(R.id.imgBackground2)
    ImageView imgBack;
    @BindView(R.id.imgRole2)
    ImageView imgRole1;
    @BindView(R.id.edt_Name)
    EditText edt_Name;
    @BindView(R.id.tv_role)
    TextView tv_Role;
    @BindView(R.id.tv_word)
    TextView tv_Word;
    @BindView(R.id.btn_showRole)
    Button btn_showRole;
    private int index;
    private List<Game> gameList;
    private boolean isChecked;
    private Context context;

    void setEXTRA(List<Game> list, boolean z, int i) {
        this.gameList = list;
        this.isChecked = z;
        this.index = i;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_dialog2, container, false);
        ButterKnife.bind(this, view);
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Glide.with(view.getContext()).load(R.drawable.table).into(imgBack);
        /*if (Build.VERSION.SDK_INT >= 21) {
        } else {
            Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).setBackgroundDrawable(getResources().getDrawable(R.drawable.table));
        }*/
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        context = view.getContext();
        imgRole1.setVisibility(View.INVISIBLE);
        Glide.with(view.getContext())
                .load(R.drawable.logo3rev2)
                .into(imgRole);
        if (gameList.get(index).getName().trim().equals("Player")) {
            edt_Name.setEnabled(true);
            edt_Name.setText("");
        } else {
            this.edt_Name.setEnabled(false);
            this.edt_Name.setText(gameList.get(index).getName());
        }
        this.btn_showRole.setText(getResources().getString(R.string.tunjukkan_peran));
        this.tv_Role.setVisibility(View.GONE);
        this.tv_Word.setVisibility(View.GONE);
        return view;
    }

    @OnClick(R.id.btn_showRole)
    void showRole() {
        boolean z;
        String lowerCase = edt_Name.getText().toString().trim().toLowerCase();
        if (edt_Name.isEnabled()) {
            if (lowerCase.equals("") || lowerCase.trim().equals("player")) {
                edt_Name.setHint("Masukkan nama Anda!");
                btn_showRole.setText(getResources().getString(R.string.tunjukkan_peran));
                edt_Name.setEnabled(true);
                return;
            }
            int i = 0;
            while (true) {
                if (i >= this.gameList.size()) {
                    z = false;
                    break;
                } else if (gameList.get(i).getName().toLowerCase().trim().equals(lowerCase)) {
                    Toast.makeText(context, "Nama ini sudah dipakai " + lowerCase, Toast.LENGTH_SHORT).show();
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                if (isChecked) {
                    tv_Role.setVisibility(View.VISIBLE);
                    tv_Word.setVisibility(View.VISIBLE);
                } else {
                    tv_Role.setVisibility(View.GONE);
                    tv_Word.setVisibility(View.VISIBLE);
                }
                setRole(index);
                gameList.get(index).setReady(true);
                gameList.get(index).setName(edt_Name.getText().toString().trim());
                edt_Name.setEnabled(false);
                imgRole1.setVisibility(View.VISIBLE);
                imgRole.setVisibility(View.INVISIBLE);
                btn_showRole.setText("OKE");
            }
        } else if (btn_showRole.getText().equals(getResources().getString(R.string.tunjukkan_peran))) {
            if (isChecked) {
                tv_Role.setVisibility(View.VISIBLE);
                tv_Word.setVisibility(View.VISIBLE);
            } else {
                tv_Role.setVisibility(View.GONE);
                tv_Word.setVisibility(View.VISIBLE);
            }
            setRole(index);
            gameList.get(index).setReady(true);
            gameList.get(index).setName(edt_Name.getText().toString().trim());
            imgRole1.setVisibility(View.VISIBLE);
            imgRole.setVisibility(View.INVISIBLE);
            btn_showRole.setText("OKE");
        } else {
            dismiss();
            edt_Name.setText("");
            gameList.get(0).setJumlah(gameList.get(0).getJumlah() + 1);
        }
    }

    private void setRole(int index) {
        String role = gameList.get(index).getRole();
        String word = gameList.get(index).getSecretWord();
        switch (role) {
            case "Alien":
                Glide.with(context)
                        .load(R.drawable.alien)
                        .into(imgRole1);
                break;
            case "Astronot 1":
                Glide.with(context)
                        .load(R.drawable.astronot)
                        .into(imgRole1);
                break;
            case "Astronot 2":
                Glide.with(context)
                        .load(R.drawable.astronot3)
                        .into(imgRole1);
                break;
        }
        tv_Role.setText(role);
        tv_Word.setText(word);
    }
}
