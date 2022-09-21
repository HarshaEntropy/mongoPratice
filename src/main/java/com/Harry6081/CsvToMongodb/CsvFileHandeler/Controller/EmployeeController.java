package com.Harry6081.CsvToMongodb.CsvFileHandeler.Controller;

import com.Harry6081.CsvToMongodb.CsvFileHandeler.Service.EmployeeService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("contacts")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Document> getAll(){
        return employeeService.getAll();
    }
    @GetMapping("/q={name}")
    public List<Document> getByFirstName(@PathVariable String name){
        return employeeService.getByString(name);
    }
}
