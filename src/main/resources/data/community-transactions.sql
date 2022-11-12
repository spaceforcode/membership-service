use communitydb

db.members.insertMany([
    {
        contact_number: "4086454851",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "710",
        married: true,
        active: true,
        paymentOptions: [
            {
                type: "Zelle",
                value: "4086454851"
            },
            {
                type: "Splitwise",
                value: "ayanit84@gmail.com"
            }
        ],
        preferences: [
            {
                type: "Sports",
                value: "Cricket"
            },
            {
                type: "Sports",
                value: "Volley"
            },
            {
                type: "Food",
                value: "Veg"
            }
        ],
        family: [
            {
                relationship: "Spouse",
                name: "Esa"
            },
            {
                relationship: "Son",
                name: "Aahan"
            }
        ]
    }
])