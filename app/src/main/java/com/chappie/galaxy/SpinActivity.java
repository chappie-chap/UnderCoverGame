package com.chappie.galaxy;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import java.util.Random;

public class SpinActivity extends AppCompatActivity {
    Button btn_spin;
    /* access modifiers changed from: private */
    private int degree = 0;
    ImageView imgBackWheel;
    ImageView imgBackWheel1;
    ImageView imgPanah;
    ImageView imgWheel;

    /* access modifiers changed from: private */
    private String currentNumber(int i) {
        return ((double) i < 0.1d || i >= 45) ? ((double) i < 45.1d || i >= 135) ? ((double) i < 135.1d || i >= 180) ? ((double) i < 180.1d || i >= 225) ? ((double) i < 225.1d || i >= 315) ? "Jelaskan pengertian tata Surya dengan bahasamu sendiri!" : "Sebutkan apa yang kamu ketahui tentang komet!" : "Jelaskan perbedaan gerak rotasi dan revolusi!" : "Selamat Anda bebas dari hukuman (^_^)" : "Sebutkan urutan planet pada tata Surya secara urut!" : "Jelaskan perbedaan meteor, meteorid ,dan meteoroid";
    }

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView( R.layout.activity_spin);
        this.btn_spin = findViewById(R.id.btn_spin);
        this.imgBackWheel = findViewById(R.id.imgBackWheel);
        this.imgBackWheel1 = findViewById(R.id.imgBackWheel1);
        this.imgWheel = findViewById(R.id.imgWheel);
        this.imgPanah =  findViewById(R.id.panahSpin);
        Glide.with( this).load(R.drawable.bg_spin1).into(this.imgBackWheel);
        Glide.with(this).load(R.drawable.bg_spin).into(this.imgBackWheel1);
        Glide.with(this).load(R.drawable.wheel_spin).into(this.imgWheel);
        Glide.with( this).load(R.drawable.panah_spin).into(this.imgPanah);
        this.btn_spin.setBackground(getResources().getDrawable(R.drawable.btn_spin));
        this.btn_spin.setOnClickListener(view -> SpinActivity.this.spin());
    }

    /* access modifiers changed from: package-private */
    void spin() {
        this.degree = new Random().nextInt(360) + 720;
        RotateAnimation rotateAnimation = new RotateAnimation((float) (this.degree % 360), (float) this.degree, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SpinActivity spinActivity = SpinActivity.this;
                spinActivity.dialogHukuman(spinActivity.currentNumber(360 - (spinActivity.degree % 360)));
            }
        });
        this.imgWheel.startAnimation(rotateAnimation);
    }

    /* access modifiers changed from: private */
    private void dialogHukuman(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hukuman");
        builder.setMessage(str);
        builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.create().show();
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
