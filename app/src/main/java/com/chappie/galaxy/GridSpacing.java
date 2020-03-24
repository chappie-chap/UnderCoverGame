package com.chappie.galaxy;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacing extends RecyclerView.ItemDecoration {
    private final int spacing;

    GridSpacing(int i) {
        this.spacing = i;
    }

    public void getItemOffsets(Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int i = this.spacing;
        rect.left = i;
        rect.right = i;
        rect.top = i;
        rect.bottom = i;
    }
}
