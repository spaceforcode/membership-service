use communitydb

db.members.insertMany([
    {
        contact_number: "4086454851",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "710",
        married: true,
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
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