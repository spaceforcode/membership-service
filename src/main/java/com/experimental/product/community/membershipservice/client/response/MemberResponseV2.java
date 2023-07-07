package com.experimental.product.community.membershipservice.client.response;

import com.experimental.product.community.membershipservice.client.FamilyDetailV2;
import com.experimental.product.community.membershipservice.client.PaymentOptionV2;
import com.experimental.product.community.membershipservice.client.PreferenceDetailV2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class MemberResponseV2
{
    @JsonProperty("member_id")
    private String id;
    @JsonProperty("contact_number")
    private String contactNumber;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("married")
    private boolean married;
    @JsonProperty("payment_options")
    private List<PaymentOptionV2> paymentOptions;
    @JsonProperty("preferences")
    private List<PreferenceDetailV2> preferences;
    @JsonProperty("joining_date")
    private String joiningDate;

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<PreferenceDetailV2> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<PreferenceDetailV2> preferences) {
        this.preferences = preferences;
    }

    public List<FamilyDetailV2> getFamily() {
        return family;
    }

    public void setFamily(List<FamilyDetailV2> family) {
        this.family = family;
    }

    @JsonProperty("family")
    private List<FamilyDetailV2> family;

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }



    public List<PaymentOptionV2> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOptionV2> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
