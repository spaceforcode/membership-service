Membership-Service

# membership-service
Microservice based APIs to leverage different services towards community
# API Documentation
This README provides an overview and documentation for the Membership Service API. It describes the endpoints available, their functionalities, and how to use them.

## Table of Contents
    Endpoints

-  Member Search API
    - GET ALL MEMBER

    - GET MEMBER BY ID

    - GET EMAIL MEMBER BY ADDRESS
- Member Admin API
    - CREATE MEMBER

    - UPDATE MEMBER BY ID

    - DELETE MEMBER BY ID

    - INACTIVE MEMBER BY ID
- Usage
- Dependencies

# Endpoints
## Member Search API

### Get All Members
Retrieves a list of all members.

- URL:`/v2/members`
- Method: GET
- Response: List of member details

```
[
  {
    "member_id": "64730a28fe55c9114db23eb3",
    "contact_number": "9073299864",
    "first_name": "AyanUpdated",
    "last_name": "Roy",
    "email_address": "string@updae",
    "unit": "string",
    "married": false,
    "payment_options": [
      {
        "type": "Splitwise",
        "value": "string"
      }
    ],
    "preferences": [
      {
        "type": "Food",
        "value": "string"
      }
    ],
    "joining_date": "28-05-2023 13:30:40",
    "family": []
  },
  {
    "member_id": "647d7cfa085aca601b0f2b8b",
    "contact_number": "+91 91639 34721",
    "first_name": "KC",
    "last_name": "Chak",
    "email_address": "priyangmail",
    "unit": "AT",
    "married": false,
    "payment_options": [
      {
        "type": "Splitwise",
        "value": "string"
      }
    ],
    "preferences": [
      {
        "type": "Food",
        "value": "VAT dal"
      }
    ],
    "joining_date": "05-06-2023 11:43:14",
    "family": []
  }
]  
```

### Get Member by ID
Retrieves a specific member by their ID.

- URL:`/v2/members/{id}`
- Method: GET
- Parameter
    - `id`:Member ID
- Response:Details of the member with the specified ID

```
{
  "member_id": "64730a28fe55c9114db23eb3",
  "contact_number": "9073299864",
  "first_name": "AyanUpdated",
  "last_name": "Roy",
  "email_address": "string@updae",
  "unit": "string",
  "married": false,
  "payment_options": [
    {
      "type": "Splitwise",
      "value": "string"
    }
  ],
  "preferences": [
    {
      "type": "Food",
      "value": "string"
    }
  ],
  "joining_date": "28-05-2023 13:30:40",
  "family": []
}
```

### Get Member by Email Address
Retrieves a specific member by their email address.
- URL:`/v2/members/email/{emailAddress}`
- Method: GET
- Parameter
    - `emailAddress`:Member's email address
- Response:Details of the member with the specified email address

```
{
  "member_id": "6487700984f1f90a439c8560",
  "contact_number": "TEST Community ADD",
  "first_name": "TeST",
  "last_name": "Community",
  "email_address": "test@community@gmail.com",
  "unit": "Test Community",
  "married": false,
  "payment_options": [],
  "preferences": [],
  "joining_date": "13-06-2023 00:50:41",
  "family": []
}
```
## Member Admin API
### CREATE MEMBER
Create Member using memberRequest

- URL:`/v2/members`
- Method: POST
  -Request

  ```
  {
  "contact_number": "9073199864",
  "email_address": "01anikroy04@gmail.com",
  "first_name": "Anik",
  "last_name": "Roy",
  "married": true,
  "unit": "A01"
  }
  ```
- Response:
    - Success Response: **inserted.**
    - Failure Response: **Not inserted**

### ADD MEMBER TO COMMUNITY
Create Member using memberRequest

- URL:`/v2/members`
- Method: POST
- Request: updateMemberRequest

  ```
  {
  "email_address": "string",
  "family": [
    {
      "name": "string",
      "relationship": "Daughter"
    }
  ],
  "married": true,
  "member_id": "member_id"
  "payment_options": [
    {
      "type": "Gpay",
      "value": "string"
    }
  ],
  "preferences": [
    {
      "type": "Food",
      "value": "string"
    }
  ],
  "unit": "string"
  }

  ```
- Response:
    - Success Response: **updated**
    - Failure Response: **Not updated**

### DELETE MEMBER BY ID
Create Member using memberRequest

- URL:`/v2/members`
- Method: DELETE
- Parameter MEMBER ID
- Response:
    - Success Response: **deleted**
    - Failure Response: **Not deleted**

### DELETE MEMBER BY ID
Inactive member using MEMBER ID
- URL:`/v2/members`
- Method: DELETE
- Parameter MEMBER ID
- Response:
    - Success Response: **deleted**
    - Failure Response: **Not deleted**

### INACTIVE MEMBER BY ID
Inactive member using MEMBER ID
- URL:`/v2/members`
- Method: DELETE
- Parameter `id`:Member ID
- Response:
    - Success Response: **inactivated**
    - Failure Response: **Not inactivated**


### Dependencies
This API relies on the following dependencies:
- Spring Framework
