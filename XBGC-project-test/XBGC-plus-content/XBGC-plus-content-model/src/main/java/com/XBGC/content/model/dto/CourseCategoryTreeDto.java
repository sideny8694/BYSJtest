package com.XBGC.content.model.dto;

import com.XBGC.content.model.po.CourseCategory;
import lombok.Data;

import java.util.List;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/1/12 11:51
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory implements java.io.Serializable {

   //子节点
   List<CourseCategoryTreeDto> childrenTreeNodes;

}
