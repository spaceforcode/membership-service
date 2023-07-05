package com.experimental.product.community.membershipservice.client.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class CreateMemberRequestV2
{
    @JsonProperty("contact_number")
    public String contactNumber;
    @JsonProperty("first_name")
    public String firstname;
    @JsonProperty("last_name")
    public String lastname;
    @JsonProperty("email_address")
    public String emailAddress;

    public String unit;
    public Boolean married =true;
}
