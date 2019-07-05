package com.stackroute.domain;

import com.stackroute.rabbitmq.model.CharityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "charityLogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logs {

    @Id
    private String id;

    private String date;

    private int rating;

    private CharityStatus charityStatus;

}
