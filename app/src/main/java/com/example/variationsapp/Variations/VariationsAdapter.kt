package com.example.variationsapp.Variations

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.variationsapp.databinding.VariationItemViewBinding
import com.example.variationsapp.network.VariantGroups


class VariationsAdapter(private var variatiansList: List<VariantGroups>) :
    RecyclerView.Adapter<VariationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            VariationItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return variatiansList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val variationContent = variatiansList[position]
        holder.binding.groupName.text = variationContent.name
        for (num in 0..2) {
            val radioButton: RadioButton? = holder.binding.radioGroup.getChildAt(num) as RadioButton
            radioButton?.text = variationContent.variations[num].name
            radioButton?.isEnabled = variationContent.variations[num].inStock != 0
            radioButton?.setOnClickListener {
                Toast.makeText(it.context, radioButton.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    class ViewHolder(var binding: VariationItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}
