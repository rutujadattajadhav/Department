package com.rutuja.department.controller;

import com.rutuja.department.model.DepartmentModel;
import com.rutuja.department.service.DepartMentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DepartmentControllerTest {
    @InjectMocks
    private DepartmentController departmentController;
    @Mock
    private DepartMentService DepartMentService;
     @Test
    public void getDepartmentById() throws Exception {
         DepartmentModel departmentModel=new DepartmentModel();
         departmentModel.setDepartmentId(1);
         departmentModel.setDepartName("IT");
         Mockito.when(DepartMentService.getDepartMentById(Mockito.anyInt())).thenReturn(departmentModel);
         DepartmentModel departmentModelResult =departmentController.getDepartmentById(1);
         Assert.assertEquals(departmentModel.toString(),departmentModelResult.toString());
     }

    @Test
    public void getAllDepartment() throws Exception {
        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setDepartmentId(1);
        departmentModel.setDepartName("IT");
        List<DepartmentModel> departmentModelList=new ArrayList<>();
        Mockito.when(DepartMentService.getAllDepartment()).thenReturn(departmentModelList);
        List<DepartmentModel> departmentModelResult =departmentController.getAllDepartment();
        Assert.assertEquals(departmentModelList.toString(),departmentModelResult.toString());
    }

    @Test
    public void getDepartments() throws Exception {
        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setDepartmentId(1);
        departmentModel.setDepartName("IT");
        List<DepartmentModel> departmentModelList=new ArrayList<>();
        departmentModelList.add(departmentModel);
        Mockito.when(DepartMentService.getDepartments(Mockito.anyList())).thenReturn(departmentModelList);
        List<Integer> integerList=new ArrayList<>();
        integerList.add(1);
        List<DepartmentModel> departmentModelResult =departmentController.getDepartments(integerList);
        Assert.assertEquals(departmentModelList.toString(),departmentModelResult.toString());
    }
}
