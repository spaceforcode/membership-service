package com.experimental.product.community.membershipservice.controller;

import com.experimental.product.community.membershipservice.client.FamilyDetailV2;
import com.experimental.product.community.membershipservice.client.PaymentOptionV2;
import com.experimental.product.community.membershipservice.client.PreferenceDetailV2;
import com.experimental.product.community.membershipservice.client.response.MemberResponseV2;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo2;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo2;
import com.experimental.product.community.membershipservice.service.MemberSearchServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MemberSearchControllerV2Test {

    @Mock
    private MemberSearchServiceV2 memberSearchService;

    @InjectMocks
    private MemberSearchControllerV2 memberSearchController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        List<PaymentOptionV2> paymentOption = new ArrayList<>();
        List<FamilyDetailV2> families = new ArrayList<>();
        List<PreferenceDetailV2> preferenceDetail = new ArrayList<>();
        List<MemberResponseV2> members = Arrays.asList(
                new MemberResponseV2("1","9073199864","Anik","Roy","emp@gmail.com","A01",true,paymentOption,preferenceDetail,"a",families),
                new MemberResponseV2("2","9073199864","Jhon","Doe","emp@gmail.com","A02",true,paymentOption,preferenceDetail,"a",families)

                );
        when(memberSearchService.getAll()).thenReturn(members);

        // Act
        ResponseEntity<List<MemberResponseV2>> response = memberSearchController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(members, response.getBody());


    }

    @Test
    void testGetById() {
        // Arrange
        String memberId = "1";
        List<PaymentOptionV2> paymentOption = new ArrayList<>();
        List<FamilyDetailV2> families = new ArrayList<>();
        List<PreferenceDetailV2> preferenceDetail = new ArrayList<>();
        MemberResponseV2 member = new MemberResponseV2("1","9073199864","Anik","Roy","emp@gmail.com","A01",true,paymentOption,preferenceDetail,"a",families);
        when(memberSearchService.get(memberId)).thenReturn(member);

        // Act
        ResponseEntity<MemberResponseV2> response = memberSearchController.getById(memberId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(member, response.getBody());
        verify(memberSearchService, times(1)).get(memberId);
    }

    @Test
    void testGetByEmailAddress() {
        // Arrange
        String emailAddress = "john@example.com";
        List<PaymentOptionV2> paymentOption = new ArrayList<>();
        List<FamilyDetailV2> families = new ArrayList<>();
        List<PreferenceDetailV2> preferenceDetail = new ArrayList<>();
        MemberResponseV2 member = new MemberResponseV2("1","9073199864","Anik","Roy","emp@gmail.com","A01",true,paymentOption,preferenceDetail,"a",families);
        when(memberSearchService.getByEmailAddress(emailAddress)).thenReturn(member);

        // Act
        ResponseEntity<MemberResponseV2> response = memberSearchController.getByEmailAddress(emailAddress);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(member, response.getBody());
        verify(memberSearchService, times(1)).getByEmailAddress(emailAddress);
    }
}
