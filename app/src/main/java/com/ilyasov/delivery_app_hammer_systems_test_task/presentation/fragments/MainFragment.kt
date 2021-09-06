package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments

import android.os.Bundle
import android.view.View
import com.ilyasov.delivery_app_hammer_systems_test_task.R
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments.base.BaseFragment
import com.ilyasov.delivery_app_hammer_systems_test_task.util.setupWithNavController
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Main fragment -- container for bottom navigation
 */
class MainFragment : BaseFragment(R.layout.fragment_main) {

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.menu_nav_graph,
            R.navigation.profile_nav_graph,
            R.navigation.basket_nav_graph
        )

        // Setup the bottom navigation view with a list of navigation graphs
        bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.navHostFragmentForBottomNavigation,
            intent = requireActivity().intent
        )
    }
}