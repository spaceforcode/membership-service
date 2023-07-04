package com.experimental.product.community.membershipservice.entity;

import com.experimental.product.community.membershipservice.client.ContactType;
import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequestV2;
import com.experimental.product.community.membershipservice.entity.auxilary.AmenityInfo;
import com.experimental.product.community.membershipservice.entity.auxilary.ContactInfo;
import com.experimental.product.community.membershipservice.entity.auxilary.MemberDetails;
import com.experimental.product.community.membershipservice.entity.auxilary.SocialType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Document("communities")
public class CommunityV2{
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("address")
    private String address;

    @Field("contact_info")
    private ContactInfo contactInfo;

    @Field("amenities")
    private List<AmenityInfo> amenities;

    @Field("emergency_contacts")
    private List<String> emergencyContacts;

    @Field("gated")
    private Boolean isGated;

    @Field("has_pool")
    private Boolean hasPool;

    @Field("has_gym")
    private Boolean hasGym;

    @Field("active")
    private Boolean isActive;

    @Field("ListofMembers")
    private List<MemberDetails> ListofMembers;

    public List<MemberDetails> getListofMembers() {
        return ListofMembers;
    }

    public void setListofMembers(List<MemberDetails> listofMembers) {
        ListofMembers = listofMembers;
    }

    public CommunityV2() {
    }

    public CommunityV2(String id, String name, String description, String address, ContactInfo contactInfo, List<AmenityInfo> amenities, List<String> emergencyContacts, Boolean isGated, Boolean hasPool, Boolean hasGym, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.contactInfo = contactInfo;
        this.amenities = amenities;
        this.emergencyContacts = emergencyContacts;
        this.isGated = isGated;
        this.hasPool = hasPool;
        this.hasGym = hasGym;
        this.isActive = isActive;
    }
    public static CommunityV2 copy(
            String id,
            String name,
            String description,
            String address,
            ContactInfo contactInfo,
            List<AmenityInfo> amenities,
            List<String> emergencyContacts,
            Boolean isGated,
            Boolean hasPool,
            Boolean hasGym,
            Boolean isActive,
            List<MemberDetails> listOfMembers
    ) {
        CommunityV2 communityCopy = new CommunityV2();
        communityCopy.setId(id);
        communityCopy.setName(name);
        communityCopy.setDescription(description);
        communityCopy.setAddress(address);
        communityCopy.setContactInfo(contactInfo);
        communityCopy.setAmenities(amenities);
        communityCopy.setEmergencyContacts(emergencyContacts);
        communityCopy.setGated(isGated);
        communityCopy.setHasPool(hasPool);
        communityCopy.setHasGym(hasGym);
        communityCopy.setActive(isActive);
        communityCopy.setListofMembers(listOfMembers);

        return communityCopy;
    }


    public static CommunityV2 toCommunity(CreateCommunityRequestV2 createCommunityRequest) {
        Map<ContactType, String> contacts = createCommunityRequest.getContacts();
        Map<SocialType, String> socialContacts = new HashMap<>();

        if (contacts != null) {
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                if (entry.getKey() != ContactType.PHONE && entry.getKey() != ContactType.EMAIl) {
                    socialContacts.put(SocialType.valueOf(entry.getKey().name()), entry.getValue());
                }
            }
        }

        return new CommunityV2(
                null,
                createCommunityRequest.getName(),
                createCommunityRequest.getDescription(),
                createCommunityRequest.getAddress(),
                new ContactInfo(contacts != null ? contacts.get(ContactType.PHONE) : null,
                        contacts != null ? contacts.get(ContactType.EMAIl) : null,
                        socialContacts),
                new ArrayList<>(),
                createCommunityRequest.getEmergencyContacts(),
                createCommunityRequest.getGated() != null && createCommunityRequest.getGated(),
                createCommunityRequest.getHasPool() != null && createCommunityRequest.getHasPool(),
                createCommunityRequest.getHasGym() != null && createCommunityRequest.getHasGym(),
                true
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<AmenityInfo> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityInfo> amenities) {
        this.amenities = amenities;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

