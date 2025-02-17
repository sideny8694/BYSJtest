package com.XBGC.content.model.dto;

import com.XBGC.content.model.po.CourseCategory;
import lombok.Data;


import java.util.List;

/**
 * @description 课程分类树型结点dto
 * @author Mr.w
 * @date
 * @version 1.0
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory implements java.io.Serializable {
//Serializable将来需要网络传输序列化时可使用

    //子节点
    List<CourseCategoryTreeDto> childrenTreeNodes;
}
