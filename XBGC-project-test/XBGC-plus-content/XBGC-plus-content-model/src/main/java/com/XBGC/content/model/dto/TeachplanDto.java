package com.XBGC.content.model.dto;

import com.XBGC.content.model.po.Teachplan;
import com.XBGC.content.model.po.TeachplanMedia;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Mr.w
 * @version 1.0
 * @description 课程计划信息模型类
 * @date 2025/2/1/14 11:23
 */
@Data
@ToString
public class TeachplanDto extends Teachplan {
  //与媒资管理的信息
   private TeachplanMedia teachplanMedia;

  //小章节list
   private List<TeachplanDto> teachPlanTreeNodes;
}
