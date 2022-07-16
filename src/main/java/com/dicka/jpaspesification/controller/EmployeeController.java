package com.dicka.jpaspesification.controller;

import com.dicka.jpaspesification.model.request.shared.SearchRequest;
import com.dicka.jpaspesification.model.request.shared.SpesificationRequest;
import com.dicka.jpaspesification.model.response.shared.RestResponse;
import com.dicka.jpaspesification.service.EmployeeListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dickanirwansyah
 */

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController extends BaseController{
    
    private EmployeeListService employeeListService;
    public EmployeeController(EmployeeListService employeeListService){
        this.employeeListService = employeeListService;
    }

    @GetMapping(value = "/v1/list")
    public ResponseEntity<RestResponse> getList(SearchRequest searchRequest){
        return getPageableResponse(this.employeeListService.execute(
                SpesificationRequest.builder()
                        .pageable(getCommonPageable(searchRequest))
                        .specification(getCommonSpecs(new String[] {"fullName", "position"}, 0, searchRequest))
                        .build()).getPage());
    }
}
