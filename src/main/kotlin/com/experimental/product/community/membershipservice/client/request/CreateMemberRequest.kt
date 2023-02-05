package com.experimental.product.community.membershipservice.client.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
data class CreateMemberRequest(
    var contactNumber: String,
    var firstName: String,
    var lastName: String,
    var emailAddress: String?,
    var unit: String?,
    var married: Boolean = true
)
