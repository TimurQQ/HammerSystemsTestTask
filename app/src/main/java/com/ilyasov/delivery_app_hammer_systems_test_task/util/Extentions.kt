package com.ilyasov.delivery_app_hammer_systems_test_task.util

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ilyasov.delivery_app_hammer_systems_test_task.R
import kotlinx.android.synthetic.main.item_food.view.*

fun View.isVisible(visibility: Boolean) =
    if (visibility) this.visibility = View.VISIBLE else this.visibility = View.GONE

fun ImageView.loadFromUrl(url: String?) {
    Glide.with(this)
        .load(url)
        .error(R.drawable.placeholder)
        .into(ivFoodImage)
}

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}