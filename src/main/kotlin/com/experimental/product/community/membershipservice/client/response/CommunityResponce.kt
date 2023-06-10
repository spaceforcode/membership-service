package com.experimental.product.community.membershipservice.client.response

import com.experimental.product.community.membershipservice.entity.auxilary.AmenityInfo
import com.experimental.product.community.membershipservice.entity.auxilary.ContactInfo
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
data class CommunityResponse(
    @JsonProperty("community_id") val communityId: String,
    @JsonProperty("name") val name: String?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("address") val address: String?,
    @JsonProperty("contact_info") val contactInfo: ContactInfo? = null,
    @JsonProperty("amenities") val amenities: List<AmenityInfo>? = emptyList(),
    @JsonProperty("emergency_contacts") val emergencyContacts: List<String>? = emptyList(),
    @JsonProperty("gated") val isGated: Boolean? = false,
    @JsonProperty("has_pool") val hasPool: Boolean? = false,
    @JsonProperty("has_gym") val hasGym: Boolean? = false,
    @JsonProperty("active") val isActive: Boolean? = true
)
