package com.rutuja.department.service;

import com.rutuja.department.model.DepartmentModel;
import com.rutuja.department.repo.DepartmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DepartmentServiceTest {
    @InjectMocks
    private DepartMentService departMentService;

    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private Optional<DepartmentModel> optional;
    @Test
    public void getDepartmentByIdSuccess() throws Exception {
        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setDepartmentId(1);
        departmentModel.setDepartName("IT");
        Optional<DepartmentModel> departmentModel1=Optional.of(departmentModel);
        Mockito.when(departmentRepository.findById(1)).thenReturn(departmentModel1);
        Mockito.when(optional.get()).thenReturn(departmentModel);
        DepartmentModel departmentModelResult =departMentService.getDepartMentById(1) ;
        Assert.assertEquals(departmentModel.toString(),departmentModelResult.toString());
    }

    @Test(expected = Exception.class)
    public void getDepartmentByIdException() throws Exception {
        DepartmentModel departmentModelResult =departMentService.getDepartMentById(1) ;

    }

    @Test
    public void getAllDepartmentSuccess() throws Exception {
        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setDepartmentId(1);
        departmentModel.setDepartName("IT");
        List<DepartmentModel> departmentModelList=new ArrayList<>();
        departmentModelList.add(departmentModel);
        Mockito.when(departmentRepository.findAll()).thenReturn(departmentModelList);
        List<DepartmentModel> departmentModelResult =departMentService.getAllDepartment() ;
        Assert.assertEquals(departmentModelList.toString(),departmentModelResult.toString());
    }

    @Test(expected = Exception.class)
    public void getAllDepartmentExcaption() throws Exception {
        Mockito.when(departmentRepository.findAll()).thenReturn(null);
        List<DepartmentModel> departmentModelResult =departMentService.getAllDepartment() ;
    }

    @Test
    public void getdepartmentsSuccess() throws Exception {
        DepartmentModel departmentModel=new DepartmentModel();
        departmentModel.setDepartmentId(1);
        departmentModel.setDepartName("IT");
        List<DepartmentModel> departmentModelList=new ArrayList<>();
        departmentModelList.add(departmentModel);
        Mockito.when(departmentRepository.findAllById(Mockito.anyIterable())).thenReturn(departmentModelList);
        List<Integer> integerList=new ArrayList<>();
        integerList.add(1);
        List<DepartmentModel> departmentModels=departMentService.getDepartments(integerList);
        Assert.assertEquals(departmentModelList.toString(),departmentModels.toString());
    }

    @Test(expected = Exception.class)
    public void getDidtrictsException() throws Exception {
        Mockito.when(departmentRepository.findAllById(Mockito.anyIterable())).thenReturn(null);
        List<Integer> integerList=new ArrayList<>();
        integerList.add(1);
        List<DepartmentModel> departmentModels=departMentService.getDepartments(integerList);
    }
}


