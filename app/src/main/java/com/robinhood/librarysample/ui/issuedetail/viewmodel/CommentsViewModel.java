package com.robinhood.librarysample.ui.issuedetail.viewmodel;


import com.robinhood.librarysample.base.viewmodel.NotifyUpdateViewModelListener;


public interface CommentsViewModel {
    void refreshComments();

    void fetchComments();

    boolean showIndicator();

    void setUpdateViewModelListener(NotifyUpdateViewModelListener listener);

}
