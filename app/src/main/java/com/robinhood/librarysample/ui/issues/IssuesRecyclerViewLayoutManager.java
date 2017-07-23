package com.robinhood.librarysample.ui.issues;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class IssuesRecyclerViewLayoutManager extends LinearLayoutManager {

    public IssuesRecyclerViewLayoutManager(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        return layoutParams;
    }


}
