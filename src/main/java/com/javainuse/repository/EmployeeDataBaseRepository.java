package com.javainuse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Employee;

@Repository
public interface EmployeeDataBaseRepository extends CrudRepository<Employee, Long> {

}