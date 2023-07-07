package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.ContactType;
import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequestV2;
import com.experimental.product.community.membershipservice.client.request.MemberAddToCommunityRequest;
import com.experimental.product.community.membershipservice.entity.CommunityV2;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.entity.auxilary.AuditData;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo;
import com.experimental.product.community.membershipservice.entity.auxilary.MemberDetails;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo;
import com.experimental.product.community.membershipservice.repository.CommunityRepositoryV2;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static graphql.Assert.assertFalse;

import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.*;


/*public class CommunityAdminServiceV2Test {

    @Mock
    private CommunityRepositoryV2 communityRepository;

    @Mock
    private MemberRepositoryV2 memberRepository;

    @InjectMocks
    private CommunityAdminServiceV2 communityAdminService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

   @Test
   public void testSave_Success()
   {
       // Create the contacts map
       Map<ContactType, String> contacts = new HashMap<>();
       contacts.put(ContactType.EMAIl, "example@example.com");
       contacts.put(ContactType.PHONE, "1234567890");

       // Create the emergency contacts list
       List<String> emergencyContacts = List.of("Emergency Contact 1", "Emergency Contact 2");

       // Create the object of CreateCommunityRequestV2
       CreateCommunityRequestV2 communityRequest = new CreateCommunityRequestV2(
               "Community Name",
               "Community Description",
               "Community Address",
               contacts,
               emergencyContacts,
               true, // isGated
               true, // hasPool
               true // hasGym
       );

       CommunityV2 communityEntity = new CommunityV2();

       when(communityRepository.save(org.mockito.ArgumentMatchers.any(CommunityV2.class))).thenReturn(communityEntity);

       boolean saved = communityAdminService.save(communityRequest);


       assertTrue(saved);

   }
    @Test
    void saveMemberID_ValidRequest_ReturnsTrue() {
        // Arrange
        String communityId ="64a52d720c235b3164b0364a";
        String memberId = "64730a28fe55c9114db23eb3";

        MemberAddToCommunityRequest request = new MemberAddToCommunityRequest(communityId,memberId);
        request.setCommunityId(communityId);
        request.setMemberId(memberId);

        CommunityV2 existingCommunity = new CommunityV2();
        existingCommunity.setId(communityId);
        existingCommunity.setListofMembers(new ArrayList<>());

        //Member
        LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        Member existingMember = new Member(
                "64730a28fe55c9114db23eb3",
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                now,
                true,
                true,
                typeValues,
                typeValues,
                families,
                auditData);


        when(communityRepository.findById(communityId)).thenReturn(Optional.of(existingCommunity));
        when(memberRepository.findById(memberId)).thenReturn(existingMember);

        // Act
        boolean result = communityAdminService.saveMemberID(request);

        // Assert
        assertTrue(result);
        assertEquals(1, existingCommunity.getListofMembers().size());

        MemberDetails savedMemberDetails = existingCommunity.getListofMembers().get(0);
        assertEquals("John", savedMemberDetails.getFirstName());
        assertEquals("Doe", savedMemberDetails.getLastName());
        assertEquals(memberId, savedMemberDetails.getMemberID());

        verify(communityRepository, times(1)).save(existingCommunity);
    }

    @Test
    void saveMemberID_CommunityNotFound_ReturnsFalse() {
        // Arrange
        String communityId ="64a52d720c235b3164b0364a";
        String memberId = "64730a28fe55c9114db23eb3";

        MemberAddToCommunityRequest request = new MemberAddToCommunityRequest(communityId,memberId);
        request.setCommunityId(communityId);
        request.setMemberId(memberId);

        when(communityRepository.findById(communityId)).thenReturn(Optional.empty());

        // Act
        boolean result = communityAdminService.saveMemberID(request);

        // Assert
        assertFalse(result);
        verify(communityRepository, never()).save(any());
    }

    @Test
    void saveMemberID_MemberNotFound_ReturnsFalse() {
        // Arrange
        String communityId ="64a52d720c235b3164b0364a";
        String memberId = "64730a28fe55c9114db23eb3";

        MemberAddToCommunityRequest request = new MemberAddToCommunityRequest(communityId,memberId);
        request.setCommunityId(communityId);
        request.setMemberId(memberId);

        CommunityV2 existingCommunity = new CommunityV2();
        existingCommunity.setId(communityId);
        existingCommunity.setListofMembers(new ArrayList<>());

        when(communityRepository.findById(communityId)).thenReturn(Optional.of(existingCommunity));
        when(memberRepository.findById(memberId)).thenReturn(null);

        // Act
        boolean result = communityAdminService.saveMemberID(request);

        // Assert
        assertFalse(result);
        verify(communityRepository, never()).save(any());
    }
    @Test
    void saveMemberID_ExceptionThrown_ReturnsFalse() {
        // Arrange
        String communityId ="64a52d720c235b3164b0364a";
        String memberId = "64730a28fe55c9114db23eb3";

        MemberAddToCommunityRequest request = new MemberAddToCommunityRequest(communityId,memberId);
        request.setCommunityId(communityId);
        request.setMemberId(memberId);

        when(communityRepository.findById(communityId)).thenThrow(new RuntimeException("Error saving member ID"));

        // Act
        boolean result = communityAdminService.saveMemberID(request);

        // Assert
        assertFalse(result);
        verify(communityRepository, never()).save(any());
    }

}*/


