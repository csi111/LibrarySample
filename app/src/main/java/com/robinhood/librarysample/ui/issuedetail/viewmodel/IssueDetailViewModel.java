package com.robinhood.librarysample.ui.issuedetail.viewmodel;

import android.os.Parcelable;
import android.view.View;

import com.robinhood.librarysample.base.command.MessageNotifyCommand;
import com.robinhood.librarysample.base.databinding.BindableString;


public interface IssueDetailViewModel extends Parcelable {

    String getTitleText();

    String getContentsText();

    BindableString getCommentText();

    int getIssueNumber();

    void onClickSendComment(View view);

    void setCommander(CommentCommander commander);

    void setNotifyCommand(MessageNotifyCommand messageNotifyCommand);
}
