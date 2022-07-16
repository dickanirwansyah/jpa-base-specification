package com.dicka.jpaspesification.controller;

import com.dicka.jpaspesification.model.request.shared.SearchRequest;
import com.dicka.jpaspesification.model.response.shared.RestResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author dickanirwansyah
 */
@Slf4j
public class BaseController {
    
    
    protected ResponseEntity<RestResponse> getPageableResponse(Page dataPage){
        RestResponse response;
        if(ObjectUtils.isEmpty(dataPage)){
            log.info("data pageable not found");
            response = new RestResponse(dataPage.getContent(), "Data not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = new RestResponse(dataPage, "This is your data", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    protected Pageable getCommonPageable(SearchRequest request){
        int page = ObjectUtils.isEmpty(request.getStart())? 0 : request.getStart();
        int size = ObjectUtils.isEmpty(request.getLimit()) ? Integer.MAX_VALUE : request.getLimit();
        Boolean isAscending = StringUtils.isNotEmpty(request.getSort()) && request.getSort().equals("ASC");
        Sort.Direction sort = isAscending ? Sort.Direction.ASC : Sort.Direction.DESC;
        String sortBy = StringUtils.isEmpty(request.getSortBy()) ? "id" : request.getSortBy();
        return PageRequest.of(page, size, sort, sortBy);
    }
    
    protected Specification getCommonSpecs(String[] rootFields, Integer deleted, SearchRequest request){
        log.info("getCommonSpecs.. ");
        return Specification.where((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (ObjectUtils.isNotEmpty(deleted)){
                predicates.add(criteriaBuilder.equal(root.get("deleted"), deleted));
            }
            if (StringUtils.isNotEmpty(request.getTextSearch())){
                List<Predicate> predicateTexts = new ArrayList<>();
                for (String rootField : rootFields){
                    predicateTexts.add(criteriaBuilder.like(criteriaBuilder
                            .lower(root.get(rootField)), "%" + request.getTextSearch().toLowerCase() + "%"));
                }
                predicates.add(criteriaBuilder.or(predicateTexts.toArray(new Predicate[] {})));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
        });
    }
    
}
