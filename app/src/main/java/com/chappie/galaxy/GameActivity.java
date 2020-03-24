package com.chappie.galaxy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    public static final String EXTRA_ALIEN = "extra_alien";
    public static final String EXTRA_ASTRONAUT1 = "extra_astro1";
    public static final String EXTRA_ASTRONAUT2 = "extra_astro2";
    public static final String EXTRA_CHECK = "extra_role";
    private static final String TAG = GameActivity.class.getSimpleName();
    private int CV;
    private int UD;
    private int WH;
    ImageView btn_close;
    ImageView btn_refresh;
    ArrayList<Game> gameList;
    GridAdapter gridAdapter;
    /* access modifiers changed from: private */
    private GridAdapter.GridViewHolder holder;
    private boolean isChecked;
    private boolean playAgain;
    RecyclerView recyclerView;
    /* access modifiers changed from: private */
    private int sisaAlien;
    /* access modifiers changed from: private */
    private int sisaAtronaut1;
    /* access modifiers changed from: private */
    private int sisaAtronaut2;
    ArrayList<Word> wordList;

    public boolean isPlayAgain() {
        return this.playAgain;
    }

    public void setPlayAgain(boolean z) {
        this.playAgain = z;
    }

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_game);
        this.btn_close = (ImageView) findViewById(R.id.btn_close);
        this.btn_refresh = (ImageView) findViewById(R.id.btn_refresh);
        this.recyclerView = (RecyclerView) findViewById(R.id.rv_game);
        Glide.with((FragmentActivity) this).load(R.drawable.close).into(this.btn_close);
        Glide.with((FragmentActivity) this).load(R.drawable.back).into(this.btn_refresh);
        ColumnQty columnQty = new ColumnQty(this, R.layout.item_game);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, columnQty.calculateNoOfColumns());
        this.recyclerView.addItemDecoration(new GridSpacing(columnQty.calculateSpacing()));
        this.recyclerView.setLayoutManager(gridLayoutManager);
        this.CV = getIntent().getIntExtra(EXTRA_ALIEN, 0);
        this.UD = getIntent().getIntExtra(EXTRA_ASTRONAUT1, 0);
        this.WH = getIntent().getIntExtra(EXTRA_ASTRONAUT2, 0);
        this.isChecked = getIntent().getBooleanExtra(EXTRA_CHECK, false);
        initWord();
        init();
        this.gridAdapter = new GridAdapter(this, this.gameList);
        this.recyclerView.setAdapter(this.gridAdapter);
        this.gridAdapter.setOnItemClickCallback(new GridAdapter.OnItemClickCallback() {
            public void onItemClicked(int i, GridAdapter.GridViewHolder gridViewHolder) {
                GridAdapter.GridViewHolder unused = GameActivity.this.holder = gridViewHolder;
                if (GameActivity.this.isPlayAgain()) {
                    if (!GameActivity.this.gameList.get(i).isReady()) {
                        GameActivity.this.dialogChoose(i);
                    } else if (GameActivity.this.gameList.get(0).getJumlah() == GameActivity.this.gameList.size() && GameActivity.this.gameList.get(i).isReady()) {
                        GameActivity.this.dialogVote(i);
                    }
                } else if (!GameActivity.this.gameList.get(i).isReady()) {
                    GameActivity.this.dialog(i);
                } else if (GameActivity.this.gameList.get(0).getJumlah() == GameActivity.this.gameList.size() && GameActivity.this.gameList.get(i).isReady()) {
                    GameActivity.this.dialogVote(i);
                }
            }
        });
        this.btn_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this.closeGame();
            }
        });
        this.btn_refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this.refresh();
            }
        });
    }

    /* access modifiers changed from: private */
    private void dialogChoose(final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "Kartu");
        builder.setMessage((CharSequence) "Ini adalah kartu " + this.gameList.get(i).getName());
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                GameActivity.this.dialog(i);
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    private void dialogVote(final int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "Vote");
        builder.setMessage((CharSequence) String.format("%s Akan di eliminasi", new Object[]{this.gameList.get(i).getName()}));
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                if (!GameActivity.this.gameList.get(i).getRole().equals("Astronot 2")) {
                    GameActivity.this.gameList.get(i).setEliminate(true);
                }
                GameActivity gameActivity = GameActivity.this;
                gameActivity.eliminate(gameActivity.gameList.get(i).getRole());
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    private void eliminate(String str) {
        this.holder.item_card.setEnabled(false);
        this.holder.crcGrid.setVisibility(View.INVISIBLE);
        this.holder.imgGrid.setVisibility(View.VISIBLE);
        if (str.equals("Alien")) {
            Glide.with((FragmentActivity) this).load(R.drawable.alien).into(this.holder.imgGrid);
            this.sisaAlien--;
            int i = this.sisaAlien;
            if (i > 1) {
                dialogEliminate("Yaaahhh :(", "Alien tereliminasi :(");
            } else if (i == 1) {
                dialogEliminate("Yaaahhh :(", "Alien tereliminasi :(");
            }
        } else if (str.equals("Astronot 1")) {
            Glide.with((FragmentActivity) this).load(R.drawable.astronot).into(this.holder.imgGrid);
            this.sisaAtronaut1--;
            if (this.sisaAtronaut1 != 0) {
                dialogEliminate("Gembiralah!", "Astronot 1 tereliminasi (^_^) ");
            } else {
                dialogEliminate("Gembiralah!", "Astronot 1 tereliminasi (^_^) ");
            }
        } else {
            Glide.with((FragmentActivity) this).load(R.drawable.astronot3).into(this.holder.imgGrid);
            this.sisaAtronaut2--;
            if (this.sisaAtronaut2 != 0) {
                dialogAstro();
            } else {
                dialogAstro();
            }
        }
    }

    /* access modifiers changed from: private */
    private void dialogEliminate(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) str);
        builder.setMessage((CharSequence) str2);
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                if (GameActivity.this.sisaAlien == 1) {
                    if (GameActivity.this.sisaAtronaut1 != 0 && GameActivity.this.sisaAtronaut2 != 0) {
                        GameActivity.this.dialogWin(4);
                    } else if (GameActivity.this.sisaAtronaut1 != 0) {
                        GameActivity.this.dialogWin(2);
                    } else {
                        GameActivity.this.dialogWin(3);
                    }
                } else if (GameActivity.this.sisaAtronaut1 == 0 && GameActivity.this.sisaAtronaut2 == 0) {
                    GameActivity.this.dialogWin(1);
                }
            }
        });
        builder.create().show();
    }

    private void dialogAstro() {
        final EditText editText = new EditText(this);
        final String[] strArr = {null};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "Tebak Kata");
        builder.setView((View) editText);
        builder.setMessage((CharSequence) "Tebak kata rahasia alien");
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                strArr[0] = String.valueOf(editText.getText());
                for (int i2 = 0; i2 < GameActivity.this.gameList.size(); i2++) {
                    if (GameActivity.this.gameList.get(i2).getRole().trim().equals("Alien")) {
                        if (GameActivity.this.gameList.get(i2).getSecretWord().toLowerCase().trim().equals(strArr[0].toLowerCase().trim())) {
                            GameActivity.this.gameList.get(i2).setEliminate(true);
                            dialogInterface.cancel();
                        } else {
                            dialogInterface.dismiss();
                        }
                    }
                }
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                GameActivity.this.dialogEliminate("Selamat", "Astronot 2 tereliminasi (^_^) ");
            }
        });
        create.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                GameActivity.this.dialogWin(3);
            }
        });
    }

    /* access modifiers changed from: private */
    private void dialogWin(int i) {
        final DialogAdapter3 dialogAdapter3 = new DialogAdapter3();
        dialogAdapter3.setEXTRA(this.gameList, i);
        dialogAdapter3.show(getSupportFragmentManager(), "Dialog 3");
        getSupportFragmentManager().executePendingTransactions();
        dialogAdapter3.btn_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialogAdapter3.dismiss();
                GameActivity.this.setPlayAgain(true);
                GameActivity.this.gameList.get(0).setJumlah(0);
                GameActivity.this.initAgain();
                GameActivity.this.gridAdapter.notifyDataSetChanged();
            }
        });
        dialogAdapter3.btn_hukuman.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this.startActivity(new Intent(GameActivity.this, SpinActivity.class));
                GameActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    private void dialog(final int i) {
        final DialogAdapter2 dialogAdapter2 = new DialogAdapter2();
        dialogAdapter2.setEXTRA(this.gameList, this.isChecked, i);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        dialogAdapter2.show(supportFragmentManager, "Dialog2");
        supportFragmentManager.executePendingTransactions();
        dialogAdapter2.btn_showRole.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialogAdapter2.showRole();
                if (!GameActivity.this.gameList.get(i).getName().trim().equals("Player")) {
                    GameActivity.this.holder.titleGrid.setText(GameActivity.this.gameList.get(i).getName().trim());
                    GameActivity.this.mulai(i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    private void mulai(int i) {
        if (this.gameList.get(0).getJumlah() == this.gameList.size() && this.gameList.get(i).isReady()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.gameList.size(); i2++) {
                arrayList.add(this.gameList.get(i2).getName());
            }
            Collections.shuffle(arrayList);
            ImageView imageView = new ImageView(this);
            ((RequestBuilder) Glide.with((FragmentActivity) this).load(R.drawable.slide10).override(350, 450)).into(imageView);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "Mulai");
            builder.setView((View) imageView);
            builder.setMessage((CharSequence) "Deskripsi dimulai dari " + ((String) arrayList.get(0)));
            builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        }
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.wordList.size()) {
            if (!this.wordList.get(i).isPlayed()) {
                arrayList.add(this.wordList.get(i).getsWord1());
                arrayList.add(this.wordList.get(i).getsWord2());
                i = this.wordList.size();
            }
            if (i == this.wordList.size() && arrayList.get(0) == null) {
                initWord();
                i = 0;
            }
            i++;
        }
        this.gameList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = this.CV;
            int i4 = this.UD;
            int i5 = this.WH;
            if (i2 < i3 + i4 + i5) {
                if (i2 < i3) {
                    this.gameList.add(new Game("Player", "Alien", (String) arrayList.get(0), false, false, 0));
                } else if (i2 < i3 + i4) {
                    this.gameList.add(new Game("Player", "Astronot 1", (String) arrayList.get(1), false, false, 0));
                } else if (i2 < i3 + i4 + i5) {
                    this.gameList.add(new Game("Player", "Astronot 2", "^^", false, false, 0));
                }
                i2++;
            } else {
                Collections.shuffle(this.gameList);
                this.gameList.get(0).setJumlah(0);
                this.sisaAlien = this.CV;
                this.sisaAtronaut1 = this.UD;
                this.sisaAtronaut2 = this.WH;
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    private void initAgain() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.wordList.size()) {
            if (!this.wordList.get(i).isPlayed()) {
                arrayList.add(this.wordList.get(i).getsWord1());
                arrayList.add(this.wordList.get(i).getsWord2());
                i = this.wordList.size();
            }
            if (i == this.wordList.size() && arrayList.get(0) == null) {
                initWord();
                i = 0;
            }
            i++;
        }
        Collections.shuffle(arrayList);
        Collections.shuffle(this.gameList);
        int i2 = 0;
        while (true) {
            int i3 = this.CV;
            int i4 = this.UD;
            int i5 = this.WH;
            if (i2 < i3 + i4 + i5) {
                if (i2 < i3) {
                    this.gameList.get(i2).setRole("Alien");
                    this.gameList.get(i2).setEliminate(false);
                    this.gameList.get(i2).setReady(false);
                    this.gameList.get(i2).setSecretWord((String) arrayList.get(0));
                } else if (i2 < i3 + i4) {
                    this.gameList.get(i2).setRole("Astronot 1");
                    this.gameList.get(i2).setEliminate(false);
                    this.gameList.get(i2).setReady(false);
                    this.gameList.get(i2).setSecretWord((String) arrayList.get(1));
                } else if (i2 < i3 + i4 + i5) {
                    this.gameList.get(i2).setRole("Astronot 2");
                    this.gameList.get(i2).setEliminate(false);
                    this.gameList.get(i2).setReady(false);
                    this.gameList.get(i2).setSecretWord("^^");
                }
                i2++;
            } else {
                Collections.shuffle(this.gameList);
                this.sisaAlien = this.CV;
                this.sisaAtronaut1 = this.UD;
                this.sisaAtronaut2 = this.WH;
                return;
            }
        }
    }

    private void initWord() {
        this.wordList = new ArrayList<>();
        this.wordList.add(new Word("Matahari", "Bulan", false));
        this.wordList.add(new Word("Rotasi Bumi", "Revolusi Bumi", false));
        this.wordList.add(new Word("Venus", "Mars", false));
        this.wordList.add(new Word("Merkurius", "Bumi", false));
        this.wordList.add(new Word("Jupiter", "Saturnus", false));
        this.wordList.add(new Word("Uranus", "Neptunus", false));
        this.wordList.add(new Word("Asteroid", "Komet", false));
        this.wordList.add(new Word("Meteor", "Planet", false));
        Collections.shuffle(this.wordList);
    }

    /* access modifiers changed from: private */
    private void closeGame() {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    private void refresh() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "Exit");
        builder.setMessage((CharSequence) "Anda yakin ingin reset Game ?");
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                GameActivity.this.gameList.get(0).setJumlah(0);
                GameActivity.this.setPlayAgain(true);
                GameActivity.this.initAgain();
                GameActivity.this.gridAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "Keluar Game");
        builder.setMessage((CharSequence) "Anda yakin ingin keluar dari Game ?");
        builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                GameActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int x) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
