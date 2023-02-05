package com.experimental.product.community.membershipservice.client.request

import com.experimental.product.community.membershipservice.client.ContactType
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
data class CreateCommunityRequest(
    var name: String?,
    var description: String?,
    var address: String?,
    var contacts: Map<ContactType, String>? = emptyMap(),
    var emergencyContacts: List<String>? = emptyList(),
    var isGated: Boolean? = false,
    var hasPool: Boolean? = false,
    var hasGym: Boolean? = false
)
