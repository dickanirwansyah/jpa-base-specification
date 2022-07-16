package com.dicka.jpaspesification.model.response.shared;

import com.dicka.jpaspesification.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

/**
 *
 * @author dickanirwansyah
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse extends BaseResponse{
    private transient Page page;
}
