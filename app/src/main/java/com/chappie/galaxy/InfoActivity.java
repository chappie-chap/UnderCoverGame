package com.chappie.galaxy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class InfoActivity extends AppCompatActivity {

    /* access modifiers changed from: protected */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_info);
        ImageView roket = findViewById(R.id.Imgroket);
        ImageView bgfoto = findViewById(R.id.tbl_info);
        ImageView foto = findViewById(R.id.circleImageView);
        ImageView bginfo = findViewById(R.id.tbl_info_desc);
        TextView tujuan = findViewById(R.id.info_tvTujuan);
        TextView version = findViewById(R.id.version);
        Glide.with(this).load(R.drawable.table).into(bginfo);
        Glide.with(this).load(R.drawable.table).into(bgfoto);
        Glide.with( this).load(R.drawable.bg_putih).into(foto);
        Glide.with( this).load(R.drawable.roket).into(roket);
        tujuan.setText("1. Dapat menyebutkan anggota tata surya.\n" +
                "2. Dapat menjelaskan sistem tata surya.\n" +
                "3. Dapat membedakan meteor, meteorit, dan meteoroid dengan tepat.\n"+
                "4. Dapat mengurutkan planet dari yang paling dekat dengan matahari hingga planet yang paling jauh dari matahari dengan tepat.\n" +
                "5. Dapat mengkarakteristikan anggota tata surya dengan tepat.\n");
        version.setText("Versi "+BuildConfig.VERSION_NAME);

    }
}
