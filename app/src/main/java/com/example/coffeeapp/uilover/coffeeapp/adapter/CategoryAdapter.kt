package com.example.coffeeapp.uilover.coffeeapp.adapter




import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ViewholderCategoryBinding
import com.example.coffeeapp.uilover.coffeeapp.domain.CategoryDomain


class CategoryAdapter(val items: MutableList<CategoryDomain>):
    RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    private  lateinit var context: Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    class Viewholder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.Viewholder {
        context = parent.context
        val binding= ViewholderCategoryBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return Viewholder(binding)
    }


    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val item = items[position]
        val currentPosition = position // Create a local copy

        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = currentPosition // Use the local copy
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            Handler(Looper.getMainLooper()).postDelayed({

            }, 500)

        }
        if (selectedPosition == position) {
            holder.binding.titleCat.setBackgroundColor(R.drawable.brown_full_corner)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.white))
        } else {
            holder.binding.titleCat.setBackgroundColor(R.drawable.cream_full_corner1)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.darkBrown))
        }
    }
    override fun getItemCount(): Int = items.size
}