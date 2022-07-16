package com.dicka.jpaspesification.base;

/**
 *
 * @author dickanirwansyah
 */
public interface BaseService<T extends BaseRequest, V extends BaseResponse>{
    
    V execute(T input);
    
}
