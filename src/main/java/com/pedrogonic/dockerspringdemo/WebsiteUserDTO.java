package com.pedrogonic.dockerspringdemo;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
public class WebsiteUserDTO {

    @Id
    private String id;

    private String name;
    private String email;
    private String nickname;

}
