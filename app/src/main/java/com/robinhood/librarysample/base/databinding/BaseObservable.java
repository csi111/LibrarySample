package com.robinhood.librarysample.base.databinding;

import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import org.parceler.Parcel;
import org.parceler.Transient;

@Parcel
public class BaseObservable implements Observable {
    @Transient
    private PropertyChangeRegistry mCallbacks;

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback listener) {
        if (this.mCallbacks == null) {
            this.mCallbacks = new PropertyChangeRegistry();
        }

        this.mCallbacks.add(listener);
    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback listener) {
        if (this.mCallbacks != null) {
            this.mCallbacks.remove(listener);
        }
    }

    public synchronized void notifyChange() {
        if (this.mCallbacks != null) {
            this.mCallbacks.notifyCallbacks(this, 0, null);
        }
    }

    public void notifyPropertyChanged(int fieldId) {
        if (this.mCallbacks != null) {
            this.mCallbacks.notifyCallbacks(this, fieldId, null);
        }
    }
}
