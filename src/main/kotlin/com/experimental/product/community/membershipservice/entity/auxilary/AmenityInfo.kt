package com.experimental.product.community.membershipservice.entity.auxilary

data class AmenityInfo(
    val name: String?,
    val description: String?,
    val featuredPhotos: List<String>? = emptyList()
)
