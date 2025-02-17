package com.XBGC.content.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class EditCourseDto extends AddCourseDto{


    @ApiModelProperty(value = "课程id",required = true)//swagger文档需要这蛤注解
    private Long id;
}
