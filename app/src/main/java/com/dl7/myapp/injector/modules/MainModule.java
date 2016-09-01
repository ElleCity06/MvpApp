package com.dl7.myapp.injector.modules;

import com.dl7.myapp.adapter.ViewPagerAdapter;
import com.dl7.myapp.injector.PerActivity;
import com.dl7.myapp.local.table.DaoSession;
import com.dl7.myapp.module.base.IBasePresenter;
import com.dl7.myapp.module.home.MainActivity;
import com.dl7.myapp.module.home.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/9/1.
 * 主页 Module
 */
@Module
public class MainModule {

    private final MainActivity mView;

    public MainModule(MainActivity view) {
        mView = view;
    }

    @PerActivity
    @Provides
    public IBasePresenter provideMainPresenter(DaoSession daoSession) {
        return new MainPresenter(mView, daoSession.getNewsTypeBeanDao());
    }

    @PerActivity
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getSupportFragmentManager());
    }
}
