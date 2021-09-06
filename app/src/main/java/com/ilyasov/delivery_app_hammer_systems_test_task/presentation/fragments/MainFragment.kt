package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilyasov.delivery_app_hammer_systems_test_task.R
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.adapters.FoodEntitiesAdapter
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments.base.BaseFragment
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.viewmodels.GetCocktailsViewModel
import com.ilyasov.delivery_app_hammer_systems_test_task.util.isVisible
import com.ilyasov.delivery_app_hammer_systems_test_task.util.showToast
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private val viewModel: GetCocktailsViewModel by lazy { createViewModel {} }
    private val foodEntitiesAdapter: FoodEntitiesAdapter by lazy { FoodEntitiesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserver()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCocktails()
    }

    private fun setupObserver() {
        viewModel.loadingMutableLiveData.observe(viewLifecycleOwner, { visibility ->
            progressBar.isVisible(visibility)
        })
        viewModel.errorStateLiveData.observe(viewLifecycleOwner) { error ->
            showToast("An error: $error")
        }
        viewModel.cocktailsListLiveData.observe(viewLifecycleOwner) { response ->
            foodEntitiesAdapter.listOfItems = response
            foodEntitiesAdapter.notifyDataSetChanged()
        }
    }

    private fun setupRecyclerView() {
        rvFoodEntities.apply {
            adapter = foodEntitiesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}