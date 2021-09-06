package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilyasov.delivery_app_hammer_systems_test_task.R
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.adapters.FoodEntitiesAdapter
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.fragments.base.BaseFragment
import com.ilyasov.delivery_app_hammer_systems_test_task.presentation.viewmodels.GetCocktailsViewModel
import com.ilyasov.delivery_app_hammer_systems_test_task.util.isVisible
import com.ilyasov.delivery_app_hammer_systems_test_task.util.showToast
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : BaseFragment(R.layout.fragment_menu) {
    private val viewModel: GetCocktailsViewModel by lazy { createViewModel {} }
    private val foodEntitiesAdapter: FoodEntitiesAdapter by lazy { FoodEntitiesAdapter() }
    private lateinit var lastView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserver()
        setupCategories()
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

    private fun setupCategories() {
        for (chr in ('a'..'z').minus('x').minus('u')) {
            val v = LayoutInflater.from(requireContext())
                .inflate(R.layout.item_top_category, null) as TextView
            val textView = v.findViewById<TextView>(R.id.tvCategory)
            textView.text = chr.toString()
            if (chr == 'a') {
                tintClicked(textView); lastView = v
            }
            textView.setOnClickListener { onClickCategory(it as TextView) }
            categoriesLayout.addView(v)
        }
    }

    private fun onClickCategory(view: TextView) {
        returnBack(lastView)
        tintClicked(view)
        lastView = view
        viewModel.getCocktails(view.text.toString())
    }

    private fun returnBack(textView: TextView) {
        textView.setTextColor(requireContext().getColor(R.color.gray_tint))
        textView.backgroundTintList =
            requireContext().resources.getColorStateList(R.color.white, requireContext().theme)
    }

    private fun tintClicked(textView: TextView) {
        textView.setTextColor(requireContext().getColor(R.color.colorClicked))
        textView.backgroundTintList =
            requireContext().resources.getColorStateList(
                R.color.backgroundClicked,
                requireContext().theme
            )
    }
}