package com.dicka.jpaspesification.model.response.shared;

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
public class RestResponse {
  
    private Object data;
    private String message;
    private Boolean result;
    
}
