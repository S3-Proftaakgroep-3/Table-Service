package com.mdma.tableservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    @Id
    private String id;
    private String restaurantId;
    private int tableNumber;
    private List<String> orders;
    private String reservationTime;
}
