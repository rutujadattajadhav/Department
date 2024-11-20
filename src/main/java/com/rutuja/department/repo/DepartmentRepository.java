package com.rutuja.department.repo;

import com.rutuja.department.model.DepartmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ReactiveCrudRepository<DepartmentModel,Integer> {
}
