package com.pedrogonic.dockerspringdemo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class WebsiteUser {

    @Id
    private ObjectId id;

    private String name;
    private String email;
    private String nickname;

}
