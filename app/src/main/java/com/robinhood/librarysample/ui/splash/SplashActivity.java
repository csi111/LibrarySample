package com.robinhood.librarysample.ui.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;

import com.robinhood.librarysample.R;
import com.robinhood.librarysample.databinding.ActivitySplashBinding;
import com.robinhood.librarysample.ui.splash.viewmodel.SplashViewModel;
import com.robinhood.librarysample.ui.splash.viewmodel.SplashViewModelImpl;


public class SplashActivity extends AppCompatActivity {

    SplashViewModel splashViewModel;

    ActivitySplashBinding activitySplashBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        splashViewModel = new SplashViewModelImpl(this);
        activitySplashBinding.setSplashViewModel(splashViewModel);
        showAnimation();
    }


    private void showAnimation() {
        activitySplashBinding.titleTextView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(800).alpha(1.0f).setInterpolator(new AccelerateInterpolator()).start();
        activitySplashBinding.inputGithubIdLayout.animate().setDuration(1000).alpha(1.0f).setStartDelay(300).start();
        activitySplashBinding.inputGithubRepoLayout.animate().setDuration(1000).alpha(1.0f).setStartDelay(300).start();
        activitySplashBinding.inputGithubAccessTokenLayout.animate().setDuration(1000).alpha(1.0f).setStartDelay(300).start();
        activitySplashBinding.enterMainPageButton.animate().scaleY(1.0f).scaleX(1.0f).setDuration(1000).alpha(1.0f).start();

    }
}
