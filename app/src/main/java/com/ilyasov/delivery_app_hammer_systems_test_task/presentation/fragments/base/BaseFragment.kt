package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ilyasov.delivery_app_hammer_systems_test_task.App

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}