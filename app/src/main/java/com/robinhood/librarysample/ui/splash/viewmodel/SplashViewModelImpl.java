package com.robinhood.librarysample.ui.splash.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import com.robinhood.api.github.model.GithubConfiguration;
import com.robinhood.librarysample.R;
import com.robinhood.librarysample.base.databinding.BindableString;
import com.robinhood.librarysample.base.util.GithubPreferenceKey;
import com.robinhood.librarysample.base.util.PreferenceKey;
import com.robinhood.librarysample.base.util.SharedPreferencesService;
import com.robinhood.librarysample.base.util.ToastMaker;
import com.robinhood.librarysample.ui.issues.IssuesActivity;

public class SplashViewModelImpl implements SplashViewModel {

    private SharedPreferencesService sharedPreferencesService;

    private Activity mActivity;

    private BindableString idText = new BindableString();
    private BindableString repoText = new BindableString();
    private BindableString accessTokenText = new BindableString();

    public SplashViewModelImpl(Activity activity) {
        this.mActivity = activity;
        initData();

    }

    private void initData() {
        sharedPreferencesService = SharedPreferencesService.getInstance();
        idText.set(sharedPreferencesService.getPrefStringData(GithubPreferenceKey.PREF_GITHUB_ID_KEY, mActivity.getResources().getString(R.string.default_github_id)));
        repoText.set(sharedPreferencesService.getPrefStringData(GithubPreferenceKey.PREF_GITHUB_REPOSITORY_KEY, mActivity.getResources().getString(R.string.default_github_repository)));
        accessTokenText.set(sharedPreferencesService.getPrefStringData(GithubPreferenceKey.PREF_GITHUB_ACCESS_TOKEN_KEY, mActivity.getResources().getString(R.string.github_personal_token)));
    }

    @Override
    public BindableString getIdText() {
        return idText;
    }

    @Override
    public BindableString getRepositoryText() {
        return repoText;
    }

    @Override
    public BindableString getAccessTokenText() {
        return accessTokenText;
    }

    @Override
    public void onClickEnterMainView(View view) {
        if (validateData()) {

            sharedPreferencesService.setPrefData(PreferenceKey.GITHUB_ID, idText.get());
            sharedPreferencesService.setPrefData(PreferenceKey.GITHUB_REPOSITORY, repoText.get());
            sharedPreferencesService.setPrefData(PreferenceKey.GITHUB_ACCESS_TOKEN, getAccessTokenText().get());

            //TODO Setting Github AccessToken
            GithubConfiguration.getInstance().setAccessToken("token " + getAccessTokenText().get());

            enterMainView();
        }
    }

    private boolean validateData() {
        if (idText.isEmpty()) {
            ToastMaker.makeShortToast(mActivity, R.string.alert_message_empty_id);
            return false;
        }

        if (repoText.isEmpty()) {
            ToastMaker.makeShortToast(mActivity, R.string.alert_message_empty_repository);
            return false;
        }

        if (accessTokenText.isEmpty()) {
            ToastMaker.makeShortToast(mActivity, R.string.alert_message_empty_accessToken);
            return false;
        }

        return true;
    }

    private void enterMainView() {
        if (mActivity != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (mActivity.isDestroyed()) {
                    return;
                }
            }

            mActivity.startActivity(new Intent(mActivity, IssuesActivity.class));
            mActivity.finish();
        }
    }

}
