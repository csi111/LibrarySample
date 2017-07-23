package com.robinhood.librarysample.data.comment;

import android.support.annotation.NonNull;

public interface CommentsDataSource {

    interface LoadCommentsCallback {
        void onCommentsLoaded(Comments comments);

        void onCommentsFailed(int code, String message);
    }

    interface PostCommentCallback {
        void onCommentPosted(Comment comment);

        void onCommentPostFailed(int code, String message);

    }

    void getComments(int issueNumber, @NonNull LoadCommentsCallback callback);

    void createComment(int number, String body, PostCommentCallback callback);
}
