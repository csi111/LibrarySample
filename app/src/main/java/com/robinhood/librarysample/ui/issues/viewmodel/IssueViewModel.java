package com.robinhood.librarysample.ui.issues.viewmodel;

import com.robinhood.librarysample.base.command.MessageNotifyCommand;
import com.robinhood.librarysample.base.viewmodel.NotifyUpdateViewModelListener;


public interface IssueViewModel {
    void refreshIssues();

    void fetchIssues();

    void setNotifyCommand(MessageNotifyCommand messageNotifyCommand);

    void setUpdateViewModelListener(NotifyUpdateViewModelListener listener);
}
