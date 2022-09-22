package com.mdma.tableservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mdma/table")
@AllArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping()
    public List<Table> fetchAllTables(){
        return tableService.getAllTables();
    }

    @PostMapping("/reserve")
    public int ReserveTable(@RequestBody Table table){
        return tableService.reserveTable(table);
    }

    @PostMapping("/pay")
    public int PayTable(@RequestBody Table table){
        return tableService.payTable(table);
    }
}
