use communitydb

db.members.createIndex( { "contact_number": 1 }, { unique: true } )
db.members.insertMany([
    {
        contact_number: "4086454851",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "710",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454852",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454853",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454854",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454855",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454856",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454857",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454858",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454859",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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
    },
    {
        contact_number: "4086454850",
        first_name: "Ayan",
        last_name: "Chakraborty",
        email_address: "ayanit84@gmail.com",
        unit: "810",
        joining_date: ISODate("2021-03-21T06:00:00.171Z"),
        married: true,
        active: true,
        payment_options: [
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