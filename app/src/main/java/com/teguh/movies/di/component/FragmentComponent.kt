package com.teguh.movies.di.component

import com.teguh.movies.di.module.FragmentModule
import com.teguh.movies.di.scope.PerFragment
import com.teguh.movies.screen.dashboard.ui.nowplaying.NowPlayingFragment
import com.teguh.movies.screen.dashboard.ui.popular.PopularFragment
import com.teguh.movies.screen.dashboard.ui.upcoming.UpComingFragment
import dagger.Component

@PerFragment
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(nowPlayingFragment: NowPlayingFragment)
    fun inject(upComingFragment: UpComingFragment)
    fun inject(popularFragment: PopularFragment)
}