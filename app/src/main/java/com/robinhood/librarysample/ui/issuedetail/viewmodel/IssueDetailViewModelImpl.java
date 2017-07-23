package com.robinhood.librarysample.ui.issuedetail.viewmodel;

import android.view.View;

import com.robinhood.librarysample.base.command.MessageNotifyCommand;
import com.robinhood.librarysample.base.databinding.BindableString;
import com.robinhood.librarysample.data.comment.Comment;
import com.robinhood.librarysample.data.comment.CommentsDataSource;
import com.robinhood.librarysample.data.comment.CommentsRepository;
import com.robinhood.librarysample.data.issue.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueDetailViewModelImpl implements IssueDetailViewModel {

    private int mIssueNumber;
    private String mTitleText = "";
    private String mContentsText = "";
    private BindableString mCommentsText = new BindableString();

    private List<CommentCommander> mCommanders = new ArrayList<>();

    private MessageNotifyCommand mNotifyCommand;

    public IssueDetailViewModelImpl() {
    }

    public IssueDetailViewModelImpl(Issue issue) {
        if (issue != null) {
            mTitleText = issue.getTitle();
            mContentsText = issue.getBody();
            mIssueNumber = issue.getNumber();
        }
    }

    protected IssueDetailViewModelImpl(android.os.Parcel in) {
        mIssueNumber = in.readInt();
        mTitleText = in.readString();
        mContentsText = in.readString();
        mCommentsText = new BindableString();
        mCommentsText.set(in.readString());

    }

    public static final Creator<IssueDetailViewModelImpl> CREATOR = new Creator<IssueDetailViewModelImpl>() {
        @Override
        public IssueDetailViewModelImpl createFromParcel(android.os.Parcel in) {
            return new IssueDetailViewModelImpl(in);
        }

        @Override
        public IssueDetailViewModelImpl[] newArray(int size) {
            return new IssueDetailViewModelImpl[size];
        }
    };

    @Override
    public String getTitleText() {
        return mTitleText;
    }

    @Override
    public String getContentsText() {
        return mContentsText;
    }

    @Override
    public BindableString getCommentText() {
        return mCommentsText;
    }

    @Override
    public int getIssueNumber() {
        return mIssueNumber;
    }

    @Override
    public void onClickSendComment(View view) {
        CommentsRepository.getInstance().createComment(mIssueNumber, mCommentsText.get(), new CommentsDataSource.PostCommentCallback() {
            @Override
            public void onCommentPosted(Comment comment) {
                commandRefreshAll();
            }

            @Override
            public void onCommentPostFailed(int code, String message) {
                if (mNotifyCommand != null) {
                    mNotifyCommand.execute(message);
                }
            }
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(mIssueNumber);
        parcel.writeString(mTitleText);
        parcel.writeString(mContentsText);
        parcel.writeString(mCommentsText.get());
    }

    private void commandRefreshAll() {
        if (mCommanders != null && mCommanders.size() > 0) {
            for (CommentCommander commander : mCommanders) {
                commander.refresh();
            }
        }
    }

    @Override
    public void setCommander(CommentCommander commander) {
        this.mCommanders.add(commander);
    }

    @Override
    public void setNotifyCommand(MessageNotifyCommand messageNotifyCommand) {
        mNotifyCommand = messageNotifyCommand;
    }
}
