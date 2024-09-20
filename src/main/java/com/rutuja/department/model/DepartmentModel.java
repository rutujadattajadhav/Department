package com.rutuja.department.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "department")
@Data
public class DepartmentModel {

    @Id
    @Column(name = "departmentId")
    private Integer departmentId;

    @Column(name = "departmentname")
    private String departName;

}
