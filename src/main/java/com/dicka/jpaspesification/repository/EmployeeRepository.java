package com.dicka.jpaspesification.repository;

import com.dicka.jpaspesification.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dickanirwansyah
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, 
           JpaSpecificationExecutor<Employee>{
    
}
