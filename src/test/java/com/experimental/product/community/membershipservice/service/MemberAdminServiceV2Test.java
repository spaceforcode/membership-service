package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.entity.auxilary.AuditData;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import com.experimental.product.community.membershipservice.sevice.MemberAdminServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static graphql.Assert.assertFalse;
import static graphql.Assert.assertTrue;
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



}
