package com.teguh.movies.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teguh.movies.di.component.DaggerFragmentComponent
import com.teguh.movies.di.component.FragmentComponent
import com.teguh.movies.di.module.FragmentModule
import org.greenrobot.eventbus.EventBus

abstract class BaseFragment : Fragment(), Base {

    protected lateinit var fragmentComponent: FragmentComponent
    private lateinit var baseActivity: Base
    private lateinit var fragmentHandler: Handler

    var layoutView: View? = null
    //viewLifecycleOwner null
    protected var flag = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return try {
            layoutView = inflater.inflate(getLayoutResource(), container, false)
            layoutView
        } catch (e: OutOfMemoryError) {
            e.printStackTrace()
            null
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        flag = true
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        initComponent()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity && context is BaseActivity) {
            baseActivity = context
            fragmentHandler = Handler((baseActivity as BaseActivity).mainLooper)
            fragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(context.getApplicationComponent())
                .fragmentModule(FragmentModule())
                .build()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        flag = false
    }

}