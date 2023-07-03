package com.experimental.product.community.membershipservice.client.request;

import com.experimental.product.community.membershipservice.client.ContactType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCommunityRequestV2 {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("address")
    private String address;

    @JsonProperty("contacts")
    private Map<ContactType, String> contacts;

    @JsonProperty("emergencyContacts")
    private List<String> emergencyContacts;

    @JsonProperty("isGated")
    private Boolean isGated;

    @JsonProperty("hasPool")
    private Boolean hasPool;

    @JsonProperty("hasGym")
    private Boolean hasGym;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public List<String> getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(List<String> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public Boolean getGated() {
        return isGated;
    }

    public void setGated(Boolean gated) {
        isGated = gated;
    }

    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    public Boolean getHasGym() {
        return hasGym;
    }

    public void setHasGym(Boolean hasGym) {
        this.hasGym = hasGym;
    }

}
