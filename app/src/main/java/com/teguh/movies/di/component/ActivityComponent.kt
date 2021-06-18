package com.teguh.movies.di.component

import com.teguh.movies.di.module.ActivityModule
import com.teguh.movies.di.scope.PerActivity
import com.teguh.movies.screen.dashboard.DashboardActivity
import com.teguh.movies.screen.detail.DetailActivity
import com.teguh.movies.screen.splash.SplashActivity
import dagger.Component


@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(dashboardActivity: DashboardActivity)
    fun inject(detailActivity: DetailActivity)
}