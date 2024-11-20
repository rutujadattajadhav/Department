package com.rutuja.department.controller;

import com.rutuja.department.model.DepartmentModel;
import com.rutuja.department.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin
@RestController
public class DepartmentController {
    @Autowired
    private DepartMentService DepartMentService;

    @GetMapping("/{depatmentId}")
    public Mono<DepartmentModel> getDepartmentById(@PathVariable("depatmentId")  Integer depatId) throws Exception {
        return  DepartMentService.getDepartMentById(depatId);
    }

    @GetMapping("/getAllDepartment")
    public Flux<DepartmentModel> getAllDepartment() throws Exception {
        return DepartMentService.getAllDepartment();
    }

    @GetMapping("/getDepartsments")
    public Flux<DepartmentModel> getDepartments(@RequestBody List<Integer> departmentIds ) throws Exception {
        return DepartMentService.getDepartments(departmentIds);
    }
}
