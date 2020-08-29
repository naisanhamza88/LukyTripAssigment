package com.clickit.luckytripassingment.network.component;

import com.clickit.luckytripassingment.base.BaseViewModel;
import com.clickit.luckytripassingment.network.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface ViewModelInjector {

//    void inject(LuckyAssApp app);


    void inject(BaseViewModel vm);
}
