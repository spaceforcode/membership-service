package com.experimental.product.community.membershipservice.controller;

import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequestV2;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequestV2;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.entity.auxilary.*;
import com.experimental.product.community.membershipservice.service.MemberAdminServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MemberAdminControllerV2Test {
    @Mock
    private MemberAdminServiceV2 memberAdminService;

    @InjectMocks
    private MemberAdminControllerV2 memberAdminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void join_ValidRequest_ReturnsOkResponse() {

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
        when(memberAdminService.save(createMemberRequest)).thenReturn(true);

        // Act
        ResponseEntity<String> response = memberAdminController.join(createMemberRequest);

        // Assert
        assertEquals(ResponseEntity.ok("inserted"), response);
    }
    @Test
    void join_InvalidRequest_ReturnsOkResponse() {
        CreateMemberRequestV2 createMemberRequest;
        createMemberRequest = new CreateMemberRequestV2(
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true);

        when(memberAdminService.save(createMemberRequest)).thenReturn(false);

        // Act
        ResponseEntity<String> response = memberAdminController.join(createMemberRequest);

        // Assert
        assertEquals(ResponseEntity.ok("not inserted"), response);
    }
    @Test
    void update_ValidRequest_ReturnsOkResponse() {
     //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
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

        // create an update member request object
        UpdateMemberRequestV2 updateMemberRequest = new UpdateMemberRequestV2(
                "1",
                "johndoe@example.com",
                "A101",
                true,
                null,
                null,
                null
        );
        when(memberAdminService.update(updateMemberRequest)).thenReturn(true);

        // Act
        ResponseEntity<String> response = memberAdminController.update(updateMemberRequest);

        // Assert
        assertEquals(ResponseEntity.ok("updated"), response);
    }
    @Test
    void update_InvalidRequest_ReturnsOkResponse() {
        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
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
        // create an update member request object
        UpdateMemberRequestV2 updateMemberRequest = new UpdateMemberRequestV2(
                "1",
                "johndoe@example.com",
                "A101",
                true,
                null,
                null,
                null
        );

        when(memberAdminService.update(updateMemberRequest)).thenReturn(false);

        // Act
        ResponseEntity<String> response = memberAdminController.update(updateMemberRequest);

        // Assert
        assertEquals(ResponseEntity.ok("not updated"), response);
    }

    @Test
    void unsubscribe_ValidId_ReturnsOkResponse() {
        // Arrange
        String memberId = "64730a28fe55c9114db23eb3";
        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
                "64730a28fe55c9114db23eb3",
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

        when(memberAdminService.delete(memberId)).thenReturn(true);

        // Act
        ResponseEntity<String> response = memberAdminController.unsubscribe(memberId);

        // Assert
        assertEquals(ResponseEntity.ok("deleted"), response);
    }

    @Test
    void unsubscribe_InvalidId_ReturnsOkResponse() {
        // Arrange
        String memberId = "64730a28fe55c9114db23eb3";

        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
                "64730a28fe55c9114db23eb3",
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

        when(memberAdminService.delete(memberId)).thenReturn(false);

        // Act
        ResponseEntity<String> response = memberAdminController.unsubscribe(memberId);

        // Assert
        assertEquals(ResponseEntity.ok("not deleted"), response);
    }


    @Test
    void inactive_ValidId_ReturnsOkResponse() {
        // Arrange
        String memberId = "64730a28fe55c9114db23eb3";
        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
                "64730a28fe55c9114db23eb3",
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

        when(memberAdminService.inactive(memberId)).thenReturn(true);

        // Act
        ResponseEntity<String> response = memberAdminController.inactive(memberId);

        // Assert
        assertEquals(ResponseEntity.ok("inactivated"), response);
    }
    @Test
    void inactive_InvalidId_ReturnsOkResponse() {
        // Arrange
        String memberId = "64730a28fe55c9114db23eb3";
        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
                "64730a28fe55c9114db23eb3",
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

        when(memberAdminService.inactive(memberId)).thenReturn(false);

        // Act
        ResponseEntity<String> response = memberAdminController.inactive(memberId);

        // Assert
        assertEquals(ResponseEntity.ok("not inactivated"), response);
    }

    @Test
    void active_ValidId_ReturnsOkResponse() {
        // Arrange
        String memberId = "64730a28fe55c9114db23eb3";
        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
                "64730a28fe55c9114db23eb3",
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true,
                false,
                typeValues,
                typeValues,
                families
                );

        when(memberAdminService.active(memberId)).thenReturn(true);

        // Act
        ResponseEntity<String> response = memberAdminController.active(memberId);

        // Assert
        assertEquals(ResponseEntity.ok("activated"), response);
    }

    @Test
    void active_InValidId_ReturnsOkResponse() {
        // Arrange
        String memberId = "64730a28fe55c9114db23eb3";
        //LocalDateTime now = LocalDateTime.now(); // current date and time

        List<TypeValueInfo2> typeValues = new ArrayList<>();
        List<FamilyInfo2> families = new ArrayList<>();
        //AuditData auditData = new AuditData("admin", now, "admin", now, "admin2", now);
        // create an existing member object
        MemberV2 existingMember = new MemberV2(
                "64730a28fe55c9114db23eb3",
                "1234567890",
                "John",
                "Doe",
                "johndoe@example.com",
                "A101",
                true,
                false,
                typeValues,
                typeValues,
                families
        );
        when(memberAdminService.active(memberId)).thenReturn(false);

        // Act
        ResponseEntity<String> response = memberAdminController.active(memberId);

        // Assert
        assertEquals(ResponseEntity.ok("not activated"), response);
    }
}
