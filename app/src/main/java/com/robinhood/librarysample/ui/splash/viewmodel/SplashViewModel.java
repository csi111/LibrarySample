package com.robinhood.librarysample.ui.splash.viewmodel;

import android.view.View;

import com.robinhood.librarysample.base.databinding.BindableString;
import com.robinhood.librarysample.base.viewmodel.ViewModel;

public interface SplashViewModel extends ViewModel {

    BindableString getIdText();

    BindableString getRepositoryText();

    BindableString getAccessTokenText();

    void onClickEnterMainView(View view);
}
