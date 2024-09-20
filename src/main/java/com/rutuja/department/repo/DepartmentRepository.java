package com.rutuja.department.repo;

import com.rutuja.department.model.DepartmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentModel,Integer> {
}
