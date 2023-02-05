use communitydb

db.members.createIndex( { "name": 1 }, { unique: true } )
db.members.insertOne([
    {
        name: "community name",
        description: "community desc",
        address: "community address',
        contact_info: {
            number: "(408) 645-4851",
            email: "community@example.com"
        }
        amenities: [
            {
                name: "amen 1",
                description: "desc",
                featured_photos: [
                    "link1",
                    "link2"
                ]
            },
            {
                name: "amen 2",
                description: "desc",
                featured_photos: [
                    "link1",
                    "link2"
                ]
            }
        ],
        emergency_contacts: [
            "contact 1",
            "contact 2"
        ],
        gated: true,
        has_pool: false,
        has_gym: true,
        active: true
    },
    {
        name: "community1 name",
        description: "community1 desc",
        address: "community1 address',
        contact_info: {
            number: "(408) 645-4851",
            email: "community1@example.com"
        }
        amenities: [
            {
                name: "amen 1",
                description: "desc",
                featured_photos: [
                    "link1",
                    "link2"
                ]
            },
            {
                name: "amen 2",
                description: "desc",
                featured_photos: [
                    "link1",
                    "link2"
                ]
            }
        ],
        emergency_contacts: [
            "contact 1",
            "contact 2"
        ],
        gated: true,
        has_pool: false,
        has_gym: true,
        active: true
    }
])