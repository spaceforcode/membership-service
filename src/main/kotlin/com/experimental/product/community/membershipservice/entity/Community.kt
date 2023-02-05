package com.experimental.product.community.membershipservice.entity

import com.experimental.product.community.membershipservice.client.ContactType
import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequest
import com.experimental.product.community.membershipservice.entity.auxilary.AmenityInfo
import com.experimental.product.community.membershipservice.entity.auxilary.ContactInfo
import com.experimental.product.community.membershipservice.entity.auxilary.SocialType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("community")
data class Community(
    @Id
    val id: String? = null,
    @Field("name")
    val name: String?,
    @Field("description")
    val description: String?,
    @Field("address")
    val address: String?,
    @Field("contact_info")
    val contactInfo: ContactInfo? = null,
    @Field("amenities")
    val amenities: List<AmenityInfo>? = emptyList(),
    @Field("emergency_contacts")
    val emergencyContacts: List<String>? = emptyList(),
    @Field("gated")
    val isGated: Boolean? = false,
    @Field("has_pool")
    val hasPool: Boolean? = false,
    @Field("has_gym")
    val hasGym: Boolean? = false,
    @Field("active")
    val isActive: Boolean? = true
) {
    companion object {
        fun toCommunity(
            createCommunityRequest: CreateCommunityRequest
        ): Community {
            val socialContacts = createCommunityRequest?.contacts?.filter {
                it.key != ContactType.PHONE || it.key != ContactType.EMAIl
            }?.map {
                Pair(SocialType.valueOf(it.key.name), it.value)
            }?.toMap()

            return Community(
                name = createCommunityRequest.name,
                description = createCommunityRequest.description,
                address = createCommunityRequest.address,
                contactInfo = ContactInfo(
                    number = createCommunityRequest.contacts?.get(ContactType.PHONE),
                    email = createCommunityRequest.contacts?.get(ContactType.EMAIl),
                    socialHandlers = socialContacts
                ),
                emergencyContacts = createCommunityRequest.emergencyContacts,
                isGated = createCommunityRequest.isGated,
                hasPool = createCommunityRequest.hasPool,
                hasGym = createCommunityRequest.hasGym
            )
        }
    }
}
