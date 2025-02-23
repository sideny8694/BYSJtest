package com.XBGC.search.dto;

import com.XBGC.base.model.PageResult;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/25 17:51
 */
@Data
@ToString
public class SearchPageResultDto<T> extends PageResult {

    //大分类列表
    List<String> mtList;
    //小分类列表
    List<String> stList;

    public SearchPageResultDto(List<T> items, long counts, long page, long pageSize) {
        super(items, counts, page, pageSize);
    }

}
