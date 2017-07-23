package com.robinhood.librarysample.ui.issuedetail.viewmodel;


import com.robinhood.librarysample.data.comment.Comment;

public class CommentItemViewModelImpl implements CommentItemViewModel {

    private Comment mComment;

    public CommentItemViewModelImpl(Comment mComment) {
        this.mComment = mComment;
    }

    @Override
    public String getCommentAuthorIdText() {
        return mComment.getUser().getLogin();
    }

    @Override
    public String getCommentText() {
        return mComment.getBody();
    }
}
