package com.robinhood.librarysample.base.command;

import android.content.Context;

import com.robinhood.librarysample.base.util.ToastMaker;

public class ToastNotifyCommand implements MessageNotifyCommand {

    private Context context;

    public ToastNotifyCommand(Context context) {
        this.context = context;
    }

    @Override
    public void execute(String message) {
        //TODO Toasty or Alerter를 이용하여 메시지를 띄어보자
        ToastMaker.makeShortToast(context, message);
    }
}
