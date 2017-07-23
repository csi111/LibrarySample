package com.robinhood.librarysample.ui.issuedetail.viewmodel;


import com.robinhood.librarysample.data.comment.Comment;

public class CommentItemViewModelImpl implements CommentItemViewModel {

    private Comment comment;

    public CommentItemViewModelImpl(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String getProfileThumbnailUrl() {
        return comment.getUser().getAvatarUrl();
    }

    @Override
    public String getCommentAuthorIdText() {
        return comment.getUser().getLogin();
    }

    @Override
    public String getCommentText() {
        return comment.getBody();
    }
}
