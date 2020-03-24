package com.chappie.galaxy;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView bg;
    private ImageView btn_caraMain;
    private ImageView btn_close;
    private ImageView btn_game;
    private ImageView btn_info;
    private ImageView btn_materi;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_menu);
        this.bg = findViewById(R.id.backgroundMenu);
        this.btn_materi = findViewById(R.id.btn_materi);
        this.btn_game = findViewById(R.id.btn_game);
        this.btn_caraMain = findViewById(R.id.btn_caraMain);
        this.btn_close = findViewById(R.id.btn_closeMenu);
        this.btn_info = findViewById(R.id.btn_info);
        this.btn_materi.setOnClickListener(this);
        this.btn_game.setOnClickListener(this);
        this.btn_caraMain.setOnClickListener(this);
        this.btn_close.setOnClickListener(this);
        this.btn_info.setOnClickListener(this);
        this.bg.setBackground(new BitmapDrawable(getResources(), BlurBuilder.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.bg))));
        /*if (Build.VERSION.SDK_INT >= 21) {
        } else {
            Glide.with( this).load(R.drawable.bg).into(this.bg);
        }*/
        Glide.with(this).load(R.drawable.materi).into(this.btn_materi);
        Glide.with(this).load(R.drawable.game).into(this.btn_game);
        Glide.with(this).load(R.drawable.cara_bermain).into(this.btn_caraMain);
        Glide.with(this).load(R.drawable.close).into(this.btn_close);
        Glide.with(this).load(R.drawable.informasi).into(this.btn_info);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_caraMain /*2131296337*/:
                IntenActivity(MainActivity.class);
                return;
            case R.id.btn_closeMenu /*2131296339*/:
                onBackPressed();
                return;
            case R.id.btn_game /*2131296340*/:
                new DialogAdapter().show(getSupportFragmentManager(), "Example");
                return;
            case R.id.btn_info /*2131296342*/:
                IntenActivity(InfoActivity.class);
                return;
            case R.id.btn_materi /*2131296348*/:
                IntenActivity(MateriActivity.class);
                return;
            default:
        }
    }

    private void IntenActivity(Class cls) {
        startActivity(new Intent(this, cls));
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle(getString(R.string.exit_app))
                .setMessage(getString(R.string.message_exit))
                .setNegativeButton(getString(R.string.batal), null)
                .setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> {
            dialogInterface.dismiss();
            MenuActivity.this.finishAffinity();
        }).create().show();
    }
}
