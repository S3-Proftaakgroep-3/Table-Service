package com.mdma.tableservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TableService {

    private final TableRepository tableRepository;
    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public int reserveTable(Table table) {
        Table targetTable = tableRepository.findTableByTableNumber(table.getTableNumber());
        if (targetTable.getReservationTime() == null) {
            targetTable.setReservationTime(String.valueOf(System.currentTimeMillis()));
            tableRepository.save((targetTable));
            return 200;
        }
        else
            return 202;
    }

    public int payTable(Table table) {
        Table targetTable = tableRepository.findTableByTableNumber(table.getTableNumber());
        targetTable.setReservationTime(null);
        tableRepository.save(targetTable);
        return 200;
    }
}
