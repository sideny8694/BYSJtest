package com.XBGC.content.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/1/14 10:22
 */
@Data
public class EditCourseDto extends AddCourseDto {

 @ApiModelProperty(value = "课程id", required = true)
 private Long id;

}
