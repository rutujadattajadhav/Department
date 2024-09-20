package com.rutuja.department.service;

import com.rutuja.department.model.DepartmentModel;
import com.rutuja.department.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartMentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentModel getDepartMentById(Integer depatId) throws Exception {
        if(departmentRepository.findById(depatId).isPresent()){
            return   departmentRepository.findById(depatId).get();
        }
        throw new Exception("Department not found");
    }

    public List<DepartmentModel> getAllDepartment() throws Exception {
        List<DepartmentModel> listOfDepartment=new ArrayList<>();
        Iterable<DepartmentModel> departments=departmentRepository.findAll();
        if(departments!=null){
            departments.forEach((deparment)->{
                listOfDepartment.add(deparment);
            });
            return listOfDepartment;
        }
        throw new Exception("department not found");
    }

    public List<DepartmentModel> getDepartments(List<Integer> departmentId) throws Exception {
        List<DepartmentModel> listOfmodel=new ArrayList<>();
        Iterable<DepartmentModel> departments=departmentRepository.findAllById(departmentId);
        if(departments!=null){
            departments.forEach((department)->{
                listOfmodel.add(department);
            });
            return listOfmodel;
        }
        throw new Exception("Departments not found");
    }
}
