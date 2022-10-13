package com.mdma.tableservice.controller;

import com.mdma.tableservice.service.TableService;
import com.mdma.tableservice.model.Table;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
@AllArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping("/all")
    public ResponseEntity<List<Table>> GetAllTables() {
        return tableService.GetAllTables();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRestaurant(@RequestBody Table table) {
        return tableService.postTable(table);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteTable(@RequestParam String id) {
        return tableService.deleteTableById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRestaurant(@RequestParam String id, @RequestBody Table table) {
        return tableService.updateTable(id, table);
    }

    @RequestMapping(path = "/tableNumber/{tableNumber}/restaurantId/{restaurantId}", method = RequestMethod.GET)
    public Table reserveTable(@PathVariable int tableNumber, @PathVariable String restaurantId) {
        Boolean tableExists = tableService.checkIfTableExists(tableNumber, restaurantId);

        Table table = new Table();

        if (!tableExists) {
            table.setRestaurantId(restaurantId);
            table.setTableNumber(tableNumber);
            tableService.postTable(table);
        }

        table = tableService.getSpecificTable(tableNumber, restaurantId);

        return table;
    }
}
