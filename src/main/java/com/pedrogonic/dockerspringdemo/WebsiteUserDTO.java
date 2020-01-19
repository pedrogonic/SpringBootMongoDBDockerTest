package com.pedrogonic.dockerspringdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebsiteUserDTO {

    @Id
    private String id;

    private String name;
    private String email;
    private String nickname;

}
