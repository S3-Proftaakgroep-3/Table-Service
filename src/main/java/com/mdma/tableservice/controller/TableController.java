package com.mdma.tableservice.controller;

import com.mdma.tableservice.service.TableService;
import com.mdma.tableservice.model.Table;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
@AllArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping("/all")
    public List<Table> getAllTables(){
        return tableService.getAllTables();
    }

    @PostMapping("/create")
    public Table createTable(@RequestBody Table table){
        return tableService.postTable(table);
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

    @DeleteMapping("/delete{id}")
    public void deleteTable(@PathVariable String id) {
        tableService.deleteTableById(id);
    }

    @PutMapping("/update/{id}")
    public Table updateTable(Table table)
    {
        return tableService.updateTable(table);
    }
}
