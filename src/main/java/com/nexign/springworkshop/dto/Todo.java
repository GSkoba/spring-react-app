package com.nexign.springworkshop.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Todo {
    @Id
    private long id;
    private String title;
    private boolean status;
}
