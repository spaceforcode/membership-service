package com.experimental.product.community.membershipservice.util

import java.time.format.DateTimeFormatter

object ServiceUtil {
    @JvmStatic
    fun dateFormatter(): DateTimeFormatter {
        return DateTimeFormatter.ISO_DATE
    }
}