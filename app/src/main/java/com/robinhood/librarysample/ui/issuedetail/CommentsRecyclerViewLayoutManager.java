package com.robinhood.librarysample.ui.issuedetail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CommentsRecyclerViewLayoutManager extends LinearLayoutManager {


    public CommentsRecyclerViewLayoutManager(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 10, 10, 0);

        return layoutParams;
    }


}
