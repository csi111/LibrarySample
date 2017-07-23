package com.robinhood.librarysample.ui.issues.viewmodel;

import com.robinhood.librarysample.base.command.MessageNotifyCommand;
import com.robinhood.librarysample.base.viewmodel.NotifyUpdateViewModelListener;
import com.robinhood.librarysample.data.issue.Issue;
import com.robinhood.librarysample.data.issue.Issues;
import com.robinhood.librarysample.data.issue.IssuesDataSource;
import com.robinhood.librarysample.data.issue.IssuesRepository;

import java.util.ArrayList;
import java.util.List;

public class IssueViewModelImpl implements IssueViewModel {

    private MessageNotifyCommand mMessageNotifyCommand;

    private NotifyUpdateViewModelListener notifyUpdateViewModelListener;


    public IssueViewModelImpl() {
    }

    @Override
    public void refreshIssues() {
        fetchIssues();
    }

    @Override
    public void fetchIssues() {
        IssuesRepository.getInstance().fetchIssues(new IssuesDataSource.LoadIssuesCallback() {
            @Override
            public void onIssuesLoaded(Issues issues) {
                List<IssueItemViewModel> itemVMList = new ArrayList<IssueItemViewModel>();
                for (Issue issue : issues.getModels()) {
                    itemVMList.add(new IssueItemViewModelImpl(issue));
                }
                if (notifyUpdateViewModelListener != null) {
                    notifyUpdateViewModelListener.onUpdatedViewModel(itemVMList);
                }
            }

            @Override
            public void onIssuesFailed(int code, String message) {
                if (mMessageNotifyCommand != null) {
                    mMessageNotifyCommand.execute(message);
                }
            }
        });

    }

    @Override
    public void setNotifyCommand(MessageNotifyCommand messageNotifyCommand) {
        mMessageNotifyCommand = messageNotifyCommand;
    }

    @Override
    public void setUpdateViewModelListener(NotifyUpdateViewModelListener listener) {
        notifyUpdateViewModelListener = listener;
    }
}
