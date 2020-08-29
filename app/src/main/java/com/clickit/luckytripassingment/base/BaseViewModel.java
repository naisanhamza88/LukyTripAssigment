package com.clickit.luckytripassingment.base;

import androidx.lifecycle.ViewModel;

import com.clickit.luckytripassingment.network.ApiAccount;
import com.clickit.luckytripassingment.network.component.DaggerViewModelInjector;
import com.clickit.luckytripassingment.network.component.ViewModelInjector;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class BaseViewModel  extends ViewModel {

    public ViewModelInjector injector = DaggerViewModelInjector.create();


    @Inject
    public  ApiAccount apiAccount;
    public Disposable subscription;

    public BaseViewModel() {
        inject();
    }



    void inject() {
        injector.inject(this);
    }
}
