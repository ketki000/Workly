package com.ketki.worklyProject.directory.services;

import com.ketki.worklyProject.directory.dto.EmployeeDTO;
import com.ketki.worklyProject.directory.entities.EmployeeEntity;
import com.ketki.worklyProject.directory.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    //@Autowired - since not a DI but a CI
    final EmployeeRepository employeeRepository;  //DI object of employee repository in service

    final ModelMapper modelMapper; // CI since bean set in configuration app.config

    // Constructor Injection
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity =  employeeRepository.getById(id);
        //return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getDateOfJoining(),employeeEntity.isActive());
        //above return method not good, what if there are 40 fields
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
        //converted from dto to entity
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        //converted from entity to dto
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class); //prebuilt post method logic
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository
                .findAll() //gave list of employee entity
                .stream() //converted to stream of employee entity
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)) // all employee entities converted to dto using map method in a stream
                .collect(Collectors.toList()); // stream to list

    }

    public boolean deleteEmployeeById(Long id) {

        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return  false;
        employeeRepository.deleteById(id);
        return  true;
    }
}
