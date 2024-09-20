package com.rutuja.department.controller;

import com.rutuja.department.model.DepartmentModel;
import com.rutuja.department.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartMentService DepartMentService;

    @GetMapping("/{depatmentId}")
    public DepartmentModel getDepartmentById(@PathVariable("depatmentId")  Integer depatId) throws Exception {
        return  DepartMentService.getDepartMentById(depatId);
    }

    @GetMapping("/getAllDepartment")
    public List<DepartmentModel> getAllDepartment() throws Exception {
        return DepartMentService.getAllDepartment();
    }

    @GetMapping("/getDepartsments")
    public List<DepartmentModel> getDepartments(@RequestBody List<Integer> departmentIds ) throws Exception {
        return DepartMentService.getDepartments(departmentIds);
    }
}
