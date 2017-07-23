package com.robinhood.librarysample.ui.issues.viewmodel;

import android.view.View;

public interface IssueItemViewModel {

    String getTitleText();

    String getIssueIdText();

    void onItemClick(View view);
}
