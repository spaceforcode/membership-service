package com.experimental.product.community.membershipservice.client.response

import com.experimental.product.community.membershipservice.client.FamilyDetail
import com.experimental.product.community.membershipservice.client.PaymentOption
import com.experimental.product.community.membershipservice.client.PreferenceDetail
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
data class MemberResponse(
    @JsonProperty("member_id") val memberId: String,
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_name") val lastName: String,
    @JsonProperty("contact_number") val contactNumber: String,
    @JsonProperty("email_address") val emailAddress: String,
    @JsonProperty("unit") val unit: String,
    @JsonProperty("married") val married: Boolean,
    @JsonProperty("active") val active: Boolean,
    @JsonProperty("joining_date") val joiningDate: String,
    @JsonProperty("payment_options") val paymentOptions: List<PaymentOption>? = emptyList(),
    @JsonProperty("family") val family: List<FamilyDetail>? = emptyList(),
    @JsonProperty("preferences") val preferences: List<PreferenceDetail>? = emptyList()
)
