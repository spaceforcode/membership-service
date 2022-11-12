package com.experimental.product.community.membershipservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
@EnableSwagger2
class MembershipServiceApplication

fun main(args: Array<String>) {
    runApplication<MembershipServiceApplication>(*args)
}


