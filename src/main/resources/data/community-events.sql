use communitydb

db.events.insertMany([
    {
        name: "Diwali",
        description: "Diwali desc",
        community_id:
        date: ISODate("2022-11-12"),
        venue: "Terrazzo Courtyard",
        venue_link: "<Map link>",
        budget: {
            "currency" : "USD",
            "value" : 3000
        },
        attendee_count: 150,
        primary_contact: "ayanit84@gmail.com",
        secondary_contact: "ayanit84-1@gmail.com",
        featured_photo_link: [
            <direct link to a picture>,
            <direct link to a picture>
        ],
        all_photo_link: "<link to drive or google photo>",
        external_link: "<link to any document having details of the event>",
        status: "Completed", // other status Planned, Cancelled,
        notes: "notes",
        audit_data: {
            created_by: "zyz",
            created_date: ISODate("2022-11-12T16:36:54.822Z"),
            updated_by: "pqr",
            updated_date: ISODate("2022-11-12T16:36:54.822Z")
        }
    }
])