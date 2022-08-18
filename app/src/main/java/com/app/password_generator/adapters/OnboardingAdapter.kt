package com.app.password_generator.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.password_generator.databinding.LandingItemBinding
import com.app.password_generator.models.OnboardingModel
import com.bumptech.glide.Glide

class OnboardingAdapter(
    private val context: Context,
    private val items: ArrayList<OnboardingModel>
) : RecyclerView.Adapter<OnboardingAdapter.BannerImageHolder>() {
    class BannerImageHolder(val landingItemBinding: LandingItemBinding) :
        RecyclerView.ViewHolder(landingItemBinding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerImageHolder {

        return BannerImageHolder(
            LandingItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: BannerImageHolder,
        position: Int
    ) {
        Glide.with(context).load(items[position].photo)
            .into(holder.landingItemBinding.image)
        holder.landingItemBinding.desc.text = items[position].desc
        holder.landingItemBinding.title.text = items[position].title

    }

    override fun getItemCount(): Int {
        return items.size
    }
}