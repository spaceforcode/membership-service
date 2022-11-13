package com.experimental.product.community.membershipservice.entity

import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

open class AuditData(
    @Field("created_by")
    var createdBy: String? = null,
    @Field("created_date")
    var createdDate: LocalDateTime? = null,
    @Field("updated_by")
    var updatedBy: String? = null,
    @Field("updated_date")
    var updatedDate: LocalDateTime? = null,
    @Field("inactivated_by")
    var inactivatedBy: String? = null,
    @Field("inactivated_date")
    var inactivatedDate: LocalDateTime? = null
)
