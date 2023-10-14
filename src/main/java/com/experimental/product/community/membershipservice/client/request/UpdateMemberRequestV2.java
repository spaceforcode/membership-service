package com.experimental.product.community.membershipservice.client.request;

import com.experimental.product.community.membershipservice.client.FamilyDetailV2;
import com.experimental.product.community.membershipservice.client.PaymentOptionV2;
import com.experimental.product.community.membershipservice.client.PreferenceDetailV2;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class UpdateMemberRequestV2
{
    @JsonProperty("member_id")
    private String memberId;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("unit")
    private String Unit ;
    @JsonProperty("married")
    private Boolean married;
    @JsonProperty("payment_options")
    private List<PaymentOptionV2> paymentOptions;
    @JsonProperty("family")
    private List<FamilyDetailV2> familyDetails;
    @JsonProperty("preferences")
    private List<PreferenceDetailV2> preferences;

    public List<PaymentOptionV2> getPaymentOptions() {
        return paymentOptions;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public void setPaymentOptions(List<PaymentOptionV2> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public List<FamilyDetailV2> getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(List<FamilyDetailV2> familyDetails) {
        this.familyDetails = familyDetails;
    }

    public List<PreferenceDetailV2> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<PreferenceDetailV2> preferences) {
        this.preferences = preferences;
    }

    public UpdateMemberRequestV2(String memberId, String emailAddress, String unit, Boolean married, List<PaymentOptionV2> paymentOptions, List<FamilyDetailV2> familyDetails, List<PreferenceDetailV2> preferences) {
        this.memberId = memberId;
        this.emailAddress = emailAddress;
        Unit = unit;
        this.married = married;
        this.paymentOptions = paymentOptions;
        this.familyDetails = familyDetails;
        this.preferences = preferences;
    }
    public UpdateMemberRequestV2()
    {

    }
}
