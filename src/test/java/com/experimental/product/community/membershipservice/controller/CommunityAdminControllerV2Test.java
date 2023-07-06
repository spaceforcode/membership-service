package com.experimental.product.community.membershipservice.controller;

import com.experimental.product.community.membershipservice.client.ContactType;
import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequestV2;
import com.experimental.product.community.membershipservice.client.request.DeleteMemberFromCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.MemberAddToCommunityRequest;
import com.experimental.product.community.membershipservice.service.CommunityAdminServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CommunityAdminControllerV2Test {

    @Mock
    private CommunityAdminServiceV2 communityAdminService;

    @InjectMocks
    private CommunityAdminControllerV2 communityAdminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCommunity_ValidRequest_ReturnsOkResponse() {
        // Create the contacts map
        Map<ContactType, String> contacts = new HashMap<>();
        contacts.put(ContactType.EMAIl, "example@example.com");
        contacts.put(ContactType.PHONE, "1234567890");

        // Create the emergency contacts list
        List<String> emergencyContacts = List.of("Emergency Contact 1", "Emergency Contact 2");

        // Create the object of CreateCommunityRequestV2
        CreateCommunityRequestV2 request = new CreateCommunityRequestV2(
                "Community Name",
                "Community Description",
                "Community Address",
                contacts,
                emergencyContacts,
                true, // isGated
                true, // hasPool
                true // hasGym
        );
        when(communityAdminService.save(request)).thenReturn(true);

        // Act
        ResponseEntity<String> response = communityAdminController.saveCommunity(request);

        // Assert
        assertEquals(ResponseEntity.ok("Community saved successfully."), response);
    }

    @Test
    void saveCommunity_InvalidRequest_ReturnsOkResponse() {
        // Arrange
        // Create the contacts map
        Map<ContactType, String> contacts = new HashMap<>();
        contacts.put(ContactType.EMAIl, "example@example.com");
        contacts.put(ContactType.PHONE, "1234567890");

        // Create the emergency contacts list
        List<String> emergencyContacts = List.of("Emergency Contact 1", "Emergency Contact 2");

        // Create the object of CreateCommunityRequestV2
        CreateCommunityRequestV2 request = new CreateCommunityRequestV2(
                "Community Name",
                "Community Description",
                "Community Address",
                contacts,
                emergencyContacts,
                true, // isGated
                true, // hasPool
                true // hasGym
        );

        when(communityAdminService.save(request)).thenReturn(false);

        // Act
        ResponseEntity<String> response = communityAdminController.saveCommunity(request);

        // Assert
        assertEquals(ResponseEntity.ok("Community not inserted"), response);
    }


    @Test
    void addMember_ValidRequest_ReturnsOkResponse() {
        // Arrange
        String communityId ="64a52d720c235b3164b0364a";
        String memberId = "64730a28fe55c9114db23eb3";
        MemberAddToCommunityRequest request = new MemberAddToCommunityRequest(communityId,memberId);
        // Set up the request with necessary data

        when(communityAdminService.saveMemberID(request)).thenReturn(true);

        // Act
        ResponseEntity<String> response = communityAdminController.addMember(request);

        // Assert
        assertEquals(ResponseEntity.ok("Member added to this community successfully."), response);
    }


    @Test
    void addMember_InvaildRequest_ReturnsOkResponse() {
        // Arrange
        String communityId ="64a52d720c235b3164b0364a";
        String memberId = "64730a28fe55c9114db23eb3";
        MemberAddToCommunityRequest request = new MemberAddToCommunityRequest(communityId,memberId);
        // Set up the request with necessary data

        when(communityAdminService.saveMemberID(request)).thenReturn(false);

        // Act
        ResponseEntity<String> response = communityAdminController.addMember(request);

        // Assert
        assertEquals(ResponseEntity.ok("Member not added"), response);
    }
    @Test
    void deleteMemberFromCommunity_ValidRequest_ReturnsOkResponse() {
        // Arrange
        DeleteMemberFromCommunityRequest request = new DeleteMemberFromCommunityRequest();
        // Set up the request with necessary data

        when(communityAdminService.deleteMemmber(request)).thenReturn(true);

        // Act
        ResponseEntity<String> response = communityAdminController.deleteMemberFromCommunity(request);

        // Assert
        assertEquals(ResponseEntity.ok("Member successfully removed from this community."), response);
    }

}
