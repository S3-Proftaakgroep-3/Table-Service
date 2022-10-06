package com.mdma.tableservice.service;

import com.mdma.tableservice.model.Table;
import com.mdma.tableservice.repository.TableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TableService {

    private final TableRepository tableRepository;

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public Boolean checkIfTableExists(int tableNumber, String restaurantId) {
        return tableRepository.findTableBy(tableNumber, restaurantId).isPresent();
    }

    public Table getSpecificTable(int tableNumber, String restaurantId) {
        return tableRepository.findFirstBy(tableNumber, restaurantId);
    }

    public void deleteTableById(String id)
    {
        tableRepository.deleteById(id);
    }

    public Table postTable(Table table)
    {
        return tableRepository.save(table);
    }

    public Table updateTable(Table table)
    {
        return tableRepository.save(table);
    }



}
