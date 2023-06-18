package com.experimental.product.community.membershipservice.client.request

import com.experimental.product.community.membershipservice.client.FamilyDetail
import com.experimental.product.community.membershipservice.client.PaymentOption
import com.experimental.product.community.membershipservice.client.PreferenceDetail
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
data class UpdateMemberRequest(
    @JsonProperty("member_id") var memberId: String,
    @JsonProperty("email_address") var emailAddress: String? = null,
    @JsonProperty("unit") var unit: String?,
    @JsonProperty("married") var married: Boolean?,
    @JsonProperty("payment_options") var paymentOptions: List<PaymentOption>?,
    @JsonProperty("family") var familyDetails: List<FamilyDetail>?,
    @JsonProperty("preferences") var preferenceDetails: List<PreferenceDetail>?
)
