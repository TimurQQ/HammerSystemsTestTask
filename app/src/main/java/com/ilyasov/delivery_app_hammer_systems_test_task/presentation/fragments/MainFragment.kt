package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments

import com.ilyasov.delivery_app_hammer_systems_test_task.R
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments.base.BaseFragment
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.viewmodels.GetCocktailsViewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private val viewModel: GetCocktailsViewModel by lazy { createViewModel {} }
}