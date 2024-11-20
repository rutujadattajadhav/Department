package com.rutuja.department.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "department")
@Data
public class DepartmentModel {

    @Id
    @Column(value = "departmentId")
    private Integer departmentId;

    @Column(value = "departmentname")
    private String departName;

}
