package com.rutuja.department.service;

import com.rutuja.department.model.DepartmentModel;
import com.rutuja.department.repo.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartMentService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DepartmentRepository departmentRepository;

    public Mono<DepartmentModel> getDepartMentById(Integer depatId) throws Exception {
        Mono<DepartmentModel> modelMono = departmentRepository.findById(depatId);
        return modelMono.switchIfEmpty(Mono.error(new Exception("Department not found")));

    }

    public Flux<DepartmentModel> getAllDepartment() {

        return departmentRepository.findAll()
                .switchIfEmpty(Mono.error(new Exception("not found")))
                .flatMap(departmeneModel -> Flux.just(departmeneModel))
                .onErrorResume(error -> {
                    log.error("Error during department retrieval: ", error);
                    return Flux.error(new RuntimeException("Unable to fetch department details"));
                });
    }

    public Flux<DepartmentModel> getDepartments(List<Integer> departmentIds) throws Exception {
        return Flux.fromIterable(departmentIds)
                .flatMap(stateId -> departmentRepository.findAllById(departmentIds))
                .switchIfEmpty(Flux.error(new Exception("department not found")))
                .onErrorResume(error -> {
                    log.error("Error during department retrieval: ", error);
                    return Flux.error(new RuntimeException("Unable to fetch department details"));
                });
    }
}