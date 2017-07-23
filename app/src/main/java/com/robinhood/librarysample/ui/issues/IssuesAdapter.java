package com.robinhood.librarysample.ui.issues;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.robinhood.librarysample.R;
import com.robinhood.librarysample.databinding.LayoutIssueItemBinding;
import com.robinhood.librarysample.ui.issues.viewmodel.IssueItemViewModel;

import java.util.Collections;
import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class IssuesAdapter extends RecyclerView.Adapter<IssuesAdapter.IssuesViewHolder> {

    private List<IssueItemViewModel> mIssues;

    public IssuesAdapter() {
        setList(Collections.<IssueItemViewModel>emptyList());
    }

    @Override
    public IssuesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutIssueItemBinding issueItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_issue_item, parent, false);
        return new IssuesViewHolder(issueItemBinding);
    }

    @Override
    public void onBindViewHolder(IssuesViewHolder holder, final int position) {
        holder.bind(mIssues.get(position));
    }

    @Override
    public int getItemCount() {
        return mIssues.size();
    }

    private void setList(List<IssueItemViewModel> issues) {
        this.mIssues = checkNotNull(issues);
    }

    public void replaceData(List<IssueItemViewModel> issues) {
        setList(issues);
        notifyDataSetChanged();
    }


    static class IssuesViewHolder extends RecyclerView.ViewHolder {
        LayoutIssueItemBinding layoutIssueItemBinding;

        public IssuesViewHolder(LayoutIssueItemBinding layoutIssueItemBinding) {
            super(layoutIssueItemBinding.itemIssue);
            this.layoutIssueItemBinding = layoutIssueItemBinding;
        }

        void bind(IssueItemViewModel viewModel) {
            layoutIssueItemBinding.setItemViewModel(viewModel);
        }
    }
}
