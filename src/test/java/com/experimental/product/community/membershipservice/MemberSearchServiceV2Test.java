package com.experimental.product.community.membershipservice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.experimental.product.community.membershipservice.entity.auxilary.AuditData;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo;
import com.experimental.product.community.membershipservice.service.MemberSearchServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.experimental.product.community.membershipservice.client.response.MemberResponse;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;

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

        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        Member member1 = new Member("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", now, true, true, typeValues, typeValues, families, auditData);
        Member member2 = new Member("2", "1234567802", "anik", "roy", "anikoe@example.com", "A102", now, true, true, typeValues, typeValues, families, auditData);
        List<Member> members = Arrays.asList(member1, member2);
        Mockito.when(memberRepository.findAll()).thenReturn(members);

        // when
        List<MemberResponse> memberResponses = memberSearchService.getAll();

        // then
        assertNotNull(memberResponses);
        assertEquals(2, memberResponses.size());
        assertEquals(member1.getId(), memberResponses.get(0).getMemberId());
        assertEquals(member2.getId(), memberResponses.get(1).getMemberId());
    }
    @Test
    void testGet() {
        // given
        LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        Member member = new Member("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", now, true, true, typeValues, typeValues, families, auditData);
        Mockito.when(memberRepository.findById("1")).thenReturn(member);
        // when
        MemberResponse memberResponse=memberSearchService.get("1");
        //then
        assertEquals(member.getId(), memberResponse.getMemberId());

    }

    @Test
    void testGetByContactNumber() {
        // given
        LocalDateTime now = LocalDateTime.now(); // current date and time
        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        Member member = new Member("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", now, true, true, typeValues, typeValues, families, auditData);
        Mockito.when(memberRepository.findOneByContactNumber("1234567890")).thenReturn(member);

        // when
        MemberResponse memberResponse = memberSearchService.getByContactNumber("1234567890");

        // then
        assertNotNull(memberResponse);
        assertEquals(member.getId(), memberResponse.getMemberId());
    }

    @Test
    void testGetByEmailAddress() {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        List<TypeValueInfo> typeValues = new ArrayList<>();
        List<FamilyInfo> families = new ArrayList<>();
        AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        Member member = new Member("1", "1234567890", "John", "Doe", "johndoe@example.com", "A101", now, true, true, typeValues, typeValues, families, auditData);
        Mockito.when(memberRepository.findOneByEmailAddress("johndoe@example.com")).thenReturn(member);

        // when
        MemberResponse memberResponse = memberSearchService.getByEmailAddress("johndoe@example.com");

        // then
        assertNotNull(memberResponse);
        assertEquals(member.getId(), memberResponse.getMemberId());
    }

}