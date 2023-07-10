package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequestV2;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequestV2;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo2;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo2;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import graphql.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Verify.verify;
import static graphql.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.doNothing;


public class MemberAdminServiceV2Test {
    @Mock
    private MemberRepositoryV2 memberRepository;

    @InjectMocks
    private MemberAdminServiceV2 memberAdminService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave_Success() {

        // create a new member request
        CreateMemberRequestV2 createMemberRequest;
        createMemberRequest = new CreateMemberRequestV2(
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true);

        MemberV2 savingMember = new MemberV2();
        savingMember.toMemberV2(createMemberRequest);
        //savingMember.setAuditData(new AuditData("test", LocalDateTime.now()));
        Mockito.when(memberRepository.save(savingMember)).thenReturn(savingMember);
        boolean result = memberAdminService.save(createMemberRequest);
        assertTrue(result);

    }
//    @Test
//    public void testUpdate_Success() {
//        //Member
//        //LocalDateTime now = LocalDateTime.now(); // current date and time
//
//        List<TypeValueInfo2> typeValues = new ArrayList<>();
//        List<FamilyInfo2> families = new ArrayList<>();
//        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
//        // create an existing member object
//        MemberV2 existingMember = new MemberV2(
//                "1",
//                "1234567890",
//                "John",
//                "Doe",
//                "johndoe@example.com",
//                "A101",
//                true,
//                true,
//                typeValues,
//                typeValues,
//                families
//                //auditData
//                );
//
//        // create an update member request object
//        UpdateMemberRequestV2 updateMemberRequest = new UpdateMemberRequestV2(
//                "1",
//                "johne@example.com",
//                "3AA",
//                true,
//                null,
//                null,
//                null
//                );
//
//        // mock the findById() method to return the existing member
//        Mockito.when(memberRepository.save(existingMember)).thenReturn(existingMember);
//        Mockito.when(memberRepository.findById("1")).thenReturn(Optional.of(existingMember));
//
//
//        // call the update() method and verify the result
//        boolean result = memberAdminService.update(updateMemberRequest);
//
//        assertTrue(result);
//        // verify that the updated member was saved to the reposi
//
//
//
//    }
    @Test
    public void testDelete_Success() {
        //Member
        //LocalDateTime now = LocalDateTime.now(); // current date and time
        CreateMemberRequest createMemberRequest;
        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 Member1 = new MemberV2(
                "1",
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true,
                true,
                typeValues,
                typeValues,
                families
                );

        doNothing().when(memberRepository).deleteById("1");

        // Call the delete method
        boolean result = memberAdminService.delete(String.valueOf(1));
        assertTrue(result);
    }

    @Test
    public void testInactive_Success(){
        //Member
        //LocalDateTime now = LocalDateTime.now(); // current date and time
        CreateMemberRequest createMemberRequest;
        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 activeMember = new MemberV2(
                "1",
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true,
                true,
                typeValues,
                typeValues,
                families
                );
        Mockito.when(memberRepository.findById("1")).thenReturn(Optional.of(activeMember));
        boolean result=memberAdminService.inactive("1");
        Assert.assertTrue(result);

    }


    }





