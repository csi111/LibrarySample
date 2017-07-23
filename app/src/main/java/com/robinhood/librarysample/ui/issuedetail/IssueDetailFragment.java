package com.robinhood.librarysample.ui.issuedetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robinhood.librarysample.R;
import com.robinhood.librarysample.base.command.ToastNotifyCommand;
import com.robinhood.librarysample.base.viewmodel.NotifyUpdateViewModelListener;
import com.robinhood.librarysample.databinding.FragmentIssueDetailBinding;
import com.robinhood.librarysample.ui.issuedetail.viewmodel.CommentCommander;
import com.robinhood.librarysample.ui.issuedetail.viewmodel.CommentItemViewModel;
import com.robinhood.librarysample.ui.issuedetail.viewmodel.CommentsViewModel;
import com.robinhood.librarysample.ui.issuedetail.viewmodel.CommentsViewModelImpl;
import com.robinhood.librarysample.ui.issuedetail.viewmodel.IssueDetailViewModel;

import java.util.List;

public class IssueDetailFragment extends Fragment {
    private CommentsAdapter mCommentsAdapter;

    private FragmentIssueDetailBinding fragmentIssueDetailBinding;

    private IssueDetailViewModel issueDetailViewModel;

    private CommentsViewModel commentsViewModel;

    public static IssueDetailFragment newInstance() {
        return new IssueDetailFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCommentsAdapter = new CommentsAdapter();
        issueDetailViewModel = getArguments().getParcelable(IssueDetailViewModel.class.getName());
        issueDetailViewModel.setNotifyCommand(new ToastNotifyCommand(getActivity()));
        initializeIssueViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentIssueDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_issue_detail, container, false);
        fragmentIssueDetailBinding.commentsRecyclerView.setLayoutManager(new CommentsRecyclerViewLayoutManager(getContext()));
        fragmentIssueDetailBinding.commentsRecyclerView.setAdapter(mCommentsAdapter);
        return fragmentIssueDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (issueDetailViewModel != null) {
            fragmentIssueDetailBinding.setIssueDetailViewModel(issueDetailViewModel);
            ((AppCompatActivity) getActivity()).setSupportActionBar(fragmentIssueDetailBinding.issueDetailToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initializeIssueViewModel() {
        if (issueDetailViewModel != null) {
            commentsViewModel = new CommentsViewModelImpl(issueDetailViewModel.getIssueNumber());
            commentsViewModel.setUpdateViewModelListener(new NotifyUpdateViewModelListener<List<CommentItemViewModel>>() {
                @Override
                public void onUpdatedViewModel(List<CommentItemViewModel> viewModel) {
                    mCommentsAdapter.replaceData(viewModel);
                }
            });
            issueDetailViewModel.setCommander((CommentCommander) commentsViewModel);
            commentsViewModel.fetchComments();
        }
    }
}
