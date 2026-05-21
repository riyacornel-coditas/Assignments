package com.project.second.controller;

import com.project.second.dtos.TableRequest;
import com.project.second.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @PostMapping("/add")
    public String addTables(@RequestBody TableRequest request)
    {
        return tableService.addTables(request);
    }

    @PostMapping("/approve/{table_id}")
    public String approveTable(@PathVariable Integer table_id)
    {
        return tableService.approveTable(table_id);
    }

    @PostMapping("/reject/{table_id}")
    public String rejectTable(@PathVariable Integer table_id)
    {
        return tableService.rejectTable(table_id);
    }
}
