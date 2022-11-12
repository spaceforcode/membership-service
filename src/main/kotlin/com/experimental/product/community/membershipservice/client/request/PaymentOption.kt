package com.experimental.product.community.membershipservice.client.request

data class PaymentOption(
    var type: PaymentType,
    var value: String
)
