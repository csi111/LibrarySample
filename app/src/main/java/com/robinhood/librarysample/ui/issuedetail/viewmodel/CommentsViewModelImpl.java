package com.robinhood.librarysample.ui.issuedetail.viewmodel;

import com.google.firebase.crash.FirebaseCrash;
import com.robinhood.librarysample.base.viewmodel.NotifyUpdateViewModelListener;
import com.robinhood.librarysample.data.comment.Comment;
import com.robinhood.librarysample.data.comment.Comments;
import com.robinhood.librarysample.data.comment.CommentsDataSource;
import com.robinhood.librarysample.data.comment.CommentsRepository;

import java.util.ArrayList;
import java.util.List;

public class CommentsViewModelImpl implements CommentsViewModel, CommentCommander {

    private int mIssueNumber;
    private NotifyUpdateViewModelListener notifyUpdateViewModelListener;

    public CommentsViewModelImpl(int issueNumber) {
        this.mIssueNumber = issueNumber;
    }

    @Override
    public void refreshComments() {
        fetchComments();
    }

    @Override
    public void fetchComments() {
        CommentsRepository.getInstance().getComments(mIssueNumber, new CommentsDataSource.LoadCommentsCallback() {
            @Override
            public void onCommentsLoaded(Comments comments) {
                List<CommentItemViewModel> itemVMList = new ArrayList<>();
                for (Comment comment : comments.getModels()) {
                    itemVMList.add(new CommentItemViewModelImpl(comment));
                }

                if (notifyUpdateViewModelListener != null) {
                    notifyUpdateViewModelListener.onUpdatedViewModel(itemVMList);
                }
            }

            @Override
            public void onCommentsFailed(int code, String message) {
                FirebaseCrash.log("Comment List Load Failed code = [" + code + "] message = [" + message + "]");
                throw new IllegalMonitorStateException("Comment List Failed");
            }
        });
    }

    @Override
    public boolean showIndicator() {
        return false;
    }

    @Override
    public void setUpdateViewModelListener(NotifyUpdateViewModelListener listener) {
        notifyUpdateViewModelListener = listener;
    }

    @Override
    public void refresh() {
        refreshComments();
    }


}
