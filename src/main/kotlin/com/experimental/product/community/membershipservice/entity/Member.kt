package com.experimental.product.community.membershipservice.entity

import com.experimental.product.community.membershipservice.client.*
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest
import com.experimental.product.community.membershipservice.client.response.MemberResponse
import com.experimental.product.community.membershipservice.util.ServiceUtil.dateFormatter
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("members")
data class Member(
    @Id
    val id: String? = null,
    @Field("contact_number")
    val contactNumber: String,
    @Field("first_name")
    val firstName: String,
    @Field("last_name")
    val lastName: String,
    @Field("email_address")
    val emailAddress: String,
    val unit: String,
    @Field("joining_date")
    val joiningDate: LocalDateTime = LocalDateTime.now(),
    val married: Boolean,
    val active: Boolean,
    @Field("payment_options")
    val paymentOptions: List<TypeValueInfo> = emptyList(),
    val preferences: List<TypeValueInfo> = emptyList(),
    val family: List<FamilyInfo> = emptyList(),
    @Field("audit_data")
    var auditData: AuditData? = null
) {
    companion object {
        fun toMember(
            createMemberRequest: CreateMemberRequest
        ): Member {
            return Member(
                contactNumber = createMemberRequest.contactNumber,
                firstName = createMemberRequest.firstName,
                lastName = createMemberRequest.lastName,
                emailAddress = createMemberRequest.emailAddress,
                unit = createMemberRequest.unit,
                married = createMemberRequest.married,
                active = true
            )
        }
    }

    fun updatePaymentOptions(
        paymentOptions: List<PaymentOption>
    ): Member {
        val typeValueInfoList = paymentOptions.map {
            TypeValueInfo(
                type = it.type.name,
                value = it.value
            )
        }.toMutableList()

        return this.copy(paymentOptions = typeValueInfoList)
    }

    fun updateFamily(
        family: List<FamilyDetail>
    ): Member {
        val familyInfoList = family.map {
            FamilyInfo(
                relationship = it.relationship.name,
                name = it.name
            )
        }.toMutableList()

        return this.copy(family = familyInfoList)
    }

    fun updatePreference(
        preferences: List<PreferenceDetail>
    ): Member {
        val preferenceList = preferences.map {
            TypeValueInfo(
                type = it.type.name,
                value = it.value
            )
        }.toMutableList()

        return this.copy(preferences = preferenceList)
    }

    fun toMemberResponse(): MemberResponse {
        return MemberResponse(
            memberId = id!!,
            firstName = firstName,
            lastName = lastName,
            contactNumber = contactNumber,
            emailAddress = emailAddress,
            unit = unit,
            married = married,
            active = active,
            joiningDate = joiningDate.format(dateFormatter()),
            paymentOptions = paymentOptions.map {
                PaymentOption(
                    type = PaymentType.valueOf(it.type),
                    value = it.value
                )
            }.toMutableList(),
            family = family.map {
                FamilyDetail(
                    relationship = FamilyRelationship.valueOf(it.relationship),
                    name = it.name
                )
            }.toMutableList(),
            preferences = preferences.map {
                PreferenceDetail(
                    type = PreferenceType.valueOf(it.type),
                    value = it.value
                )
            }.toMutableList()
        )
    }
}
