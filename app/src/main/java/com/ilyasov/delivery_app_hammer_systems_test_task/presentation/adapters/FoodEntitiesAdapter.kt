package com.ilyasov.delivery_app_hammer_systems_test_task.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilyasov.delivery_app_hammer_systems_test_task.R
import com.ilyasov.delivery_app_hammer_systems_test_task.domain.entity.CocktailEntity
import com.ilyasov.delivery_app_hammer_systems_test_task.util.loadFromUrl
import kotlinx.android.synthetic.main.item_food.view.*

class FoodEntitiesAdapter : RecyclerView.Adapter<FoodEntitiesAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var listOfItems: List<CocktailEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder(
        LayoutInflater.from(
            parent.context
        ).inflate(R.layout.item_food, parent, false)
    )

    override fun getItemCount() = listOfItems.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val cocktail = listOfItems[position]
        holder.itemView.apply {
            ivFoodImage.loadFromUrl(cocktail.imgURL)
            tvFoodName.text = cocktail.name
            tvDescription.text = cocktail.instruction
        }
    }
}