package com.example.variationsapp.network

import com.squareup.moshi.Json

data class VariationsDetail(
    val variants: Variants
)

data class Variants(
   val variant_groups: List<VariantGroups>
)

data class VariantGroups(
   val group_id: String,
    val name: String,
    val variations: List<Variations>
)

data class Variations(
    val name: String,
     val price: Int,
    val default: Int,
    val id: Int,
    val inStock: Int
)