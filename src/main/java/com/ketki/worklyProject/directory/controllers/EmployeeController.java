package com.ketki.worklyProject.directory.controllers;
//Operations
// GET      /employees
// POST     /employees
// DELETE   /employees/{id}

import com.ketki.worklyProject.directory.dto.EmployeeDTO;
import com.ketki.worklyProject.directory.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@Controller
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    //Constructor Injection CI
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    private final EmployeeService employeeService; //Flow - Controllers use Service's CI & Services use Respository's CI



    @GetMapping(path = "/hello")
    public String getEmployees(){
        return "Hello World!";
    }

    //http://localhost:8080/employees?sortBy=age&limit=10
    @GetMapping
    public String getData(@PathParam("sortBy") String sortBy, @PathParam("limit") Integer limit){
        return "Hello " + sortBy + " "+limit;
    }

    //http://localhost:8080/employees/byId/39
    @GetMapping(path = "/byId/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long empId){
        return new EmployeeDTO(empId,"anuj",LocalDate.of(2024,2,2),true);
    }

    //By Service - this should be the flow - above apis just for testing

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long empId){
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }





}
