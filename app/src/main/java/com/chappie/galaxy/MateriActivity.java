package com.chappie.galaxy;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class MateriActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView btn_asteroid;
    private ImageView btn_bulan;
    private ImageView btn_bumi;
    private ImageView btn_jupiter;
    private ImageView btn_komet;
    private ImageView btn_komet1;
    private ImageView btn_mars;
    private ImageView btn_mercurius;
    private ImageView btn_meteor;
    private ImageView btn_meteor1;
    private ImageView btn_neptunus;
    private ImageView btn_saturnus;
    private ImageView btn_sun;
    private ImageView btn_uranus;
    private ImageView btn_venus;
    private ImageView orbitImg;
    private ArrayList<TataSurya> tataSuryaList;
    private ImageView btn_pluto;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_materi);
        ConstraintLayout layoutMateri = findViewById(R.id.LayoutMateri);
        this.orbitImg = findViewById(R.id.imageView4);
        this.btn_sun = findViewById(R.id.btn_sun);
        this.btn_mercurius = findViewById(R.id.btn_mercurius);
        this.btn_venus = findViewById(R.id.btn_venus);
        this.btn_bumi = findViewById(R.id.btn_bumi);
        this.btn_mars = findViewById(R.id.btn_mars);
        this.btn_jupiter = findViewById(R.id.btn_jupiter);
        this.btn_saturnus = findViewById(R.id.btn_saturnus);
        this.btn_uranus = findViewById(R.id.btn_uranus);
        this.btn_neptunus = findViewById(R.id.btn_neptunus);
        this.btn_komet = findViewById(R.id.btn_komet);
        this.btn_komet1 = findViewById(R.id.btn_komet1);
        this.btn_asteroid = findViewById(R.id.btn_asteroid);
        this.btn_meteor = findViewById(R.id.btn_meteor);
        this.btn_meteor1 = findViewById(R.id.btn_meteor1);
        this.btn_bulan = findViewById(R.id.btn_bulan);
        this.btn_pluto = findViewById(R.id.btn_pluto);
        this.btn_sun.setOnClickListener(this);
        this.btn_mercurius.setOnClickListener(this);
        this.btn_venus.setOnClickListener(this);
        this.btn_bumi.setOnClickListener(this);
        this.btn_mars.setOnClickListener(this);
        this.btn_jupiter.setOnClickListener(this);
        this.btn_saturnus.setOnClickListener(this);
        this.btn_uranus.setOnClickListener(this);
        this.btn_neptunus.setOnClickListener(this);
        this.btn_komet.setOnClickListener(this);
        this.btn_komet1.setOnClickListener(this);
        this.btn_asteroid.setOnClickListener(this);
        this.btn_meteor.setOnClickListener(this);
        this.btn_meteor1.setOnClickListener(this);
        this.btn_bulan.setOnClickListener(this);
        this.btn_pluto.setOnClickListener(this);
        layoutMateri.setBackground(new BitmapDrawable(getResources(), BlurBuilder.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.urutan))));
        /*if (Build.VERSION.SDK_INT >= 21) {
        } else {
            this.layoutMateri.setBackground(getResources().getDrawable(R.drawable.urutan));
        }*/
        this.tataSuryaList = new ArrayList<>();
        initData();
        initImage();
    }

    private void initData() {
        this.tataSuryaList.add(new TataSurya(R.drawable.matahari_asli, "Matahari", "Matahari merupakan salah satu bintang dalam galaksi bima sakti yang memiliki sistem tata surya sendiri. Matahari merupakan sebuah bola gas raksasa yang berpijar dan mengeluarkan panas. Jarak bumi dari matahari adalah 149.600.000 Km. Perbandingan ukuran matahari dengan bumi dapat diibaratkan bahwa matahari adalah bola berongga, maka 1 juta bumi dapat dimasukan ke dalamnya. Matahari memiliki diameter sekitar 1,4 juta Km, suhu di permukaan matahari mencapai kurang lebih 5000° C. Matahari memiliki massa sekitar 1,9 x 1030 Kg.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.merkurius_asli, "Merkurius", "Merkurius merupakan planet yang paling dekat dengan matahari, dan merupakan planet terkecil di dalam system tata surya. Planet merkurius tidak memiliki satelit. Jarak rata-rata merkurius dengan matahari sekitar 57 juta Km, dengan diameter sebesar 4.879,4 Km, atau sekitar 40% dari diameter bumi, sedangkan massa planet merkurius adalah 3,3022 X 1023 Kg. Planet ini membutuhkan waktu sekitar 88 hari untuk sekali berputar mengitari matahari (revolusi), dan 59 hari berputar pada porosnya (rotasi). Permukaan planet merkurius berlubang-lubang seperti bulan dan memiliki banyak kawah. Suhu rata-rata planet ini sangat mencolok pada siang dan malam hari. Saat siang, suhu merkurius mencapai 430° C, sedangkan pada malam hari suhu dapat mencapai -180° C.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.venus_asli, "Venus", "Venus merupakan planet kedua dari matahari setelah merkurius, jarak venus dengan matahari adalah 108,2 juta Km, dan memiliki diameter 12.092 Km. venus membutuhkan waktu selama 225 hari untuk mengelilingi matahari (revolusi), dan membutuhkan waktu selama -243 hari berputar pada porosnya (rotasi). Penggunaan tanda minus menunjukan bahwa arah rotasi planet venus berlawanan dengan arah rotasi planet dalam tata surya lainnya. Venus sering disebut sebagai bintang kejora, bintang barat, bintang timur, bintang senja, dan bintang fajar, karena venus merupakan planet yang paling terang, dan terlihat labih terang dari bumi ketika langit cerah pada saat senja dan fajar. Venus memiliki suhu terpanas diantara planet-planet lainnya di dalam system tata surya, suhunya mencapai lebih dari 500° C. planet venus memiliki massa sebesar 4,8676 X 1024 Kg.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.bumi_asli, "Bumi", "Bumi merupakan planet ketiga dari matahari setelah venus. Bumi adalah satu-satunya planet dalam tata surya yang berpenghuni. Jarak bumi dengan matahari kurang lebih sejauh 150 juta Km, dengan diameter 12.756 Km. Bumi berbentuk bulat hampir sempurna dengan luas permukaan 510.072.000 Km2, dan lautan seluas 361.132.000 Km2. Bumi membutuhkan waktu selama 365 hari untuk sekali mengitari matahari (revolusi), dan memerlukan waktu selama 24 jam untuk sekali berputar pada porosnya (rotasi). Revolusi dan rotasi bumi memberikan dampak pada kehidupan di bumi. Dampak dari rotasi bumi yaitu terjadinya siang dan malam, perbedaan waktu di berbagai daerah di bumi, gerak semu harian matahari, perbedaan percepatan gravitasi, pembelokan arah mata angina, pembelokan arus air laut, dan pemepetan bumi di daerah kutub. Sedangkan dampak dari revolusi bumi yaitu, perbedaan lama siang dan malam, gerak semu tahunan matahari, perubahan musim, perubahan rasi bintang, dan penanggalan kalender masehi.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.mars_asli, "Mars", "Mars merupakan planet keempat dari matahari setelah bumi. Jarak planet mars dengan matahari adalah 230 juta Km, dengan diameter 6.792 Km, atau sekitar separuh dari diameter bumi. Planet mars memiliki massa sebesar 6,4185 X 1023 Kg. Mars sering disebut dengan planet merah, karena permukaan mars ditutupi oleh debu besi oksida yang berwarna merah, sehingga planet ini tampak berwarna merah. Planet mars membutuhkan waktu 1 tahun lebih 320 hari untuk 1 kali mengitari matahari (revolusi), dan membutuhkan waktu selama 24 jam lebih 39 menit untuk 1 kali berputar pada porosnya (rotasi). Suhu rata-rata di planet mars sebesar -87° C sampai dengan -5° C. Mars memiliki 2 satelit alami, yaitu phobos dan deimos.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.jupiter_asli, "Jupiter", "Planet jupiter merupakan planet kelima dari matahari setelah planet mars. Planet jupiter merupakan planet terbesar di sistem tata surya, diameternya mencapai 142,984 Km, dan jaraknya dari matahari sejauh 778,3 Km. Planet jupiter membutuhkan waktu selama kurang lebih 10 jam untuk sekali berputar pada porosnya (rotasi), dan membutuhkan waktu selama 11,9 tahun untuk sekali berputar mengelilingi matahari (revolusi). Jupiter juga memiliki cincin, dengan ketebalan cincin utamanya kurang lebih 30 Km, sedangkan lebarnya lebih dari 6.400 Km. suhu atas awan pada planet jupiter kurang lebih -145° C. Jupiter memiliki 16 satelit yang sudah teridentifikasi, diantaranya adrastea, amalthea, callisto, carpo, europa, elara, metis, io, thebe, ganymede, leda, himalia, lysithea.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.saturnus_asli, "Saturnus", "Planet saturnus merupakan planet keenam dari matahari setelah planet Jupiter, dengan jaraknya denga matahari sejauh 1.427 juta Km. saturnus merupakan planet yang memiliki cincin terbesar dari semua planet yang ada di tata surya. Cincin tersebut terbentuk dari partikel-partikel gas beku dan batu karang kecil. Cincin ini terletah antara 6.630 – 120.700 Km di atas atmosfer planet saturnus. Planet saturnus memiliki massa sebesar 5,6846 X 1026 Kg, dan memiliki diameter sbesar 120.536 Km. Planet saturnus membutuhkan waktu 29,46 tahun untuk 1 kali mengitari matahari (revolusi), dan membutuhkan waktu selama 10 jam lebih 40 menit untuk 1 kali berputar pada porosnya (rotasi). Suhu rata-rata planet saturnus adalah -164° C. Saturnus memiliki 59 satelit alami yang telah teridentifikasi, diantaranya, titan, rhea, lapetus, dione, tethys, enceladus, dan mimas.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.uranus_asli, "Uranus", "Uranus merupkan planet ketujuh dari matahari setelah saturnus, dengan jarak sejauh 2.871 juta Km, dan diameter sepanjang 51.118 Km. Suhu pada planet Uranus dapat mencapai -220° C. Bila diamati, saturnus akan memancarkan warna hijau kebiruan. Planet Uranus memiliki massa 8,6810 X 1025 Kg. Planet uranus membutuhkan waktu 84 tahun untuk 1 kali mengitari matahari (revolusi), dan membutuhkan waktu selama 17,25 jam untuk 1 kali berputar pada porosnya (rotasi). Uranus memiliki 27 satelit alami yang sudah teridentifikasi, diantaranya ariel, titania, Ophelia, oberon, dan miranda.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.neptunus_asli, "Neptunus", "Neptunus adalah planet kedelapan atau planet terakhir dari matahari pada system tata surya. Jarak neptunus dengan matahari adalah 4.450 juta Km, dan memiliki diameter sepanjang 49.530 Km. Neptunus memiliki massa sebesar 1,0243 X 1026 Kg, dan memiliki suhu rata-rata -217° C. Planet neptunus membutuhkan waktu 164,8 tahun untuk 1 kali mengitari matahari (revolusi), dan membutuhkan waktu selama 11,611 jam untuk 1 kali berputar pada porosnya (rotasi). Neptunus memiliki 14 satelit alami yang sudah teridentifikasi, diantaranya triton, nereid, naiad, thalassa, despina, galatea, dan larissa.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.moon, "Bulan", "Bumi memiliki satu satelit alami, yaitu bulan. Selain bumi, bulan juga mengalami rotasi dan revolusi. Waktu yang diperlukan untuk sekali berotasi dan berevolusi sama yakni 29 ½ hari (1 bulan). Gerakan bumi dan bulan mengakibatkan gerhana bulan, dan matahari. Gerhana bulan terjadi apabila matahari, bui, dan bulan, berada pada sat ugaris lurus, sedangkan gerhana matahari terjadi apabila posisi bulan berada di antara matahari dan bumi, sehingga sinar matahari ke bumi terhalang oleh bulan.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.komet_asli, "Komet", "Nama komet berasal dari Bahasa Yunani yang artinya rambut panjang, hal ini dikarenakan bentuk komet yang seperti rambut Panjang. Komet adalah sekumpulan gas dan debu yang membeku pada saat jauh dari matahari yang mengorbit matahari dengan lintasan parabolis atau lonjong. Komet sering disebut juga dengan bintang berekor, karena bila dilihat dari bumi berbentuk bintang yang memiliki ekor. Namun, sifat komet berbeda dengan bintang, komet tidak memancarkan cahaya, namun memantulkan cahaya matahari. Ekor dan kepala komet terbentuk dari penguapan materi penyusun ketika komet mendekati matahari. Sifat dari ekor komet adalah selalu menjauhi matahari. Panjang komet dapat mencapai jutaan kilometer. Komet biasanya diberi nama sesuai dengan nama penemunya. Berikut adalah beberapa komet yang ditemukan, diantaranya, kohoutek, halley, encke. Lilin, swan, bode, maikos, arend-roland, dan lain sebagainya.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.asteroid_asli, "Asteroid", "Asteroid dalam Bahasa Yunani berarti seperti bintang atau berbentuk bintang. Asteroid adalah semua benda atau objek kecil yang bergerak mengelilingi matahari yang unsur penyusunnya terdiri dari gas beku dan debu (Danang, 2017:38). Beberapa satelit juga memiliki satelit alami seperti planet. Asteroid diklasifikasikan berdasarkan pada karakteristik spectrum emisi, yaitu tipe-c (karbon, tipe-m (logam, dan tipe-s (silikat). Beberapa asteroid sudah teridentifikasi dan diberi nama serta tahun penemuan, diantaranya adalah ceres (1801), pallas (1801), hebe (1847), irene (1851), iris (1847), dan flora (1847).\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.meteor_asli, "Meteor", "Meteor adalah benda angkasa berupa batuan atau campuran antara batuan dan logam yang jatuh dan masuk ke dalam atmosfir bumi. Pada umumnya, meteor ketika jatuh ke bumi akan terbakar habis, karena terbakar akibat gesekan, sehingga menimbulkan pijar cahaya, seperti bola yang terbakar. Adapun meteor yang tidak habis terbakar dan jatuh ke permukaan bumi disebut dengan meteorit. Sedangkan, meteoroid adalah meteor yang melayang-layang di angkasa dengan kecepatan tinggi dan tanpa memiliki orbit.\n"));
        this.tataSuryaList.add(new TataSurya(R.drawable.pluto_asli, "Pluto", "Tahukah kalian bahwa pada tanggal 24 Agustus 2006 pada konferensi Internasional Astronomical Union (IAU) yang ke-26, ditetapkan bahwa Pluto tidak lagi menjadi anggota dari planet tata surya Bima Sakti. Pluto dikategorikan menjadi planet kerdil/dwarf planet/planet katai. Planet katai sendiri merupakan sebutan bagi benda-benda langit yang mengelilingi matahari, memiliki massa yang cukup, memiliki orbit sendiri, dan bukan merupakan satelit sebuah planet. Pluto tidak lagi dikategorikan sebagai planet dikarenakan karakteristiknya yang tidak sesuai dengan syarat planet yaitu, mengorbit matahari, berukuran cukup besar sehingga dapat mempertahankan bentuknya, dan memiliki jalur orbit yang jelas dan tidak ada benda langit lain yang mengorbit pada lintasan yang sama. Pluto memiliki jalur orbit yang juga diorbit oleh benda langit lain, dan lintasan Pluto tidak bersih dari puing-puing serta benda langit lain, sehingga pluto tidak lagi dapat dikategorikan sebagai planet.\n"));
    }

    /* access modifiers changed from: package-private */
    private void initImage() {
        Glide.with(this).load(R.drawable.orbit).into(this.orbitImg);
        Glide.with(this).load(R.drawable.sun_outline).into(this.btn_sun);
        Glide.with(this).load(R.drawable.merkurius_outline).into(this.btn_mercurius);
        Glide.with(this).load(R.drawable.venus_outline).into(this.btn_venus);
        Glide.with(this).load(R.drawable.bumi_outline).into(this.btn_bumi);
        Glide.with(this).load(R.drawable.mars_outline).into(this.btn_mars);
        Glide.with(this).load(R.drawable.jupiter_outline).into(this.btn_jupiter);
        Glide.with(this).load(R.drawable.saturnus_outline).into(this.btn_saturnus);
        Glide.with(this).load(R.drawable.uranus_outline).into(this.btn_uranus);
        Glide.with(this).load(R.drawable.neptunus_outline).into(this.btn_neptunus);
        Glide.with(this).load(R.drawable.komet1_outline).into(this.btn_komet);
        Glide.with(this).load(R.drawable.komet_outline).into(this.btn_komet1);
        Glide.with(this).load(R.drawable.asteroid_outline).into(this.btn_asteroid);
        Glide.with(this).load(R.drawable.meteor_outline).into(this.btn_meteor);
        Glide.with(this).load(R.drawable.meteor1_outline).into(this.btn_meteor1);
        Glide.with(this).load(R.drawable.moon_outline).into(this.btn_bulan);
        Glide.with(this).load(R.drawable.pluto).into(this.btn_pluto);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_sun) {
            IntentDetail(0);
        } else if (id == R.id.btn_mercurius) {
            IntentDetail(1);
        } else if (id == R.id.btn_venus) {
            IntentDetail(2);
        } else if (id == R.id.btn_bumi) {
            IntentDetail(3);
        } else if (id == R.id.btn_mars) {
            IntentDetail(4);
        } else if (id == R.id.btn_jupiter) {
            IntentDetail(5);
        } else if (id == R.id.btn_saturnus) {
            IntentDetail(6);
        } else if (id == R.id.btn_uranus) {
            IntentDetail(7);
        } else if (id == R.id.btn_neptunus) {
            IntentDetail(8);
        } else if (id == R.id.btn_bulan) {
            IntentDetail(9);
        } else if (id == R.id.btn_komet || id == R.id.btn_komet1) {
            IntentDetail(10);
        } else if (id == R.id.btn_asteroid) {
            IntentDetail(11);
        } else if (id == R.id.btn_meteor || id == R.id.btn_meteor1) {
            IntentDetail(12);
        }else if(id == R.id.btn_pluto){
            IntentDetail(13);
        }
    }

    private void IntentDetail(int i) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_LIST, this.tataSuryaList.get(i));
        startActivity(intent);
    }
}
