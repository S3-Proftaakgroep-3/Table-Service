package com.mdma.tableservice.model;

import lombok.AllArgsConstructor;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Document
@AllArgsConstructor
public class Table {
    @Id
    private String id;

    private String restaurantId;
    private int tableNumber;
    private List<String> orders;
    private String reservationTime;
}
