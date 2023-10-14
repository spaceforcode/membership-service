package com.experimental.product.community.membershipservice.entity;

import com.experimental.product.community.membershipservice.client.*;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequestV2;
import com.experimental.product.community.membershipservice.client.response.MemberResponseV2;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo2;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo2;
import com.experimental.product.community.membershipservice.image.ImageProperties;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Document("members")
public class MemberV2
{
    @Id
    private String id;
    @Field("contact_number")
    private String contactNumber;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    @Field("email_address")
    private String emailAddress;
    @Field("unit")
    private String unit;
    private boolean married;
    private boolean active ;
    @Field("payment_options")
    private List<TypeValueInfo2> paymentOptions =new ArrayList<>();
    @Field("preferences")
    private List<TypeValueInfo2> preferences = new ArrayList<>();
    @Field("family_information")
    private List<FamilyInfo2> family=new ArrayList<>();
    @Field("joining_date")
    private LocalDateTime joiningDate = LocalDateTime.now();

    private List<ImageProperties> images =new ArrayList<>() ;



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public List<TypeValueInfo2> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<TypeValueInfo2> preferences) {
        this.preferences = preferences;
    }

    public List<FamilyInfo2> getFamily() {
        return family;
    }

    public void setFamily(List<FamilyInfo2> family) {
        this.family = family;
    }

    public MemberResponseV2 toMemberResponse()
    {
        //List<TypeValueInfo2> payment1 = new ArrayList<TypeValueInfo2>();
        List<PaymentOptionV2> payment = new ArrayList<PaymentOptionV2>();
        Iterator iterator= getPaymentOptions().iterator();

        while (iterator.hasNext())
        {
            TypeValueInfo2 type1 = (TypeValueInfo2) iterator.next();
            PaymentOptionV2 payment12=new PaymentOptionV2(PaymentType.valueOf(type1.type), type1.value);
            payment.add(payment12);
        }
        List<PreferenceDetailV2> preference = new ArrayList<PreferenceDetailV2>();
        Iterator iterator2= getPreferences().iterator();

        while (iterator2.hasNext())
        {
            TypeValueInfo2 type2 = (TypeValueInfo2) iterator2.next();
            PreferenceDetailV2 payment12=new PreferenceDetailV2(PreferenceType.valueOf(type2.type), type2.value);
            preference.add(payment12);
        }
        List<FamilyDetailV2>familyObj = new ArrayList<FamilyDetailV2>();
        Iterator iterator3= getFamily().iterator();

        while (iterator3.hasNext())
        {
            FamilyInfo2 type3 = (FamilyInfo2) iterator3.next();
            FamilyDetailV2 payment12=new FamilyDetailV2(FamilyRelationship.valueOf(type3.relationship), type3.name);
            familyObj.add(payment12);
        }



        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = joiningDate.format(format);



        MemberResponseV2 memberResponseObj= new MemberResponseV2();


        memberResponseObj.setId(this.id);
        memberResponseObj.setContactNumber(this.contactNumber);
        memberResponseObj.setFirstName(this.firstName);
        memberResponseObj.setLastName(this.lastName);
        memberResponseObj.setEmailAddress(this.emailAddress);
        memberResponseObj.setUnit(this.unit);


        memberResponseObj.setPaymentOptions(payment);
        memberResponseObj.setPreferences(preference);
        memberResponseObj.setFamily(familyObj);

        memberResponseObj.setJoiningDate(formatDateTime);
        return memberResponseObj;

    }
    public CreateMemberRequestV2 toMemberV2(CreateMemberRequestV2 createMemberRequestV2)
    {
       // CreateMemberRequestV2 createMemberRequestObj = new CreateMemberRequestV2();
        this.contactNumber= createMemberRequestV2.getContactNumber();
        this.firstName= createMemberRequestV2.getFirstname();
        this.lastName=createMemberRequestV2.getLastname();
        this.emailAddress=createMemberRequestV2.getEmailAddress();
        this.unit=createMemberRequestV2.getUnit();
        this.active=true;
        this.married=createMemberRequestV2.getMarried();

        return createMemberRequestV2;
    }
    public MemberV2()
    {

    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public List<TypeValueInfo2> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<TypeValueInfo2> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public MemberV2(String id, String contactNumber, String firstName, String lastName, String emailAddress, String unit, boolean active, boolean married, List<TypeValueInfo2> paymentOptions,List<TypeValueInfo2> preferences,List<FamilyInfo2> family)
    {
        this.id=id;
        this.contactNumber=contactNumber;
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailAddress=emailAddress;
        this.unit=unit;
        this.active=true;
        this.married=married;

        this.paymentOptions=paymentOptions;
        this.preferences=preferences;
        this.family=family;

    }

    public List<ImageProperties> getImages() {
        return images;
    }

    public void setImages(List<ImageProperties> images) {
        this.images = images;
    }
    public void addImage (ImageProperties image)
    {
        images.add(image);
    }

}
