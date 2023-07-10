package com.experimental.product.community.membershipservice.service;


import com.experimental.product.community.membershipservice.client.response.MemberResponseV2;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.entity.auxilary.AuditData;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo2;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo2;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static graphql.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberSearchServiceV2Test {

    @Mock
    private MemberRepositoryV2 memberRepository;

    @InjectMocks
    private MemberSearchServiceV2 memberSearchService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // given
        LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        MemberV2 member1 = new MemberV2("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", true, true, typeValues,typeValues, families);
        MemberV2 member2 = new MemberV2("2", "1267890", "Jhn", "Dos", "asssdoe@example.com", "A101", true, true, typeValues,typeValues, families);
        List<MemberV2> members = Arrays.asList(member1, member2);
        Mockito.when(memberRepository.findAll()).thenReturn(members);

        // when
        List<MemberResponseV2> memberResponses = memberSearchService.getAll();

        // then
        assertNotNull(memberResponses);
        assertEquals(2, memberResponses.size());
        assertEquals(member1.getId(), memberResponses.get(0).getId());
        assertEquals(member2.getId(), memberResponses.get(1).getId());
    }
    @Test
    void testGet() {
        // given
        LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        MemberV2 member = new MemberV2("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", true, true, typeValues,typeValues, families);

        Mockito.when(memberRepository.findById("1")).thenReturn(Optional.of(member));
        // when
        MemberResponseV2 memberResponse=memberSearchService.get("1");
        //then
        assertEquals(member.getId(), memberResponse.getId());

    }

    @Test
    void testGetByContactNumber() {
        // given
        LocalDateTime now = LocalDateTime.now(); // current date and time
        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        MemberV2 member = new MemberV2("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", true, true, typeValues,typeValues, families);
        Mockito.when(memberRepository.findOneByContactNumber("1234567890")).thenReturn(member);

        // when
        MemberResponseV2 memberResponse = memberSearchService.getByContactNumber("1234567890");

        // then
        assertNotNull(memberResponse);
        assertEquals(member.getId(), memberResponse.getId());
    }

    @Test
    void testGetByEmailAddress() {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        MemberV2 member = new MemberV2("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", true, true, typeValues,typeValues, families);
        Mockito.when(memberRepository.findOneByEmailAddress("johndoe@example.com")).thenReturn(member);

        // when
        MemberResponseV2 memberResponse = memberSearchService.getByEmailAddress("johndoe@example.com");

        // then
        assertNotNull(memberResponse);
        assertEquals(member.getId(), memberResponse.getId());
    }

}