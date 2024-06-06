package com.ketki.worklyProject.directory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")   //since while jackson pkg serialisation, it consider any boolean value as false and wrong entry in db hence
    private boolean isActive;


// This below code, we have manually done, but using lombok dependency in pom.xml, if we use @Data, @Allargsconstructor, @noargsconstructor , this all below code, i.e constructors getters setters is automatically handled by lombok. it gives additional pieces of code


//    //Need constructor as well - autocreate using right click ->generate->constructor->select all
//    public EmployeeDTO(Long id, String name, LocalDate dateOfJoining, boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//
//    //---------------need getters and setters since fields are private,  autocreate using right click ->generate->getters and setters ->select all
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
}
