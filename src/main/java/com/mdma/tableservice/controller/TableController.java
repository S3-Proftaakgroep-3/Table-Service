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
    public Table reserveTable(@RequestBody Table table){
        return tableService.postTable(table);
    }

    @DeleteMapping("/delete{id}")
    public void deleteTable(@PathVariable String id) {
        tableService.deleteTablebyId(id);
    }
    @PutMapping("/update/{id}")
    public Table updateTable(Table table)
    {
        return tableService.updateTable(table);
    }
}
