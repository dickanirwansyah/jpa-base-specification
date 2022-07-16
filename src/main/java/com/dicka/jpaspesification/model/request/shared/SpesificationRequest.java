package com.dicka.jpaspesification.model.request.shared;

import com.dicka.jpaspesification.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author dickanirwansyah
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpesificationRequest extends BaseRequest{
  
    private Specification specification;
    private Pageable pageable;
}
