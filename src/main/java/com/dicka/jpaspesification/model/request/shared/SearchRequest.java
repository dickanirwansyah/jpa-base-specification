package com.dicka.jpaspesification.model.request.shared;

import com.dicka.jpaspesification.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dickanirwansyah
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest extends BaseRequest{
    
    private String textSearch;
    private Integer start;
    private Integer limit;
    private String sortBy;
    private String sort;
}
