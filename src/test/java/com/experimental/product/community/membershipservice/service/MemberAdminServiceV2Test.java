package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.*;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.entity.auxilary.AuditData;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import com.experimental.product.community.membershipservice.sevice.MemberAdminServiceV2;
import graphql.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Verify.verify;
import static graphql.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

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
        CreateMemberRequest createMemberRequest;
        createMemberRequest = new CreateMemberRequest(
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true);

        Member savingMember = Member.Companion.toMember(createMemberRequest);
        savingMember.setAuditData(new AuditData("test", LocalDateTime.now()));
        Mockito.when(memberRepository.save(savingMember)).thenReturn(savingMember);
        boolean result = memberAdminService.save(createMemberRequest);
        assertTrue(result);

    }
    @Test
    public void testUpdate_Success() {
        //Member
        LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        Member existingMember = new Member(
                "1",
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

        // create an update member request object
        UpdateMemberRequest updateMemberRequest = new UpdateMemberRequest(
                "1",
                null,
                null,
                null,
                null,
                null,
                null
                );

        // mock the findById() method to return the existing member
        Mockito.when(memberRepository.findById("1")).thenReturn(existingMember);

        // call the update() method and verify the result
        boolean result = memberAdminService.update(updateMemberRequest);

        // assert that update() method returned true
        assertTrue(result);

        // verify that the updated member was saved to the repository
        Mockito.verify(memberRepository).save(existingMember);
    }
    @Test
    public void testDelete_Success() {
        //Member
        LocalDateTime now = LocalDateTime.now(); // current date and time
        CreateMemberRequest createMemberRequest;
        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        Member Member1 = new Member(
                "1",
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

        doNothing().when(memberRepository).deleteById(1);

        // Call the delete method
        boolean result = memberAdminService.delete(String.valueOf(1));
        assertTrue(result);
    }

    @Test
    public void testInactive_Success(){
        //Member
        LocalDateTime now = LocalDateTime.now(); // current date and time
        CreateMemberRequest createMemberRequest;
        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        Member activeMember = new Member(
                "1",
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
        Mockito.when(memberRepository.findById("1")).thenReturn(activeMember);
        boolean result=memberAdminService.inactive("1");
        Assert.assertTrue(result);

    }


    }





