
package com.dicka.jpaspesification.service;


import com.dicka.jpaspesification.base.BaseService;
import com.dicka.jpaspesification.entity.Employee;
import com.dicka.jpaspesification.model.request.shared.SpesificationRequest;
import com.dicka.jpaspesification.model.response.shared.PageResponse;
import com.dicka.jpaspesification.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author dickanirwansyah
 */

@Slf4j
@Service
public class EmployeeListService implements BaseService<SpesificationRequest, PageResponse>{

    private EmployeeRepository employeeRepository;
    public EmployeeListService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public PageResponse execute(SpesificationRequest input) {
        Page<Employee> pageEmployee = employeeRepository.findAll(input.getSpecification(), input.getPageable());
        log.info("request all employee");
        return PageResponse.builder()
                .page(pageEmployee.isEmpty() ? null : pageEmployee)
                .build();
    }
   
}
