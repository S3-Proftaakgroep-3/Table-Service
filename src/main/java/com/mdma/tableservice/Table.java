package com.mdma.tableservice;

import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Table {
    @Id
    private String id;

    private int tableNumber;
    private List<String> orders;
    private String reservationTime;

    public Table(int tableNumber, List<String> orders, String reservationTime) {
        this.tableNumber = tableNumber;
        this.orders = orders;
        this.reservationTime = reservationTime;
    }
}
