package com.experimental.product.community.membershipservice.client.request

import com.experimental.product.community.membershipservice.client.FamilyDetail
import com.experimental.product.community.membershipservice.client.PaymentOption
import com.experimental.product.community.membershipservice.client.PreferenceDetail
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
data class UpdateMemberRequest(
    var id: String,
    var emailAddress: String? = null,
    var unit: String?,
    var married: Boolean?,
    var paymentOptions: List<PaymentOption>?,
    var familyDetails: List<FamilyDetail>?,
    var preferenceDetails: List<PreferenceDetail>?
)
