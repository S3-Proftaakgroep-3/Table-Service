package com.mdma.tableservice.service;

import com.mdma.tableservice.model.Table;
import com.mdma.tableservice.repository.TableRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TableService {

    public final TableRepository tableRepository;

    public ResponseEntity<List<Table>> GetAllTables() {
        return new ResponseEntity<List<Table>>(tableRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> postTable(Table Table) {
        if (tableRepository.save(Table) == Table)
            return new ResponseEntity<String>("Table has been saved", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Table hasn't been saved", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Boolean> deleteTableById(String id) {
        tableRepository.deleteById(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    public ResponseEntity<String> updateTable(String id, Table Table) {
        Table.setId(id);
        if (tableRepository.findById(id).isPresent()) {
            if (tableRepository.save(Table) == Table) {
                return new ResponseEntity<String>("Table has been updated", HttpStatus.OK);
            } else
                return new ResponseEntity<String>("Table failed to update", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<String>("Table hasn't been updated: Table not found", HttpStatus.BAD_REQUEST);
        }
    }

    public Boolean checkIfTableExists(int tableNumber, String restaurantId) {
        return tableRepository.findTableBy(tableNumber, restaurantId).isPresent();
    }

    public Table getSpecificTable(int tableNumber, String restaurantId) {
        return tableRepository.findFirstBy(tableNumber, restaurantId);
    }

}
