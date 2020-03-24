package com.chappie.galaxy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private Context context;
    private List<Game> gameList;
    /* access modifiers changed from: private */
    private OnItemClickCallback onItemClickCallback;

    public interface OnItemClickCallback {
        void onItemClicked(int i, GridViewHolder gridViewHolder);
    }

    /* access modifiers changed from: package-private */
    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback2) {
        this.onItemClickCallback = onItemClickCallback2;
    }

    GridAdapter(Context context2, List<Game> list) {
        this.context = context2;
        this.gameList = list;
    }

    @NonNull
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GridViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_game, viewGroup, false));
    }

    @SuppressLint("DefaultLocale")
    public void onBindViewHolder(final GridViewHolder gridViewHolder, final int i) {
        gridViewHolder.item_card.setEnabled(true);
        Glide.with(this.context).load(R.drawable.table).into(gridViewHolder.bgGrid);
        Glide.with(this.context).load(R.drawable.logo3rev2).into(gridViewHolder.crcGrid);
        gridViewHolder.crcGrid.setVisibility(View.VISIBLE);
        gridViewHolder.imgGrid.setVisibility(View.INVISIBLE);
        if (this.gameList.get(i).getName().trim().equals("Player")) {
            gridViewHolder.titleGrid.setText(String.format("%s %d", this.gameList.get(i).getName(), i + 1));
        } else {
            gridViewHolder.titleGrid.setText(String.format("%s", this.gameList.get(i).getName()));
        }
        gridViewHolder.itemView.setOnClickListener(view -> GridAdapter.this.onItemClickCallback.onItemClicked(i, gridViewHolder));
    }

    public int getItemCount() {
        return this.gameList.size();
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView bgGrid;
        CircleImageView crcGrid;
        ImageView imgGrid;
        CardView item_card;
        TextView titleGrid;

        GridViewHolder(View view) {
            super(view);
            this.bgGrid = view.findViewById(R.id.bgGrid);
            this.imgGrid = view.findViewById(R.id.imgGrid);
            this.crcGrid = view.findViewById(R.id.crcGrid);
            this.titleGrid = view.findViewById(R.id.titleGrid);
            this.item_card =  view.findViewById(R.id.item_game);
        }
    }
}
