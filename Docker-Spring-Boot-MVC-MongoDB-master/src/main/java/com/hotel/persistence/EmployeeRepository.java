package com.hotel.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotel.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
