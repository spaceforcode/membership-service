package com.experimental.product.community.membershipservice.entity.auxilary

data class ContactInfo(
    var number: String? = null,
    var email: String? = null,
    var socialHandlers: Map<SocialType, String>? = emptyMap()
)
