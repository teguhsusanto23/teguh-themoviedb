package com.teguh.movies.screen.splash

import android.os.Handler
import com.teguh.movies.R
import com.teguh.movies.base.BaseActivity
import com.teguh.movies.screen.dashboard.DashboardActivity

class SplashActivity : BaseActivity() {
    override fun getLayoutResource(): Int =
        R.layout.activity_splash

    override fun initComponent() {
        activityComponent.inject(this)
        Handler().postDelayed({
            startActivity(DashboardActivity.newInstance(this))
            finish()
        }, 2000)
    }

}